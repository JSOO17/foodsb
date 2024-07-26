package com.example.food.food.adapters.driven.jpa.mysql.adapter;

import com.example.food.food.adapters.driven.jpa.mysql.mapper.IOrderEntityMapper;
import com.example.food.food.adapters.driven.jpa.mysql.repository.IOrderDishesRepository;
import com.example.food.food.adapters.driven.jpa.mysql.repository.IOrderRepository;
import com.example.food.food.domain.models.Order;
import com.example.food.food.domain.spi.persistence.IOrderPersistencePort;
import com.example.food.food.domain.utils.States;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class OrderAdapter implements IOrderPersistencePort {

    private final IOrderRepository orderRepository;
    private final IOrderDishesRepository orderDishesRepository;
    private final IOrderEntityMapper mapper;

    @Override
    public void createOrder(Order order) {
        var orderEntity = mapper.toEntity(order);

        orderRepository.save(orderEntity);

        orderDishesRepository.saveAll(mapper.toEntityList(order.getDishes()));
    }

    @Override
    public void updateOrder(long id, Order order) {

    }

    @Override
    public void updateOrderCode(Long id, String code) {

    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll().stream().map(mapper::toModel).toList();
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id).map(mapper::toModel);
    }

    @Override
    public boolean hasClientOrders(Long clientId) {
        return orderRepository.existsByClientIdAndStateIn(clientId, List.of(
                States.Pending,
                States.Preparing,
                States.Ready
        ));
    }

    @Override
    public boolean codeExist(String code) {
        return false;
    }

    @Override
    public boolean ValidateCode(Long id, String code) {
        return false;
    }
}
