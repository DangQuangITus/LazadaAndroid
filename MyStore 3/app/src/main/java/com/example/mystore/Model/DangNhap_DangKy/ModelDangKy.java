package com.example.mystore.Model.DangNhap_DangKy;

import android.util.Log;

import com.example.mystore.ConnectInternet.ApiUtils;
import com.example.mystore.Model.ObjectClass.NhanVien;
import com.example.mystore.Model.ResultModel;

import java.io.IOException;

import retrofit2.Response;

/**
 * Created by Lenovo S410p on 7/8/2016.
 */
public class ModelDangKy {

    public Boolean DangKyThanhVien(NhanVien nhanVien){
        boolean kiemtra = true;

        Log.d("DANG_KY", "START");
        new Thread(() -> {
            try {
//                DangKyReq dangKyReq = new DangKyReq(nhanVien.getMaNV(),nhanVien.getTenNV(),nhanVien.getEmailDocQuyen(),nhanVien.getMatKhau(),nhanVien.getDiaChi(),nhanVien.getNgaySinh(),nhanVien.getSoDT(),nhanVien.getGioiTinh(),nhanVien.getMaLoaiNV());
                Response<ResultModel> response = ApiUtils.getServiceGenerator()
                        .dangKyThanhVien(nhanVien.getMaNV(),nhanVien.getTenNV(),nhanVien.getEmailDocQuyen(),nhanVien.getMatKhau(),nhanVien.getDiaChi(),nhanVien.getNgaySinh(),nhanVien.getSoDT(),nhanVien.getGioiTinh(),nhanVien.getMaLoaiNV())
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
