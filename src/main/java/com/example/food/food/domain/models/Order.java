package com.example.food.food.domain.models;

import com.example.food.food.domain.exception.EmptyFieldException;
import com.example.food.food.domain.utils.States;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class Order {
    private Long Id;
    private Long clientId;
    private LocalDateTime Date;
    private String state;
    private String Code;
    private Long ChefId;
    private Long RestaurantId;
    private List<DishOrder> Dishes;

    public Order(Long id, Long clientId, LocalDateTime date, String code, Long chefId, Long restaurantId, List<DishOrder> dishes) {

        if (clientId == null) {
            throw new EmptyFieldException("clientId is required.");
        }

        if (date == null) {
            throw new EmptyFieldException("date is required.");
        }

        if (chefId == null) {
            throw new EmptyFieldException("chefId is required.");
        }

        if (restaurantId == null) {
            throw new EmptyFieldException("restaurantId is required.");
        }

        Id = id;
        this.clientId = clientId;
        Date = date;
        Code = code;
        ChefId = chefId;
        RestaurantId = restaurantId;
        Dishes = dishes;
    }
}
