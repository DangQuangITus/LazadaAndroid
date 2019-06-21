package com.example.mystore.Model.DanhGia;

import android.util.Log;

import com.example.mystore.ConnectInternet.ApiUtils;
import com.example.mystore.ConnectInternet.DownloadJSON;
import com.example.mystore.Model.ObjectClass.DanhGia;
import com.example.mystore.View.TrangChu.TrangChuActivity;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.Response;

/**
 *
 */
public class ModelDanhGia {
    List<DanhGia> listDanhGia;

    public List<DanhGia> LayDanhSachDanhGiaCuaSanPham(int masp, int limit) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response<List<DanhGia>> response = ApiUtils.getServiceGenerator().getDanhGia(masp, limit).execute();
                    listDanhGia = response.body();
                    System.out.println("list danh gia: " + listDanhGia.size());
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
    String ketqua = "";
    boolean kiemtra = false;

    public boolean ThemDanhGia(DanhGia danhGia) {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Gson gson = new Gson();
                    String data = gson.toJson(danhGia);
                    Response<String> response = ApiUtils.getServiceGenerator().danhGia(data).execute();
                    ketqua = response.body();
                    Log.d("ket qua danh gia", ketqua);
                    if (ketqua == "true")
                        kiemtra = true;
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

        return kiemtra;
    }

}
