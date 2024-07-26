package com.example.food.food.domain.api.useCases;

import com.example.food.food.domain.api.IOrderServicePort;
import com.example.food.food.domain.exception.ClientHasOrderException;
import com.example.food.food.domain.models.Order;
import com.example.food.food.domain.spi.persistence.IOrderPersistencePort;
import com.example.food.food.domain.utils.States;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class OrderUseCase implements IOrderServicePort {

    private final IOrderPersistencePort port;

    @Override
    public void createOrder(Order order) {

        if(port.hasClientOrders(order.getClientId())) {
            throw new ClientHasOrderException();
        }

        order.setState(States.Pending);

        port.createOrder(order);
    }

    @Override
    public void updateOrder(long id, Order order) {

    }

    @Override
    public void updateOrderCode(Long id, String code) {

    }

    @Override
    public List<Order> getAllOrders() {
        return port.getAllOrders();
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return port.getOrderById(id);
    }

    @Override
    public boolean hasClientOrders(Long clientId) {
        return false;
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
