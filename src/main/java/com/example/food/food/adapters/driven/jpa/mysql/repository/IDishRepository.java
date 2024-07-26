package com.example.food.food.adapters.driven.jpa.mysql.repository;

import com.example.food.food.adapters.driven.jpa.mysql.entity.DishEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDishRepository extends JpaRepository<DishEntity, Long> {
    Page<DishEntity> findAll(Pageable pageable);
    List<DishEntity> findDishEntityByRestaurantId(Long restaurantId);
}
