package com.example.mystore.Presenter.DanhGia;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mystore.Model.DanhGia.ModelDanhGia;
import com.example.mystore.Model.ObjectClass.DanhGia;
import com.example.mystore.View.DanhGia.ViewDanhGia;

import java.util.List;

/**
 * Created by Lenovo S410p on 8/18/2016.
 */
public class PresenterLogicDanhGia implements IPresenterDanhGia {

    ViewDanhGia viewDanhGia;
    ModelDanhGia modelDanhGia;

    public PresenterLogicDanhGia(ViewDanhGia viewDanhGia) {
        this.viewDanhGia = viewDanhGia;
        modelDanhGia = new ModelDanhGia();
    }

    @Override
    public void ThemDanhGia(DanhGia danhGia) {
        boolean kiemtra = modelDanhGia.ThemDanhGia(danhGia);
        if (kiemtra) {
            viewDanhGia.DanhGiaThanhCong();
        } else {
            viewDanhGia.DanhGiaThatBai();
        }
    }

    @Override
    public void LayDanhSachDanhGiaCuaSanPham(int masp, int limit, ProgressBar progressBar) {
        progressBar.setVisibility(View.VISIBLE);
        List<DanhGia> danhGiaList = modelDanhGia.LayDanhSachDanhGiaCuaSanPham(masp, limit);

//        if (danhGiaList.size() > 0) {
            progressBar.setVisibility(View.GONE);
            viewDanhGia.HienThiDanhSachDanhGiaTheoSanPham(danhGiaList);
//        }
    }
}
