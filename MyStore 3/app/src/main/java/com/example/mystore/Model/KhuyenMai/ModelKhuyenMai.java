package com.example.mystore.Model.KhuyenMai;

import android.util.Log;

import com.example.mystore.ConnectInternet.ApiUtils;
import com.example.mystore.Model.ObjectClass.KhuyenMai;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Response;

/**
 */
public class ModelKhuyenMai {

    public List<KhuyenMai> LayDanhSachSanPhamTheoMaLoai(String tenham, String tenmang) {
        List<KhuyenMai> khuyenMais = new ArrayList<>();

        Log.d("KHUYEN_MAI", "START");
        Thread thread = new Thread(() -> {
            try {
                Response<KhuyenMai[]> response = ApiUtils.getServiceGenerator()
                        .layDanhSachKhuyenMai(tenmang)
                        .execute();

                List<KhuyenMai> resultModel = Arrays.asList(response.body());
                System.out.println(resultModel.get(0).getMAKM());

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return khuyenMais;
    }
}
