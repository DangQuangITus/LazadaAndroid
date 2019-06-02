package com.example.mystore.Presenter.ChiTietSanPham;

import android.content.Context;

import com.example.mystore.Model.ObjectClass.SanPham;

public interface IPresenterChiTietSanPham {
    void LayChiTietSanPham(int masp);
    void LayDanhSachDanhGiaCuaSanPham(int masp, int limit);
    void ThemGioHang(SanPham sanPham, Context context);
}
