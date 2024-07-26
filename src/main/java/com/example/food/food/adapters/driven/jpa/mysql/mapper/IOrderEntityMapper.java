package com.example.food.food.adapters.driven.jpa.mysql.mapper;

import com.example.food.food.adapters.driven.jpa.mysql.entity.OrderDishesEntity;
import com.example.food.food.adapters.driven.jpa.mysql.entity.OrderEntity;
import com.example.food.food.adapters.driven.jpa.mysql.entity.RestaurantEntity;
import com.example.food.food.domain.models.DishOrder;
import com.example.food.food.domain.models.Order;
import com.example.food.food.domain.models.Restaurant;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IOrderEntityMapper {
    Order toModel(OrderEntity entity);
    OrderEntity toEntity(Order order);
    List<Order> toModelList(List<OrderEntity> orders);
    List<OrderDishesEntity> toEntityList(List<DishOrder> orders);
}
