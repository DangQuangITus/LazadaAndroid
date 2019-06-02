package com.example.mystore.View.ChiTietSanPham;

//import com.com.lazada.Model.ObjectClass.DanhGia;
import com.example.mystore.Model.ObjectClass.DanhGia;
import com.example.mystore.Model.ObjectClass.SanPham;

import java.util.List;


public interface ViewChiTietSanPham {
    void HienChiTietSanPham(SanPham sanPham);
    void HienSliderSanPham(String[] linkhinhsanpham);
    void HienThiDanhGia(List<DanhGia> danhGiaList);
    void ThemGioHangThanhCong();
    void ThemGiohangThatBai();
}
