package com.springboot.kafkaconsumerdatabase.service;

import com.springboot.kafkaconsumerdatabase.entity.WikimediaData;
import com.springboot.kafkaconsumerdatabase.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private WikimediaDataRepository wikimediaDataRepository;

    public KafkaDatabaseConsumer(WikimediaDataRepository wikimediaDataRepository) {
        this.wikimediaDataRepository = wikimediaDataRepository;
    }

    @KafkaListener(topics = "wikimedia_recentchange_topic" ,groupId = "myGroup")
    public void consume(String eventMessage){
        LOGGER.info(String.format("Event Message Receiveed -> %s", eventMessage));

        WikimediaData wikiData = new WikimediaData();
        wikiData.setWikiEventData(eventMessage);
        wikimediaDataRepository.save(wikiData);
    }

}
