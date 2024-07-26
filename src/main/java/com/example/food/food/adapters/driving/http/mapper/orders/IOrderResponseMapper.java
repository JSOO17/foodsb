package com.example.food.food.adapters.driving.http.mapper.orders;

import com.example.food.food.adapters.driving.http.dto.response.OrderResponse;
import com.example.food.food.domain.models.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IOrderResponseMapper {
    OrderResponse toResponse(Order order);
    List<OrderResponse> toResponseList(List<Order> orders);
}
