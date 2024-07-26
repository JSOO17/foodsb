package com.example.food.food.adapters.driving.http.controller;

import com.example.food.food.adapters.driving.http.dto.request.ActivableDishRequest;
import com.example.food.food.adapters.driving.http.dto.request.AddDishRequest;
import com.example.food.food.adapters.driving.http.dto.request.UpdateDishRequest;
import com.example.food.food.adapters.driving.http.mapper.dishes.*;
import com.example.food.food.domain.api.IDishServicePort;
import com.example.food.food.domain.exception.InvalidBodyException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dish")
@RequiredArgsConstructor
public class DishRestControllerAdapter {
    private final IDishServicePort port;
    private final IDishResponseMapper responseMapper;
    private final IDishRequestMapper requestMapper;

    @PostMapping
    public ResponseEntity<Void> createDish(@RequestBody AddDishRequest request, @RequestAttribute("userId") String userId) {

        port.createDish(requestMapper.addRequestToDish(request), Long.parseLong(userId));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateDish(@RequestBody UpdateDishRequest request, @PathVariable Long id, @RequestAttribute("userId") String userId)
    {
        port.updateDish(id, requestMapper.updateRequestToDish(request), Long.parseLong(userId));

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}/activable")
    public ResponseEntity<Void> activable(@RequestBody ActivableDishRequest request, @PathVariable Long id, @RequestAttribute("userId") String userId)
    {
        port.activableDish(id, requestMapper.toModel(request), Long.parseLong(userId));

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    private List<String> getRoles() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
    }
}
