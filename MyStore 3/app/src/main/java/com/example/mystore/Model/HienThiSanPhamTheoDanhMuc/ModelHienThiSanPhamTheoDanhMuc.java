package com.example.mystore.Model.HienThiSanPhamTheoDanhMuc;

import android.util.Log;

import com.example.mystore.ConnectInternet.ApiUtils;
import com.example.mystore.ConnectInternet.DownloadJSON;
import com.example.mystore.Model.ObjectClass.Res.SanPhamResponse;
import com.example.mystore.Model.ObjectClass.SanPham;
import com.example.mystore.Model.ObjectClass.ThuongHieu;
import com.example.mystore.View.TrangChu.TrangChuActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.Response;

public class ModelHienThiSanPhamTheoDanhMuc {

    public static List<SanPham> sanPhamList = new ArrayList<>();
    public static List<SanPham> sanPhamList2 = new ArrayList<>();

    public List<SanPham> LayDanhSachSanPhamTheoMaLoaiThuongHieu(int masp,String tenmang, String tenham,int limit){
        sanPhamList.clear();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    SanPhamResponse[] sanPhamResponses;
                    Response<SanPhamResponse[]> response = ApiUtils.getServiceGenerator().getDanhSachSanPhamTheoMaLoaiThuongHieu(masp).execute();
                    sanPhamResponses = response.body();
                    if (sanPhamResponses != null) {

                        for (int i = 0; i < sanPhamResponses.length; i++) {
                            SanPham sanPham = new SanPham();
                            Log.d("SANPHAMTheoMaLoai", String.valueOf(i) + " - sanPhamResponses: " + sanPhamResponses[i].getTENSP() + " - link: " + sanPhamResponses[i].getHINHSANPHAM());
                            sanPham.setANHLON(sanPhamResponses[i].getHINHSANPHAM());
                            sanPham.setGIA(sanPhamResponses[i].getGIATIEN());
                            sanPham.setTENSP(sanPhamResponses[i].getTENSP());
                            sanPham.setMASP(sanPhamResponses[i].getMASP());
                            sanPhamList.add(sanPham);
                        }
                    }
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
        return sanPhamList;
    }

    public List<SanPham> LayDanhSachSanPhamTheoMaLoaiDanhMuc(int masp,String tenmang, String tenham,int limit){
        sanPhamList2.clear();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    SanPhamResponse[] sanPhamResponses;
                    Response<SanPhamResponse[]> response = ApiUtils.getServiceGenerator().getDanhSachSanPhamDanhMucTheoMaLoai(masp).execute();
                    sanPhamResponses = response.body();
                    if (sanPhamResponses != null) {

                        for (int i = 0; i < sanPhamResponses.length; i++) {
                            SanPham sanPham = new SanPham();
                            Log.d("SANPHAMTheoMaLoai", String.valueOf(i) + " - sanPhamResponses: " + sanPhamResponses[i].getTENSP() + " - link: " + sanPhamResponses[i].getHINHSANPHAM());
                            sanPham.setANHLON(sanPhamResponses[i].getHINHSANPHAM());
                            sanPham.setGIA(sanPhamResponses[i].getGIATIEN());
                            sanPham.setTENSP(sanPhamResponses[i].getTENSP());
                            sanPham.setMASP(sanPhamResponses[i].getMASP());
                            sanPhamList2.add(sanPham);
                        }
                    }
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
        return sanPhamList2;
    }

}
