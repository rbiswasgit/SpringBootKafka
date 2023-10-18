package com.springboot.kafka.demoSpringbootKafkaV1.kafka;

import com.springboot.kafka.demoSpringbootKafkaV1.config.KafkaTopicConfig;
import com.springboot.kafka.demoSpringbootKafkaV1.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String , User> kafkaTemplate;
    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User data){
        LOGGER.info("Message to be sent -> %s", data.toString());

        Message<User> message = MessageBuilder
                         .withPayload(data)
                         .setHeader(KafkaHeaders.TOPIC, "demoTopic1_json").build();
        kafkaTemplate.send(message);

    }
}
