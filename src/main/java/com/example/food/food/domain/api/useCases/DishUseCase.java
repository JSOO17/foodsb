package com.example.food.food.domain.api.useCases;

import com.example.food.food.domain.api.IDishServicePort;
import com.example.food.food.domain.exception.RestaurantNotFound;
import com.example.food.food.domain.exception.RoleHasNotPermissionException;
import com.example.food.food.domain.models.ActivableDish;
import com.example.food.food.domain.models.Dish;
import com.example.food.food.domain.models.UpdateDish;
import com.example.food.food.domain.spi.persistence.IDishPersistencePort;
import com.example.food.food.domain.spi.persistence.IRestaurantPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class DishUseCase implements IDishServicePort {
    private final IDishPersistencePort port;
    private final IRestaurantPersistencePort restaurantPort;

    @Override
    public List<Dish> getAllDishes(Integer page, Integer count, long restaurantId) {
        return port.getAllDishes(page, count, restaurantId);
    }

    @Override
    public void createDish(Dish dish, Long userId) {

        validateOwnerByRestaurant(dish.getRestaurantId(), userId);

        dish.setIsActive(true);
        port.createDish(dish);
    }
    @Override
    public void updateDish(Long id, UpdateDish dish, Long userId) {

        var restaurantId = port.getDishById(id).orElseThrow().getRestaurantId();

        validateOwnerByRestaurant(restaurantId, userId);

        port.updateDish(id, dish);
    }

    @Override
    public void activableDish(Long id, ActivableDish dish, Long userId) {
        var restaurantId = port.getDishById(id).orElseThrow().getRestaurantId();

        validateOwnerByRestaurant(restaurantId, userId);

        port.activableDish(id, dish.isIsActive());
    }

    private void validateOwnerByRestaurant(Long restaurantId, Long userId) {
        var ownerId = restaurantPort.getRestaurantById(restaurantId)
                                    .orElseThrow(() -> new RestaurantNotFound(restaurantId.toString()))
                                    .getOwnerId();

        if (!Objects.equals(ownerId, userId)){
            throw new RoleHasNotPermissionException("you don't have permissions.");
        }
    }
}
