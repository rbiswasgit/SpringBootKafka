package com.springboot.kafka.emailservice.kafka;

import com.springboot.kafka.basedomains.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    public void consumer(OrderEvent orderEvent){
        LOGGER.info(String.format("Order consume -> %s",orderEvent.toString()));

        //send an email to the customer

    }
}
