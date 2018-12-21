package com.example.abdazizs.go_loundry.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResultTranksaksi {
    @SerializedName("statusWeb")
    private String status;

    @SerializedName("result")
    private List<GetTranksaksi> result = new ArrayList<GetTranksaksi>();

    @SerializedName("message")
    private String message;

    public ResultTranksaksi() {}

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public List<GetTranksaksi> getResult() {
        return result;
    }
    public void setResult(List<GetTranksaksi> result) {
        this.result = result;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
