package com.example.abdazizs.go_loundry.Models;

import com.google.gson.annotations.SerializedName;

public class GetTranksaksi {
    @SerializedName("id_tranksaksi")
    private int idTran;

    @SerializedName("id_user")
    private int idUser;

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

//    @SerializedName("tanggal")
//    private String tanggal;

    @SerializedName("status")
    private int status;

    public GetTranksaksi(int idTran, int idUser, String nama, int cuci, int setrika, int express, int antar, int total, int status) {
        this.idTran = idTran;
        this.idUser = idUser;
        this.nama = nama;
        this.cuci = cuci;
        this.setrika = setrika;
        this.express = express;
        this.antar = antar;
        this.total = total;
        this.status = status;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

//    public String getTanggal() {
//        return tanggal;
//    }
//
//    public void setTanggal(String tanggal) {
//        this.tanggal = tanggal;
//    }

    public int getStatusLay() {
        return status;
    }

    public void setStatusLay(int statusLay) {
        this.status = statusLay;
    }
}
