package com.example.mystore.Presenter.DangKy;

import com.example.mystore.Model.DangNhap_DangKy.ModelDangKy;
import com.example.mystore.Model.ObjectClass.NhanVien;
import com.example.mystore.View.DangNhapDangKy.Fragment.FragmentDangKy;
import com.example.mystore.View.DangNhapDangKy.ViewDangKy;

/**
 * Created by Lenovo S410p on 7/8/2016.
 */
public class PresenterLogicDangKy implements IPresenterDangKy {
    ViewDangKy viewDangKy;
    ModelDangKy modelDangKy;

    public PresenterLogicDangKy(FragmentDangKy viewDangKy) {
        this.viewDangKy = viewDangKy;
        modelDangKy = new ModelDangKy();
    }

    @Override
    public void ThucHienDangKy(NhanVien nhanvien) {
        boolean kiemtra = modelDangKy.DangKyThanhVien(nhanvien);
        if(kiemtra){
            viewDangKy.DangKyThangCong();
        }else{
            viewDangKy.DangKyThatBai();
        }
//        Log.d("DANG_KY", "START");
//        new Thread(() -> {
//            try {
//                String maNv = "01";
//                String tenNv = "Nguyen Van A";
//                String username = "vana";
//                String password = "12345";
//                String diaChi = "257 Nguyen Van Cu";
//                String ngaySinh = "1900/01/01";
//                String soDt = "0328010342";
//                String gioiTinh = "Nam";
//                String maLoaiNv = "1";
//
//                DangKyReq dangKyReq = new DangKyReq(maNv,tenNv,username,password,diaChi,ngaySinh,soDt,gioiTinh,maLoaiNv);
//                Response<ResultModel> response = ApiUtils.getServiceGenerator()
//                        .dangKyThanhVien(dangKyReq.getMaNv(),dangKyReq.getTenNv(),dangKyReq.getUsername(),dangKyReq.getPassword(),dangKyReq.getDiaChi(),dangKyReq.getNgaySinh(),dangKyReq.getSoDt(),dangKyReq.getGioiTinh(),dangKyReq.getMaLoaiNv())
//                        .execute();
//
//                ResultModel resultModel = response.body();
//
//                System.out.println(resultModel.getResult());
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }).start();
    }
}
