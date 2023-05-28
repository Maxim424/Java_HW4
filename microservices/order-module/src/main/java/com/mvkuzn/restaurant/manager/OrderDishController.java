package com.mvkuzn.restaurant.manager;

import com.mvkuzn.restaurant.auth.Response;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<Response> add_dish(
            @RequestBody AddDishRequest request
    ) {
        return ResponseEntity.ok(service.addDish(request));
    }

    @PostMapping("/add_order_dish")
    public ResponseEntity<Response> add_order_dish(
            @RequestBody AddOrderDishRequest request
    ) {
        return ResponseEntity.ok(service.addOrderDish(request));
    }
}
