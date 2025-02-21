package com.example.food.food.configuration.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ExceptionResponse {
    private final String message;
    private final String status;
    private final LocalDateTime timestamp;
}
