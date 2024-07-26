package com.example.food.food.domain.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DishOrder {
    private Long DishId;
    private Integer Cuantity;
    private Long OrderId;
}
