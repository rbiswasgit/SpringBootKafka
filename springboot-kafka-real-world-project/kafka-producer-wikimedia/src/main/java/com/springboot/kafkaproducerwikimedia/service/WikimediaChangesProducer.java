package com.springboot.kafkaproducerwikimedia.service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class WikimediaChangesProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesProducer.class);
    private KafkaTemplate<String,String> kafkaTremplate;
    public WikimediaChangesProducer(KafkaTemplate<String,String> kafkaTremplate){
        this.kafkaTremplate = kafkaTremplate;
    }

    public void sendMessage() throws InterruptedException {

        String topic = "wikimedia_recentchange_topic";

        //in order to read real time stream data from wikimedia, we need event source
        EventHandler eventHandler = new WikimediaChangesHandler(topic,kafkaTremplate);
        String url= "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
        EventSource eventSource = builder.build();
        eventSource.start();

        TimeUnit.MINUTES.sleep(10);

    }
}
