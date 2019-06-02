package com.example.mystore.Model.ObjectClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ThongSoKyThuat {
    @SerializedName("MASP")
    @Expose
    int MASP;

    @SerializedName("MACHITIET")
    @Expose
    int MACHITIET;


    @SerializedName("TENCHITIET")
    @Expose
    String TENCHITIET;

    @SerializedName("GIATRI")
    @Expose
    String GIATRI;

    public int getMASP() {
        return MASP;
    }

    public void setMASP(int MASP) {
        this.MASP = MASP;
    }

    public int getMACHITIET() {
        return MACHITIET;
    }

    public void setMACHITIET(int MACHITIET) {
        this.MACHITIET = MACHITIET;
    }

    public String getTENCHITIET() {
        return TENCHITIET;
    }

    public void setTENCHITIET(String TENCHITIET) {
        this.TENCHITIET = TENCHITIET;
    }

    public String getGIATRI() {
        return GIATRI;
    }

    public void setGIATRI(String GIATRI) {
        this.GIATRI = GIATRI;
    }
}
