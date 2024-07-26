package com.example.food.food.domain.api;

import java.util.List;
import java.util.Optional;

import com.example.food.food.domain.models.Dish;
import com.example.food.food.domain.models.Restaurant;

public interface IRestaurantServicePort {
   public List<Restaurant> getAllRestaurants();
   public List<Dish> getAllDishesByRestaurantId(Long restaurantId);

   public Optional<Restaurant> getRestaurantById(Long id);

   public Restaurant createRestaurant(Restaurant restaurant);

   public Restaurant updateRestaurant(Long id, Restaurant restaurantDetails);
   public boolean isRestaurantExists(Long id);
}
