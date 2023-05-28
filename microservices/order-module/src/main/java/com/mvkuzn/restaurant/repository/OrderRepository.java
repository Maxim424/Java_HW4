package com.mvkuzn.restaurant.repository;

import com.mvkuzn.restaurant.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
