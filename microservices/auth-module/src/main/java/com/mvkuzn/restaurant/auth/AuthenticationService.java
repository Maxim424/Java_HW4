package com.mvkuzn.restaurant.auth;

import com.mvkuzn.restaurant.common.EmailValidator;
import com.mvkuzn.restaurant.config.JwtService;
import com.mvkuzn.restaurant.repository.SessionRepository;
import com.mvkuzn.restaurant.repository.UserRepository;
import com.mvkuzn.restaurant.session.Session;
import com.mvkuzn.restaurant.user.Role;
import com.mvkuzn.restaurant.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .role(Role.CUSTOMER)
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();

        if (!EmailValidator.isValidEmail(user.getEmail())) {
            throw new IllegalArgumentException("Incorrect email");
        }
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        var session = Session.builder()
                .sessionToken(jwtToken)
                .expiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .userId(user.getId())
                .build();
        sessionRepository.save(session);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var session = Session.builder()
                .sessionToken(jwtToken)
                .expiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .userId(user.getId())
                .build();
        sessionRepository.save(session);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public UserInfoResponse getInfo(GetUserRequest request) {
        var session = sessionRepository.findBySessionToken(request.getToken()).orElseThrow();
        var user = userRepository.findById(session.getUserId()).orElseThrow();
        return UserInfoResponse.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .role(user.getRole())
                .sessions(user.getSessions())
                .updatedAt(user.getUpdatedAt())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
