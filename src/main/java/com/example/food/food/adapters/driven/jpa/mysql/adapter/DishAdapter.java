package com.example.food.food.adapters.driven.jpa.mysql.adapter;

import com.example.food.food.adapters.driven.jpa.mysql.mapper.IDishEntityMapper;
import com.example.food.food.adapters.driven.jpa.mysql.repository.IDishRepository;
import com.example.food.food.domain.exception.ResourceNotFound;
import com.example.food.food.domain.models.Dish;
import com.example.food.food.domain.models.UpdateDish;
import com.example.food.food.domain.spi.persistence.IDishPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class DishAdapter implements IDishPersistencePort {
    private final IDishRepository dishRepository;
    private final IDishEntityMapper mapper;

    @Override
    public List<Dish> getAllDishes(Integer page, Integer count, long restaurantId) {
        var pagination = PageRequest.of(page, count);
        return dishRepository.findAll(pagination).stream().map(mapper::toModel).toList();
    }

    @Override
    public void createDish(Dish dish) {
        dishRepository.save(mapper.toEntity(dish));
    }

    @Override
    public void updateDish(Long id, UpdateDish dish) {
        var result = dishRepository.findById(id);

        if (result.isEmpty()) {
            throw new ResourceNotFound();
        }

        var newDish = result.get();
        if (dish.getDescription() != null) newDish.setDescription(dish.getDescription());
        if (dish.getPrice() != null) newDish.setPrice(dish.getPrice());

        dishRepository.save(newDish);
    }

    @Override
    public void activableDish(Long id, boolean isActive) {
        var result = dishRepository.findById(id);

        if (result.isEmpty()) {
            throw new ResourceNotFound();
        }

        var newDish = result.get();
        newDish.setIsActive(isActive);

        dishRepository.save(newDish);
    }

    @Override
    public Optional<Dish> getDishById(Long id) {
        var result = dishRepository.findById(id);

        return result.map(mapper::toModel);
    }
}
