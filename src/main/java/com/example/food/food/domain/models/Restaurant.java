package com.example.food.food.domain.models;

import com.example.food.food.domain.exception.EmptyFieldException;
import com.example.food.food.domain.exception.InvalidCellphoneException;
import com.example.food.food.domain.exception.InvalidNameRestaurantException;
import lombok.Getter;
import lombok.Setter;

import java.util.regex.Pattern;

@Setter
@Getter
public class Restaurant {
    private Long id;
    private String name;
    private String address;
    private Long ownerId;
    private String cellphone;
    private String urlLogo;
    private Integer nit;

    private static final Pattern LETTER_PATTERN = Pattern.compile(".*[a-zA-Z]+.*");

    public Restaurant(Long id, String name, String address, Long ownerId, String cellphone, String urlLogo, Integer nit) {

        if (name.trim().isEmpty()) {
            throw new EmptyFieldException("name is required.");
        }

        if (!LETTER_PATTERN.matcher(name).matches()) {
            throw new InvalidNameRestaurantException("name needs to have at least a letter.");
        }

        if (address.trim().isEmpty()) {
            throw new EmptyFieldException("address is required.");
        }

        if (ownerId == null) {
            throw new EmptyFieldException("ownerId is required.");
        }

        if (cellphone.trim().isEmpty()) {
            throw new EmptyFieldException("cellphone is required.");
        }

        if (!cellphone.matches("[0-9+]+")) {
            throw new InvalidCellphoneException("cellphone is only 13 characters");
        }

        if (urlLogo.trim().isEmpty()) {
            throw new EmptyFieldException("urlLogo is required.");
        }

        if (nit == null) {
            throw new EmptyFieldException("nit is required.");
        }

        this.id = id;
        this.name = name;
        this.address = address;
        this.ownerId = ownerId;
        this.cellphone = cellphone;
        this.urlLogo = urlLogo;
        this.nit = nit;
    }
}
