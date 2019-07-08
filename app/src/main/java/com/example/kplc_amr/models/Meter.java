package com.example.kplc_amr.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meter {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("mtrNumber")
    @Expose
    private String mtrNumber;
    @SerializedName("user")
    @Expose
    private User user;
    /**
     * No args constructor for use in serialization
     */
    public Meter() {

    }

    public Meter(String id, String mtrNumber, User user) {
        this.id = id;
        this.mtrNumber = mtrNumber;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMtrNumber() {
        return mtrNumber;
    }

    public void setMtrNumber(String mtrNumber) {
        this.mtrNumber = mtrNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

