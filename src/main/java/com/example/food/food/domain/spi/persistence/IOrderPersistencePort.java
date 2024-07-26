package com.example.food.food.domain.spi.persistence;

import com.example.food.food.domain.models.Order;
import java.util.List;
import java.util.Optional;

public interface IOrderPersistencePort {
    void createOrder(Order order);
    void updateOrder(long id, Order order);
    void updateOrderCode(Long id, String code);
    List<Order> getAllOrders();
    Optional<Order> getOrderById(Long id);
    boolean hasClientOrders(Long clientId);
    boolean codeExist(String code);
    boolean ValidateCode(Long id, String code);
}
