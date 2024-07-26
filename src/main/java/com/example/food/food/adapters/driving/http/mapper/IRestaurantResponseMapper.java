package com.example.food.food.adapters.driving.http.mapper;

import com.example.food.food.adapters.driving.http.dto.response.RestaurantResponse;
import com.example.food.food.domain.models.Restaurant;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IRestaurantResponseMapper {
    RestaurantResponse toResponse(Restaurant restaurant);
    List<RestaurantResponse> toResponseList(List<Restaurant> restaurants);
}
