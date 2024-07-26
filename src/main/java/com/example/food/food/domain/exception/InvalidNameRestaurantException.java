package com.example.food.food.domain.exception;

public class InvalidNameRestaurantException extends RuntimeException {
    public InvalidNameRestaurantException(String message) {
        super(message);
    }
}
