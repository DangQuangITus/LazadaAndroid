package com.example.mystore.View.TrangChu;

import com.example.mystore.Adapter.ExpandAdater;
import com.example.mystore.Model.ObjectClass.LoaiSanPham;

import java.util.List;

public interface ViewXuLyMenu {
    void HienThiDanhSachMenu(ViewXuLyMenu viewXuLyMenu, List<LoaiSanPham> loaiSanPhamList);

    void HienThiDanhSachMenuCon(ExpandAdater.SecondExpanable secondExpanable, ExpandAdater secondAdapter);


}
