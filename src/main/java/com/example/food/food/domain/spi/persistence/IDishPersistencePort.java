package com.example.food.food.domain.spi.persistence;

import com.example.food.food.domain.models.Dish;
import com.example.food.food.domain.models.UpdateDish;

import java.util.List;
import java.util.Optional;

public interface IDishPersistencePort {
    List<Dish> getAllDishes(Integer page, Integer count, long restaurantId);
    void createDish(Dish dish);
    void updateDish(Long id, UpdateDish dish);
    void activableDish(Long id, boolean isActive);

    Optional<Dish> getDishById(Long id);
}
