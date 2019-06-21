package com.example.mystore.View.DanhGia;

import com.example.mystore.Model.ObjectClass.DanhGia;

import java.util.List;

/**
 */
public interface ViewDanhGia {
    void DanhGiaThanhCong();
    void DanhGiaThatBai();
    void HienThiDanhSachDanhGiaTheoSanPham(List<DanhGia> danhGiaList);
}
