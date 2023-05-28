package com.mvkuzn.restaurant.repository;

import com.mvkuzn.restaurant.dish.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Integer> {
}
