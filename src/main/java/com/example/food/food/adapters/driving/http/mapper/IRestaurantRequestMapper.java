package com.example.food.food.adapters.driving.http.mapper;

import com.example.food.food.adapters.driving.http.dto.request.AddEmployeeRequest;
import com.example.food.food.adapters.driving.http.dto.request.AddRestaurantRequest;
import com.example.food.food.adapters.driving.http.dto.request.UpdateRestaurantRequest;
import com.example.food.food.domain.models.Restaurant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IRestaurantRequestMapper {
    Restaurant addRequestToRestaurant(AddRestaurantRequest request);
    Restaurant updateRequestToRestaurant(UpdateRestaurantRequest request);
}
