package com.personal.order.springboot.repository.jpa;

import com.personal.order.domain.model.OrderEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class OrderEntityJPO extends OrderEntity {
    @Id
    @GeneratedValue
    private String id;

    String orderNumber;
    String coffeeName;
    String coffeeCount;
    String customerName;
}
