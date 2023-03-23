package com.personal.order.springboot.rest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.personal.order.domain.model.CoffeeOrderCVO;
import com.personal.order.springboot.service.CoffeeOrderServiceImpl;
import com.personal.order.springboot.service.IMsaServiceCoffeeMember;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CoffeeOrderRestController {

    private final CoffeeOrderServiceImpl coffeeOrderServiceImpl;

    private final KafkaProducer kafkaProducer;

    private final IMsaServiceCoffeeMember iMsaServiceCoffeeMember;

    @HystrixCommand
    @RequestMapping(value = "/coffeeOrder", method= RequestMethod.POST)
    public ResponseEntity<CoffeeOrderCVO> coffeeOrder(@RequestBody CoffeeOrderCVO coffeeOrderCVO){

        // is_member
        if(iMsaServiceCoffeeMember.coffeeMember(coffeeOrderCVO.getCustomerName()))
            System.out.println(coffeeOrderCVO.getCustomerName() + " is a member :)!!");

        // coffee order
        coffeeOrderServiceImpl.coffeeOrder(coffeeOrderCVO);

        // kafka
        kafkaProducer.send(new ProducerRecord<String, Object>("kafka-my-topic", coffeeOrderCVO));

        return new ResponseEntity<CoffeeOrderCVO>(coffeeOrderCVO, HttpStatus.OK);
    }

}
