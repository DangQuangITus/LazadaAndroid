package com.example.mystore.Model.ObjectClass;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class KhuyenMai {

    @SerializedName("MAKM")
    private int MAKM;

    @SerializedName("MALOAISP")
    private int MALOAISP;

    @SerializedName("TENKM")
    private String TENKM;

    @SerializedName("NGAYBATDAU")
    private String NGAYBATDAU;

    @SerializedName("NGAYKETTHUC")
    private String NGAYKETTHUC;

    @SerializedName("HINHKHUYENMAI")
    private String HINHKHUYENMAI;

    @SerializedName("TENLOAISP")
    private String TENLOAISP;

    public SanPham[] getSanPhamKhuyenMaiRetrofit() {
        return SanPhamKhuyenMaiRetrofit;
    }

    public void setSanPhamKhuyenMaiRetrofit(SanPham[] sanPhamKhuyenMaiRetrofit) {
        SanPhamKhuyenMaiRetrofit = sanPhamKhuyenMaiRetrofit;
    }

    @SerializedName("DANHSACHSANPHAMKHUYENMAI")
    private SanPham[] SanPhamKhuyenMaiRetrofit;

    private List<SanPham> DanhSachSanPhamKhuyenMai;

    public int getMAKM() {
        return MAKM;
    }

    public void setMAKM(int MAKM) {
        this.MAKM = MAKM;
    }

    public int getMALOAISP() {
        return MALOAISP;
    }

    public void setMALOAISP(int MALOAISP) {
        this.MALOAISP = MALOAISP;
    }

    public String getTENKM() {
        return TENKM;
    }

    public void setTENKM(String TENKM) {
        this.TENKM = TENKM;
    }

    public String getNGAYBATDAU() {
        return NGAYBATDAU;
    }

    public void setNGAYBATDAU(String NGAYBATDAU) {
        this.NGAYBATDAU = NGAYBATDAU;
    }

    public String getNGAYKETTHUC() {
        return NGAYKETTHUC;
    }

    public void setNGAYKETTHUC(String NGAYKETTHUC) {
        this.NGAYKETTHUC = NGAYKETTHUC;
    }

    public String getHINHKHUYENMAI() {
        return HINHKHUYENMAI;
    }

    public void setHINHKHUYENMAI(String HINHKHUYENMAI) {
        this.HINHKHUYENMAI = HINHKHUYENMAI;
    }

    public String getTENLOAISP() {
        return TENLOAISP;
    }

    public void setTENLOAISP(String TENLOAISP) {
        this.TENLOAISP = TENLOAISP;
    }

    public List<SanPham> getDanhSachSanPhamKhuyenMai() {
        return DanhSachSanPhamKhuyenMai;
    }

    public void setDanhSachSanPhamKhuyenMai(List<SanPham> danhSachSanPhamKhuyenMai) {
        DanhSachSanPhamKhuyenMai = danhSachSanPhamKhuyenMai;
    }
}
