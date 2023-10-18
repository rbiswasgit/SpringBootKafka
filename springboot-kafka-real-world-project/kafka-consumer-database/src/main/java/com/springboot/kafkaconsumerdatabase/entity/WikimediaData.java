package com.springboot.kafkaconsumerdatabase.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "wikimedia_recentchanges")
@Getter
@Setter
public class WikimediaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String wikiEventData;

    public WikimediaData(){

    }

    public WikimediaData(Long id, String wikiEventData) {
        this.id = id;
        this.wikiEventData = wikiEventData;
    }
}
