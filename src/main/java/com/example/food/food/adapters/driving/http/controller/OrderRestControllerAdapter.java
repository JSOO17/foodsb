package com.example.food.food.adapters.driving.http.controller;

import com.example.food.food.adapters.driving.http.dto.request.AddOrderRequest;
import com.example.food.food.adapters.driving.http.dto.request.AddRestaurantRequest;
import com.example.food.food.adapters.driving.http.dto.response.OrderResponse;
import com.example.food.food.adapters.driving.http.mapper.orders.IOrderRequestMapper;
import com.example.food.food.adapters.driving.http.mapper.orders.IOrderResponseMapper;
import com.example.food.food.domain.api.IOrderServicePort;
import com.example.food.food.domain.exception.InvalidBodyException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderRestControllerAdapter {
    private final IOrderServicePort port;
    private final IOrderResponseMapper responseMapper;
    private final IOrderRequestMapper requestMapper;

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        var orders = port.getAllOrders();
        return ResponseEntity.ok(responseMapper.toResponseList(orders));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getRestaurantById(@PathVariable Long id) {
        var order = port.getOrderById(id).orElseThrow();
        return ResponseEntity.ok(responseMapper.toResponse(order));
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody AddOrderRequest request) {

        port.createOrder(requestMapper.addRequestToOrder(request));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
