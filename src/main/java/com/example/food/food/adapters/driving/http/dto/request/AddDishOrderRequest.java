package com.example.food.food.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddDishOrderRequest {
    private Long DishId;
    private Integer Cuantity;
}
