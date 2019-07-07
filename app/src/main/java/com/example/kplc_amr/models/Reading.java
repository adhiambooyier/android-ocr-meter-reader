package com.example.kplc_amr.models;

public class Reading {
    private String id;
    private String mtrId;
    private String reading;

    public Reading(){

    }

    public Reading(String id, String mtrId, String reading) {
        this.id = id;
        this.mtrId = mtrId;
        this.reading = reading;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMtrId() {
        return mtrId;
    }

    public void setMtrId(String mtrId) {
        this.mtrId = mtrId;
    }

    public String getReading() {
        return reading;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }
}
