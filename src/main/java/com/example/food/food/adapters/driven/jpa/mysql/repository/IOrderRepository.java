package com.example.food.food.adapters.driven.jpa.mysql.repository;

import com.example.food.food.adapters.driven.jpa.mysql.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderRepository extends JpaRepository<OrderEntity, Long> {
    boolean existsByClientIdAndStateIn(Long ClientId, List<String> states);
}
