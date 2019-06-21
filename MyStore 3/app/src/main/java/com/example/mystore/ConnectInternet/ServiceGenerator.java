package com.example.mystore.ConnectInternet;

import com.example.mystore.Model.ObjectClass.DanhGia;
import com.example.mystore.Model.ObjectClass.HoaDon;
import com.example.mystore.Model.ObjectClass.KhuyenMai;
import com.example.mystore.Model.ObjectClass.Products;
import com.example.mystore.Model.ObjectClass.Res.SanPhamResponse;
import com.example.mystore.Model.ObjectClass.SanPham;
import com.example.mystore.Model.ObjectClass.ThuongHieu;
import com.example.mystore.Model.ResultModel;
import com.example.mystore.User;

import java.util.List;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ServiceGenerator {
    @GET("/get_list_users")
    Call<User[]> getListUser();

    @Multipart
    @POST("/LayDanhSachMenu")
    Call<Products[]> layDanhSachMenu(@Part("maloaicha") RequestBody maLoaiCha);

    @GET("/LayDanhSachCacThuongHieuLon")
    Call<ThuongHieu[]> getDanhSachThuongHieu();

    @GET("/LayDanhSachTopDienThoaiVaMayTinhBang")
    Call<SanPhamResponse[]> getDanhSachTopDienThoaiVaMayTinhBang();

    @GET("/LayDanhSachTopPhuKien")
    Call<ThuongHieu[]> getDanhSachPhuKienTOP();

    @GET("/LayDanhSachPhuKien")
    Call<SanPhamResponse[]> getDanhSachPhuKien();

    @GET("/LayDanhSachTopTienIch")
    Call<ThuongHieu[]> getDanhSachTopTienIch();

    @GET("/LayDanhSachTienIch")
    Call<SanPhamResponse[]> getDanhSachTienIch();

    @GET("/LayLogoCacThuongHieuLon")
    Call<ThuongHieu[]> getDanhSachLogoThuongHieu();

    @GET("/LayDanhSachSanPhamTheoMaLoaiThuongHieu")
    Call<SanPhamResponse[]> getDanhSachSanPhamTheoMaLoaiThuongHieu(@Query("maloai") int maloai);

    @GET("/LayDanhSachSanPhamDanhMucTheoMaLoai")
    Call<SanPhamResponse[]> getDanhSachSanPhamDanhMucTheoMaLoai(@Query("maloai") int maloai);


    @GET("/LaySanPham")
    Call<SanPham> getSanPham(@Query("masp") int masp);

    @GET("/LaySanPhamTest")
    Call<SanPham> getSanPhamTest(@Query("masp") int masp);

    @GET("/LayDanhSachDanhGiaTheoMASP")
    Call<List<DanhGia>> getDanhGia(@Query("masp") int masp, @Query("limit") int limit);


    @GET("/LayDanhSachKhuyenMai")
    Call<KhuyenMai[]> layDanhSachKhuyenMai(@Query("tenmang") String tenmang);

    @POST("/thanhtoan")
    Call<String> thanhToan(@Query("hoadon") String hoadon);

    @POST("/danhgia")
    Call<String> danhGia(@Query("danhgia") String danhgia);

    @Multipart
    @POST("/DangKyThanhVien")
    Call<ResultModel> dangKyThanhVien(@Part("manv") int maNv,
                                      @Part("tennv") String tenNv,
                                      @Part("username") String username,
                                      @Part("password") String password,
                                      @Part("diachi") String diaChi,
                                      @Part("ngaysinh") String ngaySinh,
                                      @Part("sodt") String soDt,
                                      @Part("gioitinh") int gioiTinh,
                                      @Part("maloainv") int maLoaiNv);

    @Multipart
    @POST("/DangNhap")
    Call<ResultModel> dangNhap(@Part("username") String username,
                               @Part("password") String password);

}
