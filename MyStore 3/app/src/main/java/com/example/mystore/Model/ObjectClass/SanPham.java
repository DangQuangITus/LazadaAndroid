package com.example.mystore.Model.ObjectClass;
//
//import java.util.List;
//
//public class SanPham {
//    int MASP;
//    int GIA;
//    int SOLUONG;
//    int MALOAISP;
//    int MATHUONGHIEU;
//    int MANV;
//    int LUOTMUA;
//    int SOLUONGTONKHO;
//    String ANHLON;
//    String ANHNHO;
//    String THONGTIN;
//    String TENSP;
//    String TENNHANVIEN;
//    List<ChiTietSanPham> chiTietSanPhamList;
//    ChiTietKhuyenMai chiTietKhuyenMai;
//
//    public ChiTietKhuyenMai getChiTietKhuyenMai() {
//        return chiTietKhuyenMai;
//    }
//
//    public void setChiTietKhuyenMai(ChiTietKhuyenMai chiTietKhuyenMai) {
//        this.chiTietKhuyenMai = chiTietKhuyenMai;
//    }
//
//
//
//    public int getSOLUONGTONKHO() {
//        return SOLUONGTONKHO;
//    }
//
//    public void setSOLUONGTONKHO(int SOLUONGTONKHO) {
//        this.SOLUONGTONKHO = SOLUONGTONKHO;
//    }
//
//
//
//    public byte[] getHinhgiohang() {
//        return hinhgiohang;
//    }
//
//    public void setHinhgiohang(byte[] hinhgiohang) {
//        this.hinhgiohang = hinhgiohang;
//    }
//
//    byte[] hinhgiohang;
//
//    public String getTENNHANVIEN() {
//        return TENNHANVIEN;
//    }
//
//    public void setTENNHANVIEN(String TENNHANVIEN) {
//        this.TENNHANVIEN = TENNHANVIEN;
//    }
//
//
//
//    public List<ChiTietSanPham> getChiTietSanPhamList() {
//        return chiTietSanPhamList;
//    }
//
//    public void setChiTietSanPhamList(List<ChiTietSanPham> chiTietSanPhamList) {
//        this.chiTietSanPhamList = chiTietSanPhamList;
//    }
//
//
//
//    public String getTENSP() {
//        return TENSP;
//    }
//
//    public void setTENSP(String TENSP) {
//        this.TENSP = TENSP;
//    }
//
//
//
//    public String getTHONGTIN() {
//        return THONGTIN;
//    }
//
//    public void setTHONGTIN(String THONGTIN) {
//        this.THONGTIN = THONGTIN;
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
//    public int getGIA() {
//        return GIA;
//    }
//
//    public void setGIA(int GIA) {
//        this.GIA = GIA;
//    }
//
//    public int getSOLUONG() {
//        return SOLUONG;
//    }
//
//    public void setSOLUONG(int SOLUONG) {
//        this.SOLUONG = SOLUONG;
//    }
//
//    public int getMALOAISP() {
//        return MALOAISP;
//    }
//
//    public void setMALOAISP(int MALOAISP) {
//        this.MALOAISP = MALOAISP;
//    }
//
//    public int getMATHUONGHIEU() {
//        return MATHUONGHIEU;
//    }
//
//    public void setMATHUONGHIEU(int MATHUONGHIEU) {
//        this.MATHUONGHIEU = MATHUONGHIEU;
//    }
//
//    public int getMANV() {
//        return MANV;
//    }
//
//    public void setMANV(int MANV) {
//        this.MANV = MANV;
//    }
//
//    public int getLUOTMUA() {
//        return LUOTMUA;
//    }
//
//    public void setLUOTMUA(int LUOTMUA) {
//        this.LUOTMUA = LUOTMUA;
//    }
//
//    public String getANHLON() {
//        return ANHLON;
//    }
//
//    public void setANHLON(String ANHLON) {
//        this.ANHLON = ANHLON;
//    }
//
//    public String getANHNHO() {
//        return ANHNHO;
//    }
//
//    public void setANHNHO(String ANHNHO) {
//        this.ANHNHO = ANHNHO;
//    }
//
//
//}


import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SanPham {
    @SerializedName("MASP")
    @Expose
    int MASP;

    @SerializedName("TENSP")
    @Expose
    String TENSP;

    @SerializedName("GIA")
    @Expose
    int GIA;

    @SerializedName("ANHLON")
    @Expose
    String ANHLON;

    @SerializedName("ANHNHO")
    @Expose
    String ANHNHO;

    @SerializedName("THONGTIN")
    @Expose
    String THONGTIN;

    @SerializedName("SOLUONG")
    @Expose
    int SOLUONG;

    @SerializedName("MALOAISP")
    @Expose
    int MALOAISP;

    @SerializedName("MATHUONGHIEU")
    @Expose
    int MATHUONGHIEU;

    @SerializedName("MANV")
    @Expose
    int MANV;

    @SerializedName("LUOTMUA")
    @Expose
    int LUOTMUA;


    @SerializedName("SOLUONGTONKHO")
    @Expose
    int SOLUONGTONKHO;


    @SerializedName("THONGSOKYTHUAT")
    @Expose
    ArrayList<ThongSoKyThuat> THONGSOKYTHUAT;

    public ArrayList<ThongSoKyThuat> getTHONGSOKYTHUAT() {
        return THONGSOKYTHUAT;
    }

    public void setTHONGSOKYTHUAT(ArrayList<ThongSoKyThuat> THONGSOKYTHUAT) {
        this.THONGSOKYTHUAT = THONGSOKYTHUAT;
    }

    @SerializedName("TENNHANVIEN")
    @Expose
    String TENNHANVIEN;

    @SerializedName("CHITIETSANPHAM")
    @Expose
    List<ChiTietSanPham> chiTietSanPhamList;

    @SerializedName("CHITIETKHUYENMAI")
    @Expose
    ChiTietKhuyenMai chiTietKhuyenMai;

    public ChiTietKhuyenMai getChiTietKhuyenMai() {
        return chiTietKhuyenMai;
    }

    public void setChiTietKhuyenMai(ChiTietKhuyenMai chiTietKhuyenMai) {
        this.chiTietKhuyenMai = chiTietKhuyenMai;
    }

    public int getSOLUONGTONKHO() {
        return SOLUONGTONKHO;
    }

    public void setSOLUONGTONKHO(int SOLUONGTONKHO) {
        this.SOLUONGTONKHO = SOLUONGTONKHO;
    }

    public byte[] getHinhgiohang() {
        return hinhgiohang;
    }

    public void setHinhgiohang(byte[] hinhgiohang) {
        this.hinhgiohang = hinhgiohang;
    }

    byte[] hinhgiohang;

    public String getTENNHANVIEN() {
        return TENNHANVIEN;
    }

    public void setTENNHANVIEN(String TENNHANVIEN) {
        this.TENNHANVIEN = TENNHANVIEN;
    }

    public List<ChiTietSanPham> getChiTietSanPhamList() {
        return chiTietSanPhamList;
    }

    public void setChiTietSanPhamList(List<ChiTietSanPham> chiTietSanPhamList) {
        this.chiTietSanPhamList = chiTietSanPhamList;
    }

    public String getTENSP() {
        return TENSP;
    }

    public void setTENSP(String TENSP) {
        this.TENSP = TENSP;
    }

    public String getTHONGTIN() {
        return THONGTIN;
    }

    public void setTHONGTIN(String THONGTIN) {
        this.THONGTIN = THONGTIN;
    }

    public int getMASP() {
        return MASP;
    }

    public void setMASP(int MASP) {
        this.MASP = MASP;
    }

    public int getGIA() {
        return GIA;
    }

    public void setGIA(int GIA) {
        this.GIA = GIA;
    }

    public int getSOLUONG() {
        return SOLUONG;
    }

    public void setSOLUONG(int SOLUONG) {
        this.SOLUONG = SOLUONG;
    }

    public int getMALOAISP() {
        return MALOAISP;
    }

    public void setMALOAISP(int MALOAISP) {
        this.MALOAISP = MALOAISP;
    }

    public int getMATHUONGHIEU() {
        return MATHUONGHIEU;
    }

    public void setMATHUONGHIEU(int MATHUONGHIEU) {
        this.MATHUONGHIEU = MATHUONGHIEU;
    }

    public int getMANV() {
        return MANV;
    }

    public void setMANV(int MANV) {
        this.MANV = MANV;
    }

    public int getLUOTMUA() {
        return LUOTMUA;
    }

    public void setLUOTMUA(int LUOTMUA) {
        this.LUOTMUA = LUOTMUA;
    }

    public String getANHLON() {
        return ANHLON;
    }

    public void setANHLON(String ANHLON) {
        this.ANHLON = ANHLON;
    }

    public String getANHNHO() {
        return ANHNHO;
    }

    public void setANHNHO(String ANHNHO) {
        this.ANHNHO = ANHNHO;
    }
}
