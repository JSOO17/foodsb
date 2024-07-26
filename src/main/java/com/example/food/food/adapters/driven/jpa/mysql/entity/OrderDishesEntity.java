package com.example.food.food.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orderdishes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDishesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long DishId;
    private Integer Cuantity;
    private Long OrderId;
}
