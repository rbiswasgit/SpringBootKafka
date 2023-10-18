package com.springboot.kafka.demoSpringbootKafkaV1.controller;

import com.springboot.kafka.demoSpringbootKafkaV1.kafka.JsonKafkaProducer;
import com.springboot.kafka.demoSpringbootKafkaV1.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka/v1")
public class JsonMessageController {

    private JsonKafkaProducer jsonKafkaProducer;

    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("/user")
    public ResponseEntity<String> saveJsondata(@RequestBody User data){
        jsonKafkaProducer.sendMessage(data);
        return ResponseEntity.ok("Message successfully sent to Topic!!!!");
    }
}
