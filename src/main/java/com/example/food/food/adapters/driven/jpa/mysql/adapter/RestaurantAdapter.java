package com.example.food.food.adapters.driven.jpa.mysql.adapter;

import com.example.food.food.adapters.driven.jpa.mysql.entity.RestaurantEntity;
import com.example.food.food.adapters.driven.jpa.mysql.mapper.IDishEntityMapper;
import com.example.food.food.adapters.driven.jpa.mysql.mapper.IRestaurantEntityMapper;
import com.example.food.food.adapters.driven.jpa.mysql.repository.IDishRepository;
import com.example.food.food.adapters.driven.jpa.mysql.repository.IRestaurantRepository;
import com.example.food.food.domain.models.Dish;
import com.example.food.food.domain.models.Restaurant;
import com.example.food.food.domain.spi.persistence.IRestaurantPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class RestaurantAdapter implements IRestaurantPersistencePort {
    private final IRestaurantRepository restaurantRepository;
    private final IDishRepository dishRepository;
    private final IRestaurantEntityMapper restaurantEntityMapper;
    private final IDishEntityMapper dishEntityMapper;

    public List<Restaurant> getAllRestaurants() {
        var restaurants = restaurantRepository.findAll();
        return restaurantEntityMapper.toModelList(restaurants);
    }

    public Optional<Restaurant> getRestaurantById(Long id) {
        return restaurantRepository.findById(id).map(restaurantEntityMapper::toModel);
    }

    @Override
    public List<Dish> getAllDishesByRestaurantId(Long restaurantId) {
        return dishEntityMapper.toModelList(dishRepository.findDishEntityByRestaurantId(restaurantId));
    }

    @Override
    public Optional<Restaurant> getRestaurantByDishId(Long dishId) {
        return Optional.empty();
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        RestaurantEntity entity = restaurantEntityMapper.toEntity(restaurant);
        return restaurantEntityMapper.toModel(restaurantRepository.save(entity));
    }

    public Restaurant updateRestaurant(Long id, Restaurant restaurantDetails) {
        RestaurantEntity entity = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
        entity.setName(restaurantDetails.getName());
        return restaurantEntityMapper.toModel(restaurantRepository.save(entity));
    }

    @Override
    public boolean isRestaurantExists(Long id) {
        return restaurantRepository.existsById(id);
    }

    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }
}
