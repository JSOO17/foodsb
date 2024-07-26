package com.example.food.food.adapters.driving.http.mapper.dishes;

import com.example.food.food.adapters.driving.http.dto.response.DishResponse;
import com.example.food.food.adapters.driving.http.dto.response.OrderResponse;
import com.example.food.food.domain.models.Dish;
import com.example.food.food.domain.models.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDishResponseMapper {
    DishResponse toResponse(Dish dish);
    List<DishResponse> toResponseList(List<Dish> dishes);
}
