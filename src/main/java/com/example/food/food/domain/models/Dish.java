package com.example.food.food.domain.models;

import com.example.food.food.domain.exception.EmptyFieldException;
import com.example.food.food.domain.exception.NegativeNotAllowedException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Setter
@Getter
public class Dish {
    private Long Id;
    private String Name;
    private String Description;
    private BigDecimal Price;
    private String UrlImagen;
    private boolean IsActive;
    private Long CategoryId;
    private Long RestaurantId;

    public Dish(Long id, String name, String description, BigDecimal price, String urlImagen, boolean isActive, Long categoryId, Long restaurantId) {

        if (name.trim().isEmpty()) {
            throw new EmptyFieldException("Name is required.");
        }

        if (description.trim().isEmpty()) {
            throw new EmptyFieldException("Description is required.");
        }

        if (price == null) {
            throw new EmptyFieldException("Name is required.");
        }

        if (!(price.compareTo(BigDecimal.ZERO) >= 0)) {
            throw new NegativeNotAllowedException();
        }

        if (urlImagen.trim().isEmpty()) {
            throw new EmptyFieldException("UrlImagen is required.");
        }

        if (categoryId == null) {
            throw new EmptyFieldException("CategoryId is required.");
        }

        if (restaurantId == null) {
            throw new EmptyFieldException("RestaurantId is required.");
        }

        Id = id;
        Name = name;
        Description = description;
        Price = price;
        UrlImagen = urlImagen;
        IsActive = isActive;
        CategoryId = categoryId;
        RestaurantId = restaurantId;
    }
}
