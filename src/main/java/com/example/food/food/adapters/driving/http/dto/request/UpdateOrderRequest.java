package com.example.food.food.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdateOrderRequest {
    private Long clientId;
    private java.util.Date Date;
    private String state;
    private String Code;
    private Long ChefId;
    private Long RestaurantId;
}
