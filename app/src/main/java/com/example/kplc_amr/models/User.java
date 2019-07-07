package com.example.kplc_amr.models;

public class User {
    private String id;
    private String fname;
    private String lname;
    private String email;
    private String mtrNumber;

    public User() {
    }

    public User(String fname, String lname, String email) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }

    public User(String id, String fname, String lname, String email, String mtrNumber) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.mtrNumber = mtrNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMtrNumber() {
        return mtrNumber;
    }

    public void setMtrNumber(String mtrNumber) {
        this.mtrNumber = mtrNumber;
    }
}
