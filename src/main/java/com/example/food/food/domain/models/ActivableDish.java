package com.example.food.food.domain.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ActivableDish {
    private boolean IsActive;

    public ActivableDish(boolean isActive) {
        IsActive = isActive;
    }
}
