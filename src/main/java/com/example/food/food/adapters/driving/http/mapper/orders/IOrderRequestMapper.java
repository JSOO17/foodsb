package com.example.food.food.adapters.driving.http.mapper.orders;

import com.example.food.food.adapters.driving.http.dto.request.AddOrderRequest;
import com.example.food.food.adapters.driving.http.dto.request.UpdateOrderRequest;
import com.example.food.food.domain.models.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IOrderRequestMapper {
    Order addRequestToOrder(AddOrderRequest request);

    Order updateRequestToOrder(UpdateOrderRequest request);
}
