package com.example.abdazizs.go_loundry.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListResultUser {
    @SerializedName("status")
    private String status;
    @SerializedName("result")
    List<GetUser> User;
    @SerializedName("message")
    private String message;

    public ListResultUser() {}

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public List<GetUser> getUser() {
        return User;
    }

    public void setUser(List<GetUser> user) {
        User = user;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
