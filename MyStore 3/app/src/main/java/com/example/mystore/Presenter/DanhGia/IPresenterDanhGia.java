package com.example.mystore.Presenter.DanhGia;

import android.widget.ProgressBar;

import com.example.mystore.Model.ObjectClass.DanhGia;

/**
 * Created by Lenovo S410p on 8/18/2016.
 */
public interface IPresenterDanhGia {
    void ThemDanhGia(DanhGia danhGia);
    void LayDanhSachDanhGiaCuaSanPham(int masp, int limit, ProgressBar progressBar);
}
