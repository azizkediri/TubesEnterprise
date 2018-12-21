package com.example.abdazizs.go_loundry.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alhamdulillah on 11/2/16.
 */
public class GetUser {
    @SerializedName("id_user")
    private String id;

    @SerializedName("nama")
    private String nama;

    @SerializedName("alamat")
    private String alamat;

    @SerializedName("telpn")
    private String telpn;

    @SerializedName("photo")
    private String photo;

    @SerializedName("password")
    private String pass;

    @SerializedName("level")
    private int level;

    private String action;

    public GetUser() {}


    public GetUser(String id, String nama, String alamat, String telpn, String photo, String pass, int level, String action) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.telpn = telpn;
        this.photo = photo;
        this.pass = pass;
        this.level = level;
        this.action = action;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelpn() {
        return telpn;
    }

    public void setTelpn(String telpn) {
        this.telpn = telpn;
    }

    public String getPhoto() {
        return photo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}