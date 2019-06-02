package com.example.mystore.Model.ThanhToan;

import android.util.Log;

import com.example.mystore.ConnectInternet.ApiUtils;
import com.example.mystore.Model.ObjectClass.HoaDon;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Response;

/**
 * Created by Lenovo S410p on 9/5/2016.
 */
public class ModelThanhToan {
    String ketqua;
    boolean kiemtra = false;

    public boolean ThemHoaDon(HoaDon hoaDon) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Gson gson = new Gson();
                    String data = gson.toJson(hoaDon);
                    Response<String> response = ApiUtils.getServiceGenerator().thanhToan(data).execute();
                    ketqua = response.body();
                    Log.d("ket qua thanh toan", ketqua);
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
