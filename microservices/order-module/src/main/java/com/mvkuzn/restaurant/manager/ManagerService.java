package com.mvkuzn.restaurant.manager;

import com.mvkuzn.restaurant.dish.Dish;
import com.mvkuzn.restaurant.order.Order;
import com.mvkuzn.restaurant.order.OrderStatus;
import com.mvkuzn.restaurant.order_dish.OrderDish;
import com.mvkuzn.restaurant.repository.DishRepository;
import com.mvkuzn.restaurant.repository.OrderDishRepository;
import com.mvkuzn.restaurant.repository.OrderRepository;
import com.mvkuzn.restaurant.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class ManagerService {

    private final DishRepository dishRepository;
    private final OrderRepository orderRepository;
    private final OrderDishRepository orderDishRepository;
    private final UserRepository userRepository;

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

    public StatusResponse addOrderDish(AddOrderDishRequest request) {
        var user = userRepository.findByEmail(request.getEmail()).get();
        var order = Order.builder()
                .userId(user.getId())
                .status(OrderStatus.WAITING)
                .specialRequests(request.getSpecialRequests())
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
        orderRepository.save(order);
        var dish = dishRepository.findById(request.getDishId()).get();
        var orderDish = OrderDish.builder()
                .orderId(order.getId())
                .dishId(request.getDishId())
                .quantity(request.getQuantity())
                .price(dish.getPrice())
                .build();
        orderDishRepository.save(orderDish);
        return StatusResponse.builder()
                .status("ok")
                .message("Order created")
                .build();
    }
}
