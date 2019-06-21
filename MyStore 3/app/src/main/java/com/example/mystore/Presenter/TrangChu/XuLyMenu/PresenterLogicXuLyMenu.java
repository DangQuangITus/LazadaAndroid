package com.example.mystore.Presenter.TrangChu.XuLyMenu;

import android.util.Log;

import com.example.mystore.ConnectInternet.ApiUtils;
import com.example.mystore.ConnectInternet.Service;
import com.example.mystore.Model.DangNhap_DangKy.ModelDangNhap;
import com.example.mystore.Model.ObjectClass.LoaiSanPham;
import com.example.mystore.Model.ObjectClass.Products;
import com.example.mystore.Model.ObjectClass.Req.ProductsReq;
import com.example.mystore.View.TrangChu.ViewXuLyMenu;
import com.facebook.AccessToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;


public class PresenterLogicXuLyMenu implements IPresenterXuLyMenu {

    private ViewXuLyMenu viewXuLyMenu;
    String tennguoidung = "";
    Service service;

    public PresenterLogicXuLyMenu(ViewXuLyMenu viewXuLyMenu) {
        this.viewXuLyMenu = viewXuLyMenu;
    }

    @Override
    public void LayDanhSachMenu() {

        Log.d("LIST_SP", "START");
        new Thread(() -> {
            try {
                String maLoaiCha = "0";
                ProductsReq productsReq = new ProductsReq(maLoaiCha);
                Response<Products[]> response = ApiUtils.getServiceGenerator()
                        .layDanhSachMenu(productsReq.getmaLoaiCha())
                        .execute();
                Products[] products = response.body();
                List<LoaiSanPham> loaiSanPhamList = new ArrayList<>();
                if (products != null) {
                    for (int i = 0; i < products.length; i++) {
                        Log.d("GetCount", String.valueOf(i) + " - " + products[i].getTenLoaiSP() + " - " + products[i].getMaLoaiCha());
                        LoaiSanPham loaiSanPham = new LoaiSanPham();
                        loaiSanPham.setMALOAICHA(products[i].getMaLoaiCha());
                        loaiSanPham.setTENLOAISP(products[i].getTenLoaiSP());
                        loaiSanPham.setMALOAISP(products[i].getMaLoaiSP());
                        loaiSanPhamList.add(loaiSanPham);
                    }
                }
                viewXuLyMenu.HienThiDanhSachMenu(viewXuLyMenu, loaiSanPhamList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public AccessToken LayTokenDungFacebook() {
        ModelDangNhap modelDangNhap = new ModelDangNhap();
        AccessToken accessToken = modelDangNhap.LayTokenFacebookHienTai();
        return accessToken;
    }
}
