package com.example.food.food.domain.spi.persistence;

import java.util.List;
import java.util.Optional;

import com.example.food.food.domain.models.Dish;
import com.example.food.food.domain.models.Restaurant;

public interface IRestaurantPersistencePort {
   public List<Restaurant> getAllRestaurants();

   public Optional<Restaurant> getRestaurantById(Long id);
   public List<Dish> getAllDishesByRestaurantId(Long restaurantId);

   public Optional<Restaurant> getRestaurantByDishId(Long dishId);

   public Restaurant createRestaurant(Restaurant restaurant);

   public Restaurant updateRestaurant(Long id, Restaurant restaurantDetails);
   public boolean isRestaurantExists(Long id);

}
