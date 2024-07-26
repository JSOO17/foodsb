package com.example.food.food.adapters.driven.jpa.mysql.mapper;

import com.example.food.food.adapters.driven.jpa.mysql.entity.RestaurantEntity;
import com.example.food.food.domain.models.Restaurant;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IRestaurantEntityMapper {
    Restaurant toModel(RestaurantEntity entity);
    RestaurantEntity toEntity(Restaurant restaurant);
    List<Restaurant> toModelList(List<RestaurantEntity> restaurantEntities);
}
