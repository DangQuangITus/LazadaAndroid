package com.example.mystore.Model.TrangChu.XuLyMenu;

import android.util.Log;

import com.example.mystore.Adapter.ExpandAdater;
import com.example.mystore.ConnectInternet.ApiUtils;
import com.example.mystore.Model.ObjectClass.LoaiSanPham;
import com.example.mystore.Model.ObjectClass.Products;
import com.example.mystore.Model.ObjectClass.Req.ProductsReq;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Response;

public class XuLyJSONMenu {
    String tennguoidung = "";

    public List<LoaiSanPham> LayLoaiSanPhamTheoMaLoai(final int maloaisp) {
        try {
            String maLoaiCha = String.valueOf(maloaisp);
            ProductsReq productsReq = new ProductsReq(maLoaiCha);
            Response<Products[]> response = ApiUtils.getServiceGenerator()
                    .layDanhSachMenu(productsReq.getmaLoaiCha())
                    .execute();
            Products[] products = response.body();
            return convertProductsToLoaiSanPham(products);
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private List<LoaiSanPham> convertProductsToLoaiSanPham(Products[] products) {
        List<LoaiSanPham> loaiSanPhamList = new ArrayList<>();
        if (products != null) {
            for (int i = 0; i < products.length; i++) {
                LoaiSanPham loaiSanPham = new LoaiSanPham();
                loaiSanPham.setMALOAICHA(products[i].getMaLoaiCha());
                loaiSanPham.setTENLOAISP(products[i].getTenLoaiSP());
                loaiSanPham.setMALOAISP(products[i].getMaLoaiSP());
                loaiSanPhamList.add(loaiSanPham);
            }
        }
        return loaiSanPhamList;
    }
}
