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
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Service
@RequiredArgsConstructor
public class ManagerService {

    private final DishRepository dishRepository;
    private final OrderRepository orderRepository;
    private final OrderDishRepository orderDishRepository;
    private final UserRepository userRepository;

    public AddDishResponse addDish(AddDishRequest request) {
        var dish = Dish.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .isAvailable(request.getAvailable())
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();

        dishRepository.save(dish);
        return AddDishResponse.builder()
                .dish(dish)
                .build();
    }

    public AddOrderResponse addOrder(AddOrderRequest request) {
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var order = Order.builder()
                .userId(user.getId())
                .status(OrderStatus.WAITING)
                .specialRequests(request.getSpecialRequests())
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
        orderRepository.save(order);
        var dishes = request.getDishes();
        for (var item: dishes) {
            var dish = dishRepository.findById(item.getId()).orElseThrow();
            var orderDish = OrderDish.builder()
                    .orderId(order.getId())
                    .dishId(item.getId())
                    .quantity(item.getQuantity())
                    .price(item.getQuantity() * dish.getPrice())
                    .build();
            orderDishRepository.save(orderDish);
        }
        manageOrders();
        return AddOrderResponse.builder()
                .order(order)
                .build();
    }

    public GetMenuResponse getMenu() {
        List<Dish> menu = dishRepository.findByIsAvailable(true).orElseThrow();
        return GetMenuResponse.builder()
                .menu(menu)
                .build();
    }

    public GetOrderResponse getOrder(GetOrderRequest request) {
        var order = orderRepository.findById(request.getId()).orElseThrow();
        return GetOrderResponse.builder()
                .order(order)
                .build();
    }

    public void manageOrders() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                var orders = orderRepository.findAll();
                for (var item: orders) {
                    item.setStatus(OrderStatus.DONE);
                    item.setUpdatedAt(new Date());
                    orderRepository.save(item);
                }
            }
        };
        // Заказы будут готовы через 15 секунд после запуска этого метода.
        timer.schedule(task, 15000);
    }

    public AddDishResponse updateDish(UpdateDishRequest request) {
        var dish = dishRepository.findById(request.getId()).orElseThrow();
        dish.setQuantity(request.getQuantity());
        dish.setUpdatedAt(new Date());
        dishRepository.save(dish);
        return AddDishResponse.builder()
                .dish(dish)
                .build();
    }
}
