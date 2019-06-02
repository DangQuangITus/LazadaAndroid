package com.example.mystore.Model.ObjectClass.Res;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SanPhamResponse {
    @SerializedName("MASP")
    @Expose
    private Integer mASP;
    @SerializedName("TENSP")
    @Expose
    private String tENSP;
    @SerializedName("GIATIEN")
    @Expose
    private Integer gIATIEN;
    @SerializedName("HINHSANPHAM")
    @Expose
    private String hINHSANPHAM;

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

    public Integer getGIATIEN() {
        return gIATIEN;
    }

    public void setGIATIEN(Integer gIATIEN) {
        this.gIATIEN = gIATIEN;
    }

    public String getHINHSANPHAM() {
        return hINHSANPHAM;
    }

    public void setHINHSANPHAM(String hINHSANPHAM) {
        this.hINHSANPHAM = hINHSANPHAM;
    }
}
