package com.personal.order.domain.model;

import lombok.Data;
import org.apache.kafka.clients.producer.Callback;

@Data
public class CoffeeOrderCVO  {
    private String id;
    private String orderNumber;
    private String coffeeName;
    private String coffeeCount;
    private String customerName;
}
