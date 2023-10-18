package com.springboot.kafka.demoSpringbootKafkaV1.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic demoSpringKafkaTopic(){
        return TopicBuilder.name("demoTopic1").build();
    }

    @Bean
    public NewTopic demoSpringKafkaTopicJson(){
        return TopicBuilder.name("demoTopic1_json").build();
    }
}
