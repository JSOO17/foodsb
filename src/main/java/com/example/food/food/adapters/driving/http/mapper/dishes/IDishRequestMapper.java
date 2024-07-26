package com.example.food.food.adapters.driving.http.mapper.dishes;

import com.example.food.food.adapters.driving.http.dto.request.ActivableDishRequest;
import com.example.food.food.adapters.driving.http.dto.request.AddDishRequest;
import com.example.food.food.adapters.driving.http.dto.request.UpdateDishRequest;
import com.example.food.food.domain.models.ActivableDish;
import com.example.food.food.domain.models.Dish;
import com.example.food.food.domain.models.UpdateDish;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IDishRequestMapper {
    Dish addRequestToDish(AddDishRequest request);

    UpdateDish updateRequestToDish(UpdateDishRequest request);
    ActivableDish toModel(ActivableDishRequest request);
}
