package com.example.kplc_amr.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meter {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("photo")
    @Expose
    private String photo;

    /**
     * No args constructor for use in serialization
     */
    public Meter() {
    }


    public Meter(Integer id, String media) {
        this.id = id;
        this.photo = media;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
