package com.mvkuzn.restaurant.repository;

import com.mvkuzn.restaurant.session.Session;
import com.mvkuzn.restaurant.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Integer> {

    Optional<Session> findBySessionToken(String token);
}
