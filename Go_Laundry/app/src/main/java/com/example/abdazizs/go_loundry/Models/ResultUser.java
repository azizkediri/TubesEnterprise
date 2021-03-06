package com.example.abdazizs.go_loundry.Models;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by alhamdulillah on 11/2/16.
 */
public class ResultUser {
    @SerializedName("status")
    private String status;
    @SerializedName("result")
    List<GetUser> User;
    @SerializedName("message")
    private String message;

    public ResultUser() {}

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