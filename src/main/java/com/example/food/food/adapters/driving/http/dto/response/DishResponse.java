package com.example.food.food.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DishResponse {
    private Long Id;
    private String Name;
    private String Description;
    private BigDecimal Price;
    private String UrlImagen;
    private boolean IsActive;
    private Long CategoryId;
    private Long RestaurantId;
}
