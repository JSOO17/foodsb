package com.example.food.food.adapters.driving.http.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class AddDishRequest {
    @NotBlank(message = "name is required.")
    private String Name;
    @NotBlank(message = "description is required.")
    private String Description;
    @Positive
    private BigDecimal Price;
    @NotBlank(message = "urlImage is required.")
    private String UrlImagen;
    private Long CategoryId;
    private Long RestaurantId;
}
