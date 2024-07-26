package com.example.food.food.adapters.driven.jpa.mysql.mapper;

import com.example.food.food.adapters.driven.jpa.mysql.entity.DishEntity;
import com.example.food.food.adapters.driven.jpa.mysql.entity.OrderEntity;
import com.example.food.food.domain.models.Dish;
import com.example.food.food.domain.models.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDishEntityMapper {
    Dish toModel(DishEntity entity);
    DishEntity toEntity(Dish dish);
    List<Dish> toModelList(List<DishEntity> dishes);
}
