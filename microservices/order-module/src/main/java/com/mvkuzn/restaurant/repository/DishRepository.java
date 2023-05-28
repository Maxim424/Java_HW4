package com.mvkuzn.restaurant.repository;

import com.mvkuzn.restaurant.dish.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DishRepository extends JpaRepository<Dish, Integer> {

    Optional<List<Dish>> findByIsAvailable(Boolean available);
}
