package com.example.food.food.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurants")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "ownerId")
    private Long ownerId;
    @Column(name = "cellphone")
    private String cellphone;
    @Column(name = "urlLogo")
    private String urlLogo;
    @Column(name = "nit")
    private Integer nit;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DishEntity> dishes = new ArrayList<>();
}
