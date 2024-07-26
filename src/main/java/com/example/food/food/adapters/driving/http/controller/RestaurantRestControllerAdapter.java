package com.example.food.food.adapters.driving.http.controller;

import com.example.food.food.adapters.driving.http.dto.request.AddEmployeeRequest;
import com.example.food.food.adapters.driving.http.dto.request.AddRestaurantRequest;
import com.example.food.food.adapters.driving.http.dto.response.DishResponse;
import com.example.food.food.adapters.driving.http.dto.response.RestaurantExistsResponse;
import com.example.food.food.adapters.driving.http.dto.response.RestaurantResponse;
import com.example.food.food.adapters.driving.http.mapper.IRestaurantRequestMapper;
import com.example.food.food.adapters.driving.http.mapper.IRestaurantResponseMapper;
import com.example.food.food.adapters.driving.http.mapper.dishes.IDishResponseMapper;
import com.example.food.food.domain.api.IRestaurantServicePort;
import com.example.food.food.domain.exception.InvalidBodyException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
public class RestaurantRestControllerAdapter {
    private  final IRestaurantServicePort port;
    private final IRestaurantRequestMapper requestMapper;
    private final IRestaurantResponseMapper responseMapper;
    private final IDishResponseMapper dishResponseMapper;

    @GetMapping
    public ResponseEntity<List<RestaurantResponse>> getAllRestaurants() {
        var restaurants = port.getAllRestaurants();
        return ResponseEntity.ok(responseMapper.toResponseList(restaurants));
    }

    @GetMapping("/{id}/dish")
    public ResponseEntity<List<DishResponse>> getAllDishesByRestaurantId(@PathVariable Long id) {
        var dishes = port.getAllDishesByRestaurantId(id);
        return ResponseEntity.ok(dishResponseMapper.toResponseList(dishes));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponse> getRestaurantById(@PathVariable Long id) {
        var restaurant = port.getRestaurantById(id).orElseThrow();
        return ResponseEntity.ok(responseMapper.toResponse(restaurant));
    }

    @PostMapping
    public ResponseEntity<Void> createRestaurant(@RequestBody AddRestaurantRequest request, @RequestAttribute("userId") String userId) {
        port.createRestaurant(requestMapper.addRequestToRestaurant(request));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}/exists")
    public ResponseEntity<RestaurantExistsResponse> isRestaurantExists(@PathVariable Long id) {
        return ResponseEntity.ok(new RestaurantExistsResponse(port.isRestaurantExists(id)));
    }
}
