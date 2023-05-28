package com.mvkuzn.restaurant.repository;

import com.mvkuzn.restaurant.order_dish.OrderDish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDishRepository extends JpaRepository<OrderDish, Integer> {
}
