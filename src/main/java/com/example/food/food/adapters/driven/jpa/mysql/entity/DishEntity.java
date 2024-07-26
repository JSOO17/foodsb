package com.example.food.food.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "dishes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DishEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Name;
    private String Description;
    private BigDecimal Price;
    private String UrlImagen;
    private boolean IsActive;
    private Long CategoryId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RestaurantId")
    private RestaurantEntity restaurant;
}
