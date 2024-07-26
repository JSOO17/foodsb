package com.example.food.food.configuration.exceptionHandler;

import com.example.food.food.domain.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvisor {
    @ExceptionHandler(EmptyFieldException.class)
    public ResponseEntity<ExceptionResponse> handleEmptyFieldException(EmptyFieldException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(InvalidNameRestaurantException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidNameRestaurantException(InvalidNameRestaurantException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(InvalidCellphoneException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidCellphoneException(InvalidCellphoneException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(NegativeNotAllowedException.class)
    public ResponseEntity<ExceptionResponse> handleNegativeNotAllowedException(NegativeNotAllowedException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                "Price should be positive.",
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ExceptionResponse> handleElementNotFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(
                "Resource not found.", HttpStatus.CONFLICT.toString(), LocalDateTime.now()));

    }

    @ExceptionHandler(ClientHasOrderException.class)
    public ResponseEntity<ExceptionResponse> handleClientHasOrderException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponse(
                "Client has already a order.", HttpStatus.CONFLICT.toString(), LocalDateTime.now()));

    }
}
