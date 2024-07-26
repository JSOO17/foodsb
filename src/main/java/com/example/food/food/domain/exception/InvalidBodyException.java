package com.example.food.food.domain.exception;

import lombok.Getter;
import org.springframework.validation.ObjectError;

import java.util.List;

@Getter
public class InvalidBodyException extends RuntimeException {
    private final List<ObjectError> errors;
    public InvalidBodyException(String message, List<ObjectError> errors) {
        super(message);
        this.errors = errors;
    }
}