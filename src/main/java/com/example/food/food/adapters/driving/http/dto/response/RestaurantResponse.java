package com.example.food.food.adapters.driving.http.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class RestaurantResponse {
    private Long id;
    private String name;
    private String address;
    private Long ownerId;
    private String cellphone;
    private String urlLogo;
    private Integer nit;
}
