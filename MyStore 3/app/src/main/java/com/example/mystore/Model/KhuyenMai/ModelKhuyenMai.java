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
 * Created by Lenovo S410p on 9/13/2016.
 */
public class ModelKhuyenMai {

    public List<KhuyenMai> LayDanhSachSanPhamTheoMaLoai(String tenham, String tenmang) {
        List<KhuyenMai> khuyenMais = new ArrayList<>();

        Log.d("KHUYEN_MAI", "START");
        Thread thread = new Thread(()-> {
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
        try{
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//        try {
//            dataJSON = downloadJSON.get();
//
//            JSONObject jsonObject = new JSONObject(dataJSON);
//            JSONArray jsonArrayDanhSachKhuyenMai = jsonObject.getJSONArray(tenmang);
//            int dem = jsonArrayDanhSachKhuyenMai.length();
//
//            for (int i = 0; i < dem; i++) {
//                JSONObject object = jsonArrayDanhSachKhuyenMai.getJSONObject(i);
//                KhuyenMai khuyenMai = new KhuyenMai();
//                khuyenMai.setMAKM(object.getInt("MAKM"));
//                khuyenMai.setTENKM(object.getString("TENKM"));
//                khuyenMai.setTENLOAISP(object.getString("TENLOAISP"));
//                khuyenMai.setHINHKHUYENMAI(TrangChuActivity.SERVER + object.getString("HINHKHUYENMAI"));
//
//                List<SanPham> sanPhamList = new ArrayList<>();
//                JSONArray arrayDanhSachSanPham = object.getJSONArray("DANHSACHSANPHAM");
//                int demsanpham = arrayDanhSachSanPham.length();
//
//                for (int j = 0; j < demsanpham; j++) {
//                    JSONObject objectSanPham = arrayDanhSachSanPham.getJSONObject(j);
//
//                    SanPham sanPham = new SanPham();
//                    sanPham.setMASP(objectSanPham.getInt("MASP"));
//                    sanPham.setTENSP(objectSanPham.getString("TENSP"));
//                    sanPham.setGIA(objectSanPham.getInt("GIA"));
//                    sanPham.setANHLON(TrangChuActivity.SERVER + objectSanPham.getString("ANHLON"));
//                    sanPham.setANHNHO(objectSanPham.getString("ANHNHO"));
//
//                    ChiTietKhuyenMai chiTietKhuyenMai = new ChiTietKhuyenMai();
//                    chiTietKhuyenMai.setPHANTRAMKM(objectSanPham.getInt("PHANTRAMKM"));
//
//                    sanPham.setChiTietKhuyenMai(chiTietKhuyenMai);
//
//                    sanPhamList.add(sanPham);
//                }
//
//                khuyenMai.setDanhSachSanPhamKhuyenMai(sanPhamList);
//                khuyenMais.add(khuyenMai);
//
//            }
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        return khuyenMais;
    }
}
