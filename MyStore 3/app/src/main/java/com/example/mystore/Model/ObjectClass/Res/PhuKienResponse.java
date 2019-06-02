package com.example.mystore.Model.ObjectClass.Res;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhuKienResponse {

    @SerializedName("MALOAISP")
    @Expose
    private Integer mALOAISP;
    @SerializedName("TENLOAISP")
    @Expose
    private String tENLOAISP;
    @SerializedName("MALOAI_CHA")
    @Expose
    private Integer mALOAICHA;
    @SerializedName("MASP")
    @Expose
    private Integer mASP;
    @SerializedName("TENSP")
    @Expose
    private String tENSP;
    @SerializedName("GIA")
    @Expose
    private Integer gIA;
    @SerializedName("ANHLON")
    @Expose
    private String aNHLON;
    @SerializedName("ANHNHO")
    @Expose
    private String aNHNHO;
    @SerializedName("THONGTIN")
    @Expose
    private String tHONGTIN;
    @SerializedName("SOLUONG")
    @Expose
    private Integer sOLUONG;
    @SerializedName("MATHUONGHIEU")
    @Expose
    private Integer mATHUONGHIEU;
    @SerializedName("MANV")
    @Expose
    private Integer mANV;
    @SerializedName("LUOTMUA")
    @Expose
    private Integer lUOTMUA;

    public Integer getMALOAISP() {
        return mALOAISP;
    }

    public void setMALOAISP(Integer mALOAISP) {
        this.mALOAISP = mALOAISP;
    }

    public String getTENLOAISP() {
        return tENLOAISP;
    }

    public void setTENLOAISP(String tENLOAISP) {
        this.tENLOAISP = tENLOAISP;
    }

    public Integer getMALOAICHA() {
        return mALOAICHA;
    }

    public void setMALOAICHA(Integer mALOAICHA) {
        this.mALOAICHA = mALOAICHA;
    }

    public Integer getMASP() {
        return mASP;
    }

    public void setMASP(Integer mASP) {
        this.mASP = mASP;
    }

    public String getTENSP() {
        return tENSP;
    }

    public void setTENSP(String tENSP) {
        this.tENSP = tENSP;
    }

    public Integer getGIA() {
        return gIA;
    }

    public void setGIA(Integer gIA) {
        this.gIA = gIA;
    }

    public String getANHLON() {
        return aNHLON;
    }

    public void setANHLON(String aNHLON) {
        this.aNHLON = aNHLON;
    }

    public String getANHNHO() {
        return aNHNHO;
    }

    public void setANHNHO(String aNHNHO) {
        this.aNHNHO = aNHNHO;
    }

    public String getTHONGTIN() {
        return tHONGTIN;
    }

    public void setTHONGTIN(String tHONGTIN) {
        this.tHONGTIN = tHONGTIN;
    }

    public Integer getSOLUONG() {
        return sOLUONG;
    }

    public void setSOLUONG(Integer sOLUONG) {
        this.sOLUONG = sOLUONG;
    }

    public Integer getMATHUONGHIEU() {
        return mATHUONGHIEU;
    }

    public void setMATHUONGHIEU(Integer mATHUONGHIEU) {
        this.mATHUONGHIEU = mATHUONGHIEU;
    }

    public Integer getMANV() {
        return mANV;
    }

    public void setMANV(Integer mANV) {
        this.mANV = mANV;
    }

    public Integer getLUOTMUA() {
        return lUOTMUA;
    }

    public void setLUOTMUA(Integer lUOTMUA) {
        this.lUOTMUA = lUOTMUA;
    }

}