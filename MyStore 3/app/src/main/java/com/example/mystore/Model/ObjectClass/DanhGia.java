package com.example.mystore.Model.ObjectClass;
//
//public class DanhGia {
//    String MADG,TENTHIETBI,TIEUDE,NOIDUNG,NGAYDANHGIA;
//    int SOSAO,MASP;
//
//    public String getMADG() {
//        return MADG;
//    }
//
//    public void setMADG(String MADG) {
//        this.MADG = MADG;
//    }
//
//    public String getTENTHIETBI() {
//        return TENTHIETBI;
//    }
//
//    public void setTENTHIETBI(String TENTHIETBI) {
//        this.TENTHIETBI = TENTHIETBI;
//    }
//
//    public String getTIEUDE() {
//        return TIEUDE;
//    }
//
//    public void setTIEUDE(String TIEUDE) {
//        this.TIEUDE = TIEUDE;
//    }
//
//    public String getNOIDUNG() {
//        return NOIDUNG;
//    }
//
//    public void setNOIDUNG(String NOIDUNG) {
//        this.NOIDUNG = NOIDUNG;
//    }
//
//    public String getNGAYDANHGIA() {
//        return NGAYDANHGIA;
//    }
//
//    public void setNGAYDANHGIA(String NGAYDANHGIA) {
//        this.NGAYDANHGIA = NGAYDANHGIA;
//    }
//
//    public int getSOSAO() {
//        return SOSAO;
//    }
//
//    public void setSOSAO(int SOSAO) {
//        this.SOSAO = SOSAO;
//    }
//
//    public int getMASP() {
//        return MASP;
//    }
//
//    public void setMASP(int MASP) {
//        this.MASP = MASP;
//    }
//
//
//}

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DanhGia {
    @SerializedName("MADG")
    @Expose
    String MADG;
    @SerializedName("TENTHIETBI")
    @Expose
    String TENTHIETBI;
    @SerializedName("TIEUDE")
    @Expose
    String TIEUDE;
    @SerializedName("NOIDUNG")
    @Expose
    String NOIDUNG;
    @SerializedName("NGAYDANHGIA")
    @Expose
    String NGAYDANHGIA;
    @SerializedName("SOSAO")
    @Expose
    int SOSAO;
    @SerializedName("MASP")
    @Expose
    int MASP;

    public String getMADG() {
        return MADG;
    }

    public void setMADG(String MADG) {
        this.MADG = MADG;
    }

    public String getTENTHIETBI() {
        return TENTHIETBI;
    }

    public void setTENTHIETBI(String TENTHIETBI) {
        this.TENTHIETBI = TENTHIETBI;
    }

    public String getTIEUDE() {
        return TIEUDE;
    }

    public void setTIEUDE(String TIEUDE) {
        this.TIEUDE = TIEUDE;
    }

    public String getNOIDUNG() {
        return NOIDUNG;
    }

    public void setNOIDUNG(String NOIDUNG) {
        this.NOIDUNG = NOIDUNG;
    }

    public String getNGAYDANHGIA() {
        return NGAYDANHGIA;
    }

    public void setNGAYDANHGIA(String NGAYDANHGIA) {
        this.NGAYDANHGIA = NGAYDANHGIA;
    }

    public int getSOSAO() {
        return SOSAO;
    }

    public void setSOSAO(int SOSAO) {
        this.SOSAO = SOSAO;
    }

    public int getMASP() {
        return MASP;
    }

    public void setMASP(int MASP) {
        this.MASP = MASP;
    }


}
