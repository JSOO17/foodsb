package com.example.food.food.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class AddOrderRequest {
    private Long clientId;
    private java.util.Date Date;
    private String Code;
    private Long ChefId;
    private Long RestaurantId;
    private List<AddDishOrderRequest> dishes;
}
