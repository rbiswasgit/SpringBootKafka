package com.springboot.kafkaproducerwikimedia.service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

public class WikimediaChangesHandler implements EventHandler {
    /*
     WikimediaChangesHandler , handler class will be triggered only there will be new event on the Wikimedia Stream
     we need to implement EventHandler from com.launchdarkly.eventsource.EventHandler package
     we need to override only onMessage() , from here kafkaTemplate will be triggered and event data will be send to Topic
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesHandler.class);
    private String topic;
    private KafkaTemplate<String,String> kafkaTemplate;

    public WikimediaChangesHandler(String topic, KafkaTemplate<String, String> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
       //OnMessage or EventHandler method will be triggered when there will be a new event on the wikimedia data stream
        LOGGER.info(String.format("event data -> %s", messageEvent.getData() ));
        kafkaTemplate.send(topic , messageEvent.getData());
    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
