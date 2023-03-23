package com.personal.status.springboot.repository;

import com.personal.status.springboot.repository.dvo.OrderStatusDVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ICoffeeStatusMapper {
    int insertCoffeeOrderStatus(OrderStatusDVO orderStatusDVO);
    OrderStatusDVO selectCoffeeOrderStatus();
    int createStatusTable();
}
