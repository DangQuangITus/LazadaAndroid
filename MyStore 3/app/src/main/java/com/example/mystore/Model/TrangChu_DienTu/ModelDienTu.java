package com.example.mystore.Model.TrangChu_DienTu;

import android.util.Log;

import com.example.mystore.ConnectInternet.ApiUtils;
import com.example.mystore.Model.ObjectClass.Res.SanPhamResponse;
import com.example.mystore.Model.ObjectClass.SanPham;
import com.example.mystore.Model.ObjectClass.ThuongHieu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class ModelDienTu {


    public static List<ThuongHieu> thuongHieuList = new ArrayList<>();
    public static List<SanPham> sanPhamList = new ArrayList<>();
    public static List<SanPham> phuKienList = new ArrayList<>();
    public static List<ThuongHieu> topPhuKienList = new ArrayList<>();
    public static List<SanPham> tienIchList = new ArrayList<>();
    public static List<ThuongHieu> topTienIchList = new ArrayList<>();
    public static List<ThuongHieu> logoList = new ArrayList<>();

    public List<SanPham> LayDanhSachSanPhamTOP(String tenham, String tenmang) {
        sanPhamList.clear();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    SanPhamResponse[] sanPhamResponses;
                    Response<SanPhamResponse[]> response = ApiUtils.getServiceGenerator().getDanhSachTopDienThoaiVaMayTinhBang().execute();
                    sanPhamResponses = response.body();
                    if (sanPhamResponses != null) {

                        for (int i = 0; i < sanPhamResponses.length; i++) {
                            SanPham sanPham = new SanPham();
                            Log.d("SANPHAM", String.valueOf(i) + " - sanPhamResponses: " + sanPhamResponses[i].getTENSP() + " - link: " + sanPhamResponses[i].getHINHSANPHAM());
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

    public List<ThuongHieu> LayDanhSachThuongHieuLon(String tenham, String tenmang) {
        thuongHieuList.clear();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ThuongHieu[] thuongHieus;
                    Response<ThuongHieu[]> response = ApiUtils.getServiceGenerator().getDanhSachThuongHieu().execute();
                    thuongHieus = response.body();
                    if (thuongHieus != null) {
                        for (int i = 0; i < thuongHieus.length; i++) {
                            Log.d("THUONGHIEU", String.valueOf(i) + " - thuongHieus: " + thuongHieus[i].getTENTHUONGHIEU() + " - link: " + thuongHieus[i].getHINHTHUONGHIEU());
                            thuongHieuList.add(thuongHieus[i]);
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

//        Log.d("CNT", thuongHieuList.get(3).getTENTHUONGHIEU() + thuongHieuList.size());
        return thuongHieuList;
    }

    public List<SanPham> LayDanhSachPhuKien(String tenham, String tenmang) {
        phuKienList.clear();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    SanPhamResponse[] sanPhamResponses;
                    Response<SanPhamResponse[]> response = ApiUtils.getServiceGenerator().getDanhSachPhuKien().execute();
                    sanPhamResponses = response.body();
                    if (sanPhamResponses != null) {

                        for (int i = 0; i < sanPhamResponses.length; i++) {
                            SanPham sanPham = new SanPham();
                            Log.d("PHUKIEN", String.valueOf(i) + " - sanPhamResponses: " + sanPhamResponses[i].getTENSP() + " - link: " + sanPhamResponses[i].getHINHSANPHAM());
                            sanPham.setANHLON(sanPhamResponses[i].getHINHSANPHAM());
                            sanPham.setGIA(sanPhamResponses[i].getGIATIEN());
                            sanPham.setTENSP(sanPhamResponses[i].getTENSP());
                            sanPham.setMASP(sanPhamResponses[i].getMASP());
                            phuKienList.add(sanPham);
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
        return phuKienList;
    }

    public List<ThuongHieu> LayDanhSachTopPhuKien(String tenham, String tenmang) {
        topPhuKienList.clear();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ThuongHieu[] thuongHieus;
                    Response<ThuongHieu[]> response = ApiUtils.getServiceGenerator().getDanhSachPhuKienTOP().execute();
                    thuongHieus = response.body();
                    if (thuongHieus != null) {
                        ThuongHieu th = new ThuongHieu();
                        for (int i = 0; i < thuongHieus.length; i++) {
                            Log.d("=== TAG_RETROFIT", String.valueOf(i) + " - thuongHieus: " + thuongHieus[i].getTENTHUONGHIEU() + " - link: " + thuongHieus[i].getHINHTHUONGHIEU());
                            th = thuongHieus[i];
                            topPhuKienList.add(th);
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
        return topPhuKienList;
    }

    public List<SanPham> LayDanhSachTienIch(String tenham, String tenmang) {
        tienIchList.clear();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    SanPhamResponse[] sanPhamResponses;
                    Response<SanPhamResponse[]> response = ApiUtils.getServiceGenerator().getDanhSachTienIch().execute();
                    sanPhamResponses = response.body();
                    if (sanPhamResponses != null) {

                        for (int i = 0; i < sanPhamResponses.length; i++) {
                            SanPham sanPham = new SanPham();
                            Log.d("PHUKIEN", String.valueOf(i) + " - sanPhamResponses: " + sanPhamResponses[i].getTENSP() + " - link: " + sanPhamResponses[i].getHINHSANPHAM());
                            sanPham.setANHLON(sanPhamResponses[i].getHINHSANPHAM());
                            sanPham.setGIA(sanPhamResponses[i].getGIATIEN());
                            sanPham.setTENSP(sanPhamResponses[i].getTENSP());
                            sanPham.setMASP(sanPhamResponses[i].getMASP());
                            tienIchList.add(sanPham);
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
        return tienIchList;
    }

    public List<ThuongHieu> LayDanhSachTopTienIch(String tenham, String tenmang) {
        topTienIchList.clear();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ThuongHieu[] thuongHieus;
                    Response<ThuongHieu[]> response = ApiUtils.getServiceGenerator().getDanhSachTopTienIch().execute();
                    thuongHieus = response.body();
                    if (thuongHieus != null) {
                        ThuongHieu th = new ThuongHieu();
                        for (int i = 0; i < thuongHieus.length; i++) {
                            Log.d("=== TAG_RETROFIT", String.valueOf(i) + " - thuongHieus: " + thuongHieus[i].getTENTHUONGHIEU() + " - link: " + thuongHieus[i].getHINHTHUONGHIEU());
                            th = thuongHieus[i];
                            topTienIchList.add(th);
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
        return topTienIchList;
    }

    public List<ThuongHieu> LayDanhSachLogoThuongHieu(String tenham, String tenmang) {
        logoList.clear();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ThuongHieu[] thuongHieus;
                    Response<ThuongHieu[]> response = ApiUtils.getServiceGenerator().getDanhSachLogoThuongHieu().execute();
                    thuongHieus = response.body();
                    if (thuongHieus != null) {
                        ThuongHieu th = new ThuongHieu();
                        for (int i = 0; i < thuongHieus.length; i++) {
                            Log.d("LOGO", String.valueOf(i) + " - logoList: " + thuongHieus[i].getTENTHUONGHIEU() + " - link: " + thuongHieus[i].getHINHTHUONGHIEU());
                            th = thuongHieus[i];
                            logoList.add(th);
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
        return logoList;
    }
}
