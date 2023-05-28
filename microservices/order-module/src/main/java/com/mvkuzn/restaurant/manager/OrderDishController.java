package com.mvkuzn.restaurant.manager;

import com.mvkuzn.restaurant.auth.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/order")
@RequiredArgsConstructor
public class OrderDishController {

    private final ManagerService service;

    @PostMapping("add/dish")
    public ResponseEntity<Response> addDish(
            @RequestBody AddDishRequest request
    ) {
        return ResponseEntity.ok(service.addDish(request));
    }

    @PostMapping("add/order")
    public ResponseEntity<Response> addOrderDish(
            @RequestBody AddOrderRequest request
    ) {
        return ResponseEntity.ok(service.addOrder(request));
    }

    @PostMapping("update/dish")
    public ResponseEntity<Response> updateDish(
            @RequestBody UpdateDishRequest request
    ) {
        return ResponseEntity.ok(service.updateDish(request));
    }

    @GetMapping("/get-menu")
    public ResponseEntity<Response> getMenu() {
        return ResponseEntity.ok(service.getMenu());
    }

    @GetMapping("/get-order")
    public ResponseEntity<Response> getOrder(
            @RequestBody GetOrderRequest request
    ) {
        return ResponseEntity.ok(service.getOrder(request));
    }
}
