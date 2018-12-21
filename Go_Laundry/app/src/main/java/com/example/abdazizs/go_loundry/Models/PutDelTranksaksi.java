package com.example.abdazizs.go_loundry.Models;

import com.google.gson.annotations.SerializedName;

public class PutDelTranksaksi {
    @SerializedName("statusWeb")
    private String status;
    @SerializedName("result")
    private GetTranksaksi mTranksaksi;
    @SerializedName("message")
    private String message;

    public PutDelTranksaksi() {}

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public GetTranksaksi getmTranksaksi() {
        return mTranksaksi;
    }

    public void setmTranksaksi(GetTranksaksi mTranksaksi) {
        this.mTranksaksi = mTranksaksi;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
