package com.example.mystore.View.TrangChu;

import com.example.mystore.Model.ObjectClass.DienTu;
import com.example.mystore.Model.ObjectClass.SanPham;
import com.example.mystore.Model.ObjectClass.ThuongHieu;

import java.util.List;

public interface ViewDienTu {
    void HienThiDanhSach(List<DienTu> dienTus);
    void HienThiLogoThuongHieu(List<ThuongHieu> thuongHieus);
    void LoiLayDuLieu();
    void HienThiSanPhamMoiVe(List<SanPham> sanPhams);

    // add new
    void HienThiDanhSachThuongHieu(List<ThuongHieu> thuongHieus);
}
