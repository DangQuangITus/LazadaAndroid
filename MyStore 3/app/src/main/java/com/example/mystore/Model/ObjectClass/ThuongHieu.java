package com.example.mystore.Model.ObjectClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ThuongHieu {
    @SerializedName("MATHUONGHIEU")
    @Expose
    int MATHUONGHIEU;

//    int LUOTMUA;

    @SerializedName("TENTHUONGHIEU")
    @Expose
    String TENTHUONGHIEU;

    @SerializedName("HINHTHUONGHIEU")
    @Expose
    String HINHTHUONGHIEU;

    public int getMATHUONGHIEU() {
        return MATHUONGHIEU;
    }

    public void setMATHUONGHIEU(int MATHUONGHIEU) {
        this.MATHUONGHIEU = MATHUONGHIEU;
    }

//    public int getLUOTMUA() {
//        return LUOTMUA;
//    }
//
//    public void setLUOTMUA(int LUOTMUA) {
//        this.LUOTMUA = LUOTMUA;
//    }

    public String getTENTHUONGHIEU() {
        return TENTHUONGHIEU;
    }

    public void setTENTHUONGHIEU(String TENTHUONGHIEU) {
        this.TENTHUONGHIEU = TENTHUONGHIEU;
    }

    public String getHINHTHUONGHIEU() {
        return HINHTHUONGHIEU;
    }

    public void setHINHTHUONGHIEU(String HINHTHUONGHIEU) {
        this.HINHTHUONGHIEU = HINHTHUONGHIEU;
    }



}
