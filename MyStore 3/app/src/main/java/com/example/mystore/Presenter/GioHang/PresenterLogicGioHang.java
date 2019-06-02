package com.example.mystore.Presenter.GioHang;

import android.content.Context;

import com.example.mystore.Model.GioHang.ModelGioHang;
import com.example.mystore.Model.ObjectClass.SanPham;
import com.example.mystore.View.GioHang.ViewGioHang;

import java.util.List;

public class PresenterLogicGioHang implements IPresenterGioHang {
    ModelGioHang modelGioHang = null;
    ViewGioHang viewGioHang = null;

    public PresenterLogicGioHang(ViewGioHang viewGioHang) {
        this.modelGioHang = new ModelGioHang();
        this.viewGioHang = viewGioHang;
    }

    @Override
    public void LayDanhSachSanPhamTrongGioHang(Context context) {
        modelGioHang.MoKetNoiSQL(context);
        List<SanPham> sanPhamList = modelGioHang.LayDanhSachSanPhamTrongGioHang();
        if (sanPhamList.size() > 0) {
            viewGioHang.HienThiDanhSachSanPhamTrongGioHang(sanPhamList);
        }

    }
}
