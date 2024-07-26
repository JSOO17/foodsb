package com.example.food.food.adapters.driven.jpa.mysql.repository;

import com.example.food.food.adapters.driven.jpa.mysql.entity.OrderDishesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDishesRepository extends JpaRepository<OrderDishesEntity, Long> {
}
