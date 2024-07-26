package com.example.food.food.configuration;

import com.example.food.food.adapters.driven.jpa.mysql.adapter.DishAdapter;
import com.example.food.food.adapters.driven.jpa.mysql.adapter.OrderAdapter;
import com.example.food.food.adapters.driven.jpa.mysql.adapter.RestaurantAdapter;
import com.example.food.food.adapters.driven.jpa.mysql.mapper.IDishEntityMapper;
import com.example.food.food.adapters.driven.jpa.mysql.mapper.IOrderEntityMapper;
import com.example.food.food.adapters.driven.jpa.mysql.mapper.IRestaurantEntityMapper;
import com.example.food.food.adapters.driven.jpa.mysql.repository.*;
import com.example.food.food.domain.api.IDishServicePort;
import com.example.food.food.domain.api.IOrderServicePort;
import com.example.food.food.domain.api.useCases.DishUseCase;
import com.example.food.food.domain.api.useCases.OrderUseCase;
import com.example.food.food.domain.spi.persistence.IDishPersistencePort;
import com.example.food.food.domain.spi.persistence.IOrderPersistencePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.food.food.domain.api.IRestaurantServicePort;
import com.example.food.food.domain.spi.persistence.IRestaurantPersistencePort;
import com.example.food.food.domain.api.useCases.RestaurantUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class BeanConfiguration {
   
   @Bean
   IRestaurantPersistencePort restaurantPersistencePort(final IRestaurantRepository restaurantRepository, final IRestaurantEntityMapper entityMapper, final IDishRepository dishRepository, final IDishEntityMapper dishEntityMapper){
      return new RestaurantAdapter(restaurantRepository, dishRepository, entityMapper, dishEntityMapper);
   }

   @Bean
   IRestaurantServicePort restaurantServicePort(final IRestaurantPersistencePort restaurantPersistencePort) {
      return new RestaurantUseCase(restaurantPersistencePort);
   }

   @Bean
   IOrderPersistencePort orderPersistencePort(final IOrderRepository orderRepository, final IOrderDishesRepository orderDishesRepository, final IOrderEntityMapper entityMapper){
      return new OrderAdapter(orderRepository, orderDishesRepository, entityMapper);
   }

   @Bean
   IOrderServicePort orderServicePort(final IOrderPersistencePort orderPersistencePort) {
      return new OrderUseCase(orderPersistencePort);
   }

   @Bean
   IDishPersistencePort dishPersistencePort(final IDishRepository orderRepository, final IDishEntityMapper entityMapper){
      return new DishAdapter(orderRepository, entityMapper);
   }

   @Bean
   IDishServicePort dishServicePort(final IDishPersistencePort dishPersistencePort, IRestaurantPersistencePort restaurantPersistencePort) {
      return new DishUseCase(dishPersistencePort, restaurantPersistencePort);
   }
}
