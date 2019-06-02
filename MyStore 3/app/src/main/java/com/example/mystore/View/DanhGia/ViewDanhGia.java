package com.example.mystore.View.DanhGia;

import com.example.mystore.Model.ObjectClass.DanhGia;

import java.util.List;

/**
 * Created by Lenovo S410p on 8/18/2016.
 */
public interface ViewDanhGia {
    void DanhGiaThanhCong();
    void DanhGiaThatBai();
    void HienThiDanhSachDanhGiaTheoSanPham(List<DanhGia> danhGiaList);
}
