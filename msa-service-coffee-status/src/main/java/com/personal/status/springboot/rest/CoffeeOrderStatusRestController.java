package com.personal.status.springboot.rest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.personal.status.springboot.repository.ICoffeeStatusMapper;
import com.personal.status.springboot.repository.dvo.OrderStatusDVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CoffeeOrderStatusRestController {

    ICoffeeStatusMapper iCoffeeStatusMapper;

    @HystrixCommand
    @RequestMapping(value = "/coffeeOrderStatus", method = RequestMethod.POST)
    public ResponseEntity<OrderStatusDVO> coffeeOrderStatus() {
        OrderStatusDVO orderStatusDVO = iCoffeeStatusMapper.selectCoffeeOrderStatus();

        return new ResponseEntity<OrderStatusDVO>(orderStatusDVO, HttpStatus.OK);
    }

    @RequestMapping(value = "/createStatusTable", method = RequestMethod.PUT)
    public void createStatusTable(){
        iCoffeeStatusMapper.createStatusTable();
    }
}
