package com.personal.status.springboot.messageq;

import com.personal.status.springboot.repository.ICoffeeStatusMapper;
import com.personal.status.springboot.repository.dvo.OrderStatusDVO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {
    private final ICoffeeStatusMapper iCoffeeStatusMapper;

    @KafkaListener(topics = "kafka-my-topic")
    public void processMessages(String kafkaMessage) {
        // received the message
        System.out.println("Kafka Message : =====> " + kafkaMessage);

        // insert to DB
        OrderStatusDVO orderStatusDVO = new OrderStatusDVO();
        orderStatusDVO.setOrderHistory(kafkaMessage);

        iCoffeeStatusMapper.insertCoffeeOrderStatus(orderStatusDVO);
    }
}
