package com.example.food.food.domain.api.useCases;

import java.util.List;
import java.util.Optional;

import com.example.food.food.domain.api.IRestaurantServicePort;
import com.example.food.food.domain.models.Dish;
import com.example.food.food.domain.models.Restaurant;
import com.example.food.food.domain.spi.persistence.IRestaurantPersistencePort;

public class RestaurantUseCase implements IRestaurantServicePort{

   private final IRestaurantPersistencePort restaurantPersistencePort;
   public RestaurantUseCase(IRestaurantPersistencePort restaurantPersistencePort) {
      this.restaurantPersistencePort = restaurantPersistencePort;
   }

   @Override
   public List<Restaurant> getAllRestaurants() {
      return restaurantPersistencePort.getAllRestaurants();
   }

   @Override
   public List<Dish> getAllDishesByRestaurantId(Long restaurantId) {
      return restaurantPersistencePort.getAllDishesByRestaurantId(restaurantId);
   }

   @Override
   public Optional<Restaurant> getRestaurantById(Long id) {
     return restaurantPersistencePort.getRestaurantById(id);
   }

   @Override
   public Restaurant createRestaurant(Restaurant restaurant) {
      return restaurantPersistencePort.createRestaurant(restaurant);
   }

   @Override
   public Restaurant updateRestaurant(Long id, Restaurant restaurantDetails) {
      return restaurantPersistencePort.updateRestaurant(id, restaurantDetails);
   }

   @Override
   public boolean isRestaurantExists(Long id) {
      return restaurantPersistencePort.isRestaurantExists(id);
   }
}
