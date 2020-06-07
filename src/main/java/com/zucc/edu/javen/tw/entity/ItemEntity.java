package com.zucc.edu.javen.tw.entity;

import java.util.HashMap;
import java.util.Map;

public class ItemEntity {
    private String title;
    private String from;
    private String url;

    private Map<String, Integer> Participle;

    public ItemEntity() {
        Participle = new HashMap<String, Integer>();

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, Integer> getParticiple() {
        return Participle;
    }

    public void setParticiple(Map<String, Integer> participle) {
        Participle = participle;
    }
}
