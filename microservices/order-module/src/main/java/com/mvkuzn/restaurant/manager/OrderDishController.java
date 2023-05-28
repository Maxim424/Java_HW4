package com.mvkuzn.restaurant.manager;

import com.mvkuzn.restaurant.auth.AuthenticationService;
import com.mvkuzn.restaurant.auth.ErrorResponse;
import com.mvkuzn.restaurant.auth.RegisterRequest;
import com.mvkuzn.restaurant.auth.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/order")
@RequiredArgsConstructor
public class OrderDishController {

    private final ManagerService service;

    @PostMapping("/add_dish")
    public ResponseEntity<Response> register(
            @RequestBody AddDishRequest request
    ) {
        return ResponseEntity.ok(service.addDish(request));
    }
}
