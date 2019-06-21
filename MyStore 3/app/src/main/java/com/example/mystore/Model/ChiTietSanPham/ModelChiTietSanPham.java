package com.example.mystore.Model.ChiTietSanPham;

import android.util.Log;

import com.example.mystore.ConnectInternet.ApiUtils;
import com.example.mystore.ConnectInternet.DownloadJSON;
import com.example.mystore.Model.ObjectClass.ChiTietKhuyenMai;
import com.example.mystore.Model.ObjectClass.ChiTietSanPham;
import com.example.mystore.Model.ObjectClass.DanhGia;
import com.example.mystore.Model.ObjectClass.Res.SanPhamResponse;
import com.example.mystore.Model.ObjectClass.SanPham;
import com.example.mystore.View.TrangChu.TrangChuActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.Response;

/**
 *
 */
public class ModelChiTietSanPham {
    //
    List<DanhGia> listDanhGia;

    public List<DanhGia> LayDanhSachDanhGiaCuaSanPham(int masp, int limit) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response<List<DanhGia>> response = ApiUtils.getServiceGenerator().getDanhGia(masp, limit).execute();
                    listDanhGia = response.body();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        try {
            t.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listDanhGia;
    }
//

    SanPham sanPham = new SanPham();

    public SanPham LayChiTietSanPham(String tenham, String tenmang, int masp) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response<SanPham> response = ApiUtils.getServiceGenerator().getSanPhamTest(masp).execute();
                    System.out.println("result san pham test: " + response.body().toString());
                    sanPham = response.body();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        try {
            t.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanPham;
    }
}
