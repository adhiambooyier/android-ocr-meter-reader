package com.example.kplc_amr.models;

public class Reading {
    private String id;
    private Meter meter;
    private String reading;

    public Reading(){

    }

    public Reading(String id, String reading, Meter meter) {
        this.id = id;
        this.meter = meter;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReading() {
        return reading;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }

    public Meter getMeter() {
        return meter;
    }
}
