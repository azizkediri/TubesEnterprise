package com.example.abdazizs.go_loundry.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PutDelUser {
    @SerializedName("status")
    private String status;

    @SerializedName("result")
    GetUser User;

    @SerializedName("message")
    private String message;

    public PutDelUser() {}

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public GetUser getUser() {
        return User;
    }

    public void setUser(GetUser user) {
        User = user;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
