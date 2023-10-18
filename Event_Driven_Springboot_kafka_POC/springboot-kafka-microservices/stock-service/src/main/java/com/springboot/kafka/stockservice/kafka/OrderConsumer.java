package com.springboot.kafka.stockservice.kafka;

import com.springboot.kafka.basedomains.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class OrderConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}",
    groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(OrderEvent orderEvent){
      LOGGER.info(String.format("Order Consumed ->>> %s", orderEvent.toString()));

      //save the order into DB
    }

}
