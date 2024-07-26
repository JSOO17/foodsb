package com.example.food.food.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddRestaurantRequest {
    private String name;
    private String address;
    private Long ownerId;
    private String cellphone;
    private String urlLogo;
    private Integer nit;
}
