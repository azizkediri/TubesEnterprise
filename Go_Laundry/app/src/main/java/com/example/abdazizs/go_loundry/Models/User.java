package com.example.abdazizs.go_loundry.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alhamdulillah on 11/2/16.
 */
public class User {
    @SerializedName("id_pembeli")
    private String idPembeli;
    @SerializedName("nama")
    private String nama;
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("telpn")
    private String telpn;
    @SerializedName("level")
    private String level;
    @SerializedName("passowrd")
    private String password;
    @SerializedName("photo_id")
    private String photoId;

    private String action;

    public User() {}

    public User(String nama, String alamat, String telpn, String level, String password, String photoId, String action) {
        this.nama = nama;
        this.alamat = alamat;
        this.telpn = telpn;
        this.level = level;
        this.password = password;
        this.photoId = photoId;
        this.action = action;
    }

    public String getIdPembeli() {
        return idPembeli;
    }
    public void setIdPembeli(String idPembeli) {
        this.idPembeli = idPembeli;
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
    public String getPhotoId() {
        return photoId;
    }
    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
}