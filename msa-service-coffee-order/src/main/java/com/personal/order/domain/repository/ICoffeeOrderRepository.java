package com.personal.order.domain.repository;

import com.personal.order.domain.model.OrderEntity;

public interface ICoffeeOrderRepository {
    public String coffeeOrderSave(OrderEntity orderEntity);
}
