package com.example.abdazizs.go_loundry.Models;

import com.google.gson.annotations.SerializedName;

public class GetTranksaksi {
    @SerializedName("id_tranksaksi")
    private int idTran;

    @SerializedName("nama_user")
    private String nama;

    @SerializedName("cuci")
    private int cuci;

    @SerializedName("setrika")
    private int setrika;

    @SerializedName("express")
    private int express;

    @SerializedName("antar")
    private int antar;

    @SerializedName("total")
    private int total;

    @SerializedName("tanggal")
    private String tanggal;

    @SerializedName("status")
    private int statusLay;

    public GetTranksaksi(int idTran, String nama, int cuci, int setrika, int express, int antar, int total, String tanggal, int statusLay) {
        this.idTran = idTran;
        this.nama = nama;
        this.cuci = cuci;
        this.setrika = setrika;
        this.express = express;
        this.antar = antar;
        this.total = total;
        this.tanggal = tanggal;
        this.statusLay = statusLay;
    }

    public int getIdTran() {
        return idTran;
    }

    public void setIdTran(int idTran) {
        this.idTran = idTran;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getCuci() {
        return cuci;
    }

    public void setCuci(int cuci) {
        this.cuci = cuci;
    }

    public int getSetrika() {
        return setrika;
    }

    public void setSetrika(int setrika) {
        this.setrika = setrika;
    }

    public int getExpress() {
        return express;
    }

    public void setExpress(int express) {
        this.express = express;
    }

    public int getAntar() {
        return antar;
    }

    public void setAntar(int antar) {
        this.antar = antar;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getStatusLay() {
        return statusLay;
    }

    public void setStatusLay(int statusLay) {
        this.statusLay = statusLay;
    }
}
