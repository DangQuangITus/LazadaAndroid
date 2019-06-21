package com.example.mystore.Presenter.KhuyenMai;

import android.util.Log;

import com.example.mystore.ConnectInternet.ApiUtils;
import com.example.mystore.Model.KhuyenMai.ModelKhuyenMai;
import com.example.mystore.Model.ObjectClass.ChiTietKhuyenMai;
import com.example.mystore.Model.ObjectClass.KhuyenMai;
import com.example.mystore.Model.ObjectClass.SanPham;
import com.example.mystore.View.TrangChu.TrangChuActivity;
import com.example.mystore.View.TrangChu.ViewKhuyenMai;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

/**
 *
 */
public class PresenterLogicKhuyenMai implements IPresenterKhuyenMai {

    ViewKhuyenMai viewKhuyenMai;
    ModelKhuyenMai modelKhuyenMai;

    public PresenterLogicKhuyenMai(ViewKhuyenMai viewKhuyenMai) {
        this.viewKhuyenMai = viewKhuyenMai;
        modelKhuyenMai = new ModelKhuyenMai();
    }

    @Override
    public void LayDanhSachKhuyenMai() {
        List<KhuyenMai> khuyenMaiList = new ArrayList<KhuyenMai>();
        Log.d("KHUYEN_MAI", "START");
        Thread thread = new Thread(() -> {
            try {
                Response<KhuyenMai[]> response = ApiUtils.getServiceGenerator()
                        .layDanhSachKhuyenMai("test")
                        .execute();

                KhuyenMai[] resultModel = response.body();
                int dem = resultModel.length;
                for (int i = 0; i < dem; i++) {
                    KhuyenMai khuyenMai = new KhuyenMai();
                    khuyenMai.setMAKM(resultModel[i].getMAKM());
                    khuyenMai.setTENKM(resultModel[i].getTENKM());
                    khuyenMai.setTENLOAISP(resultModel[i].getTENLOAISP());
                    khuyenMai.setHINHKHUYENMAI(resultModel[i].getHINHKHUYENMAI());
                    khuyenMai.setHINHKHUYENMAI(TrangChuActivity.SERVER + resultModel[i].getHINHKHUYENMAI()
                            .replaceAll(" ", "%20"));
                    List<SanPham> sanPhamList = new ArrayList<>();
                    int demsanpham = resultModel[i].getSanPhamKhuyenMaiRetrofit().length;

                    for (int j = 0; j < demsanpham; j++) {
                        SanPham dssanpham = resultModel[i].getSanPhamKhuyenMaiRetrofit()[j];
                        SanPham sanPham = new SanPham();
                        sanPham.setMASP(dssanpham.getMASP());
                        sanPham.setTENSP(dssanpham.getTENSP());
                        sanPham.setGIA(dssanpham.getGIA());
                        sanPham.setANHLON(dssanpham.getANHLON());
                        sanPham.setANHNHO(dssanpham.getANHNHO());

                        ChiTietKhuyenMai chiTietKhuyenMai = new ChiTietKhuyenMai();
                        chiTietKhuyenMai.setPHANTRAMKM(dssanpham.getChiTietKhuyenMai().getPHANTRAMKM());

                        sanPham.setChiTietKhuyenMai(chiTietKhuyenMai);
                        sanPhamList.add(sanPham);
                    }

                    khuyenMai.setDanhSachSanPhamKhuyenMai(sanPhamList);
                    khuyenMaiList.add(khuyenMai);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        try {
            thread.join();
            System.out.println(khuyenMaiList.size());
            if (khuyenMaiList.size() > 0) {
                viewKhuyenMai.HienThiDanhSachKhuyenMai(khuyenMaiList);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
