package com.example.mystore.Model.ObjectClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Products {
    @SerializedName("MALOAISP")
    @Expose
    private Integer maLoaiSP;

    @SerializedName("TENLOAISP")
    @Expose
    private String tenLoaiSP;

    @SerializedName("MALOAI_CHA")
    @Expose
    private Integer maLoaiCha;

    public Integer getMaLoaiSP() {
        return maLoaiSP;
    }

    public void setMaLoaiSP(Integer maLoaiSP) {
        this.maLoaiSP = maLoaiSP;
    }

    public String getTenLoaiSP() {
        return tenLoaiSP;
    }

    public void setTenLoaiSP(String tenLoaiSP) {
        this.tenLoaiSP = tenLoaiSP;
    }

    public Integer getMaLoaiCha() {
        return maLoaiCha;
    }

    public void setMaLoaiCha(Integer maLoaiCha) {
        this.maLoaiCha = maLoaiCha;
    }
}
