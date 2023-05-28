package com.mvkuzn.restaurant.manager;

import com.mvkuzn.restaurant.dish.Dish;
import com.mvkuzn.restaurant.repository.DishRepository;
import com.mvkuzn.restaurant.repository.OrderDishRepository;
import com.mvkuzn.restaurant.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class ManagerService {

    private final DishRepository dishRepository;
    private final OrderRepository orderRepository;
    private final OrderDishRepository orderDishRepository;

    public StatusResponse addDish(AddDishRequest request) {
        var dish = Dish.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .isAvailable(true)
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();

        dishRepository.save(dish);
        return StatusResponse.builder()
                .status("ok")
                .message("Dish saved")
                .build();
    }
}
