package com.example.mystore.Model.DanhGia;

import android.util.Log;

import com.example.mystore.ConnectInternet.ApiUtils;
import com.example.mystore.ConnectInternet.DownloadJSON;
import com.example.mystore.Model.ObjectClass.DanhGia;
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
 * Created by Lenovo S410p on 8/18/2016.
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

    public boolean ThemDanhGia(DanhGia danhGia) {
        String duongdan = TrangChuActivity.SERVER_NAME;
        boolean kiemtra = false;
        List<HashMap<String, String>> attrs = new ArrayList<>();

        HashMap<String, String> hsHam = new HashMap<>();
        hsHam.put("ham", "ThemDanhGia");

        HashMap<String, String> hsMADG = new HashMap<>();
        hsMADG.put("madg", danhGia.getMADG());

        HashMap<String, String> hsMaSP = new HashMap<>();
        hsMaSP.put("masp", String.valueOf(danhGia.getMASP()));

        HashMap<String, String> hsTieuDe = new HashMap<>();
        hsTieuDe.put("tieude", danhGia.getTIEUDE());

        HashMap<String, String> hsNoiDung = new HashMap<>();
        hsNoiDung.put("noidung", danhGia.getNOIDUNG());

        HashMap<String, String> hsSoSao = new HashMap<>();
        hsSoSao.put("sosao", String.valueOf(danhGia.getSOSAO()));

        HashMap<String, String> hsTenThietBi = new HashMap<>();
        hsTenThietBi.put("tenthietbi", String.valueOf(danhGia.getTENTHIETBI()));

        attrs.add(hsHam);
        attrs.add(hsMADG);
        attrs.add(hsMaSP);
        attrs.add(hsTieuDe);
        attrs.add(hsNoiDung);
        attrs.add(hsSoSao);
        attrs.add(hsTenThietBi);

        DownloadJSON downloadJSON = new DownloadJSON(duongdan, attrs);
        downloadJSON.execute();

        try {
            String dulieuJSON = downloadJSON.get();
            JSONObject jsonObject = new JSONObject(dulieuJSON);
            String ketqua = jsonObject.getString("ketqua");
            Log.d("kiemtra", ketqua);
            if (ketqua.equals("true")) {
                kiemtra = true;
            } else {
                kiemtra = false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return kiemtra;
    }

}
