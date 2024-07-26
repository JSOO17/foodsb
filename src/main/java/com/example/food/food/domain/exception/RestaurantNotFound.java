package com.example.food.food.domain.exception;

import java.text.MessageFormat;

public class RestaurantNotFound extends RuntimeException {
    public RestaurantNotFound(String id) {
        super(MessageFormat.format("The restaurant {0} does not exists.", id));
    }
}
