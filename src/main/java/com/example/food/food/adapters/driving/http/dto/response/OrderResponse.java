package com.example.food.food.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderResponse {
    private Long Id;
    private Long ClientId;
    private LocalDateTime Date;
    private String State;
    private String Code;
    private Long ChefId;
    private Long RestaurantId;
}
