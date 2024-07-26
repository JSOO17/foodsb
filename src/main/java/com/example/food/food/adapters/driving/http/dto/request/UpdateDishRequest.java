package com.example.food.food.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class UpdateDishRequest {
    private String Description;
    private BigDecimal Price;
}
