package com.example.mystore.ConnectInternet;

import com.example.mystore.Model.ObjectClass.LoaiSanPham;
import com.example.mystore.Model.ObjectClass.LoaiSanPhamBodyIn;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Service {
    @POST("/{gistId}")
    Call<List<LoaiSanPham>> loadMenuDanhMuc(@Body LoaiSanPhamBodyIn loaiSanPhamBodyIn);
}
