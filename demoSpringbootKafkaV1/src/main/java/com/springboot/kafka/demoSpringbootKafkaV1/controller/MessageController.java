package com.springboot.kafka.demoSpringbootKafkaV1.controller;

import com.springboot.kafka.demoSpringbootKafkaV1.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka/v1")
public class MessageController {
    private KafkaProducer kafkaProducer;
    public MessageController(KafkaProducer kafkaProducer){
        this.kafkaProducer = kafkaProducer;
    }
    //http://localhost:8080/api/kafka/v1/sendMsg?message=hello world!!
    @GetMapping ("/sendMsg")
    public ResponseEntity<String> sendMessageByTopic(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to topic!!!!");
    }
}
