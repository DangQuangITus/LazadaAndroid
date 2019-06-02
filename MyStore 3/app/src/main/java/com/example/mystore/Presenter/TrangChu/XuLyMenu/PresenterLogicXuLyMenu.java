package com.example.mystore.Presenter.TrangChu.XuLyMenu;

import android.util.Log;

import com.example.mystore.ConnectInternet.ApiUtils;
import com.example.mystore.ConnectInternet.Service;
import com.example.mystore.Model.DangNhap_DangKy.ModelDangNhap;
import com.example.mystore.Model.ObjectClass.LoaiSanPham;
import com.example.mystore.Model.ObjectClass.Products;
import com.example.mystore.Model.ObjectClass.Req.ProductsReq;
import com.example.mystore.View.TrangChu.ViewXuLyMenu;
import com.facebook.AccessToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

//import com.example.mystore.Model.DangNhap_DangKy.ModelDangNhap;
//import com.facebook.AccessToken;

public class PresenterLogicXuLyMenu implements IPresenterXuLyMenu {

    private ViewXuLyMenu viewXuLyMenu;
    String tennguoidung = "";
    Service service;

    public PresenterLogicXuLyMenu(ViewXuLyMenu viewXuLyMenu) {
        this.viewXuLyMenu = viewXuLyMenu;
    }

    @Override
    public void LayDanhSachMenu() {
//        APIInterface apiInterface;
//        apiInterface = APIClient.getClient().create(APIInterface.class);
//
//        Call<Users> call = apiInterface.doGetUserList();
//        call.enqueue(new Callback<Users>() {
//            @Override
//            public void onResponse(Call<Users> call, Response<Users> response) {
//                // tasks available
//                if (response.isSuccessful()) {
//                    Log.d("TAG",response.code()+"");
//
//                    Users resource = response.body();
//                    list = resource;
//                    if (list != null) {
//                        if (list.getUsers().size() > 0) {
//                            for (int i = 0; i < resource.getUsers().size(); i++) {
//                                System.out.println("--------------");
//                                System.out.println(list.getUsers().get(i).getName() + "  -  " + list.getUsers().get(i).getPhone());
//                                Log.d("TAG", list.getUsers().get(i).getName());
//                            }
//                        }
//                    }
//                } else {
//                    // error response, no access to resource?
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<Users> call, Throwable t) {
//                call.cancel();
//                // something went completely south (like no internet connection)
//                Log.d("Error", t.getMessage());
//            }
//        });
//
//        Log.d("TAG", "END");
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Response<User[]> response = ApiUtils.getServiceGenerator().getListUser().execute();
//                    User[] users = response.body();
//                    if (users != null) {
//                        for (int i = 0; i < users.length; i++) {
//                            Log.d("TAG_RETROFIT", String.valueOf(i) + " - " + users[i].getName()  + " - " + users[i].getPhone());
//                        }
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//       ).start();

        Log.d("LIST_SP", "START");
        new Thread(() -> {
            try {
                String maLoaiCha = "0";
                ProductsReq productsReq = new ProductsReq(maLoaiCha);
                Response<Products[]> response = ApiUtils.getServiceGenerator()
                        .layDanhSachMenu(productsReq.getmaLoaiCha())
                        .execute();
                Products[] products = response.body();
//                System.out.println("product response: " + Arrays.toString(products));
                List<LoaiSanPham> loaiSanPhamList = new ArrayList<>();
                if (products != null) {
                    for (int i = 0; i < products.length; i++) {
                        Log.d("GetCount", String.valueOf(i) + " - " + products[i].getTenLoaiSP()  + " - " + products[i].getMaLoaiCha());
                        LoaiSanPham loaiSanPham = new LoaiSanPham();
                        loaiSanPham.setMALOAICHA(products[i].getMaLoaiCha());
                        loaiSanPham.setTENLOAISP(products[i].getTenLoaiSP());
                        loaiSanPham.setMALOAISP(products[i].getMaLoaiSP());
                        loaiSanPhamList.add(loaiSanPham);
                    }
                }
                viewXuLyMenu.HienThiDanhSachMenu(viewXuLyMenu, loaiSanPhamList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public AccessToken LayTokenDungFacebook() {
        ModelDangNhap modelDangNhap = new ModelDangNhap();
        AccessToken accessToken = modelDangNhap.LayTokenFacebookHienTai();
        return accessToken;
    }
}
