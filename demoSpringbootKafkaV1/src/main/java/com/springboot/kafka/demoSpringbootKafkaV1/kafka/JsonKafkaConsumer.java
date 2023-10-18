package com.springboot.kafka.demoSpringbootKafkaV1.kafka;

import com.springboot.kafka.demoSpringbootKafkaV1.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class JsonKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "demoTopic1_json" , groupId = "mygroup")
    public void consume(User data){
            LOGGER.info("message read from Topic -> %s", data.toString());
    }
}
