package com.example.food.food.domain.api;

import com.example.food.food.domain.models.ActivableDish;
import com.example.food.food.domain.models.Dish;
import com.example.food.food.domain.models.UpdateDish;

import java.util.List;

public interface IDishServicePort {
    List<Dish> getAllDishes(Integer page, Integer count, long restaurantId);
    void createDish(Dish dish, Long userId);
    void updateDish(Long id, UpdateDish dish, Long userId);
    void activableDish(Long id, ActivableDish dish, Long userId);
}
