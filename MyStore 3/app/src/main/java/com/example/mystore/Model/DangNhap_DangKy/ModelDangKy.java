package com.example.mystore.Model.DangNhap_DangKy;

import android.util.Log;

import com.example.mystore.ConnectInternet.ApiUtils;
import com.example.mystore.ConnectInternet.DownloadJSON;
import com.example.mystore.Model.ObjectClass.NhanVien;
import com.example.mystore.Model.ResultModel;
import com.example.mystore.View.TrangChu.TrangChuActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.Response;

/**
 */
public class ModelDangKy {

    public Boolean DangKyThanhVien(NhanVien nhanVien){
        boolean kiemtra = true;

        Log.d("DANG_KY", "START");
        new Thread(() -> {
            try {
//                DangKyReq dangKyReq = new DangKyReq(nhanVien.getMaNV(),nhanVien.getTenNV(),nhanVien.getEmailDocQuyen(),nhanVien.getMatKhau(),nhanVien.getDiaChi(),nhanVien.getNgaySinh(),nhanVien.getSoDT(),nhanVien.getGioiTinh(),nhanVien.getMaLoaiNV());
                Response<ResultModel> response = ApiUtils.getServiceGenerator()
                        .dangKyThanhVien(nhanVien.getMaNV(),nhanVien.getTenNV(),nhanVien.getTenDN(),nhanVien.getMatKhau(),nhanVien.getDiaChi(),nhanVien.getNgaySinh(),nhanVien.getSoDT(),nhanVien.getGioiTinh(),nhanVien.getMaLoaiNV())
                        .execute();

                ResultModel resultModel = response.body();

                System.out.println(resultModel.getResult());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        return kiemtra;
    }
}
