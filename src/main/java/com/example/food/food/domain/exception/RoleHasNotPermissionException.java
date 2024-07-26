package com.example.food.food.domain.exception;

public class RoleHasNotPermissionException extends RuntimeException {
    public RoleHasNotPermissionException(String message) {
        super(message);
    }
}