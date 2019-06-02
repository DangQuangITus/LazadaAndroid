package com.example.mystore.View.ChiTietSanPham;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mystore.Adapter.AdapterDanhGia;
import com.example.mystore.Adapter.AdapterViewPagerSlider;
import com.example.mystore.Model.ObjectClass.DanhGia;
import com.example.mystore.Model.ObjectClass.SanPham;
import com.example.mystore.Model.ObjectClass.ThongSoKyThuat;
import com.example.mystore.Presenter.ChiTietSanPham.FragmentSliderChiTietSanPham;
import com.example.mystore.Presenter.ChiTietSanPham.PresenterLogicChiTietSanPham;
import com.example.mystore.R;
import com.example.mystore.View.DanhGia.DanhSachDanhGiaActivity;
import com.example.mystore.View.GioHang.GioHangActivity;
import com.example.mystore.View.TrangChu.TrangChuActivity;

import java.io.ByteArrayOutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class ChiTietSanPhamActivity extends AppCompatActivity implements ViewChiTietSanPham, ViewPager.OnPageChangeListener, View.OnClickListener {
    ViewPager viewPager;
    PresenterLogicChiTietSanPham presenterLogicChiTietSanPham;
    Toolbar toolbar;
    TextView[] txtDots;
    LinearLayout layoutDots;
    List<Fragment> fragmentList;
    TextView txtTenSanPham, txtGiaTien, txtTenCHDongGoi, txtXemTatCaNhanXet, txtGioHang, txtThongTinChiTiet;
    ImageView imXemThemChiTiet, imThemGioHang;
    boolean kiemtraxochitiet = false;
    LinearLayout lnThongSoKyThuat;
    RecyclerView recyclerDanhGiaChiTiet;
    SanPham sanPhamGioHang;

    int masp_glo;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_chitietsanpham);
        imThemGioHang = (ImageView) findViewById(R.id.imThemGioHang);
        viewPager = (ViewPager) findViewById(R.id.viewpagerSlider);
        layoutDots = (LinearLayout) findViewById(R.id.layoutDots);
        txtTenSanPham = (TextView) findViewById(R.id.txtTenSanPham);
        txtGiaTien = (TextView) findViewById(R.id.txtGiaTien);
        recyclerDanhGiaChiTiet = (RecyclerView) findViewById(R.id.recyclerDanhGiaChiTiet);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtTenCHDongGoi = (TextView) findViewById(R.id.txtTenCHDongGoi);
        txtThongTinChiTiet = (TextView) findViewById(R.id.txtThongTinChiTiet);
        imXemThemChiTiet = (ImageView) findViewById(R.id.imXemThemChiTiet);
        lnThongSoKyThuat = (LinearLayout) findViewById((R.id.lnThongSoKyThuat));

        setSupportActionBar(toolbar);

        int masp = getIntent().getIntExtra("masp", 0);
        masp_glo = getIntent().getIntExtra("masp", 0);
        System.out.println("ma san pham lay chi tiet la: " + masp);
        presenterLogicChiTietSanPham = new PresenterLogicChiTietSanPham(this);
        presenterLogicChiTietSanPham.LayChiTietSanPham(masp);
        presenterLogicChiTietSanPham.LayDanhSachDanhGiaCuaSanPham(masp, 0);
        imThemGioHang.setOnClickListener(this);

    }


    @Override
    public void HienChiTietSanPham(SanPham sanPham) {

        sanPhamGioHang = sanPham;
        sanPhamGioHang.setSOLUONGTONKHO(sanPham.getSOLUONG());
        System.out.println("chi tiet san pham: " + sanPham.toString());
        txtTenSanPham.setText(sanPham.getTENSP());
        NumberFormat numberFormat = new DecimalFormat("###,###");
        String gia = numberFormat.format(sanPham.getGIA()).toString();
        txtGiaTien.setText(gia + " VNĐ");
        txtTenCHDongGoi.setText(sanPham.getTENNHANVIEN());
        System.out.println("thong so ky thuat: " + sanPham.getTHONGSOKYTHUAT());
        txtThongTinChiTiet.setText(sanPham.getTHONGTIN().substring(0, 100));
        if (sanPham.getTHONGTIN().length() < 100) {
            imXemThemChiTiet.setVisibility(View.GONE);
        } else {
            imXemThemChiTiet.setVisibility(View.VISIBLE);
            imXemThemChiTiet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    kiemtraxochitiet = !kiemtraxochitiet;
                    if (kiemtraxochitiet) {
                        txtThongTinChiTiet.setText(sanPham.getTHONGTIN());
                        imXemThemChiTiet.setImageDrawable(getHinhChiTiet(R.drawable.ic_keyboard_arrow_down_black_24dp));
                        lnThongSoKyThuat.setVisibility(View.VISIBLE);
                        HienThiThongSoKyThuat(sanPham);
                    } else {
                        txtThongTinChiTiet.setText(sanPham.getTHONGTIN().substring(0, 100));
                        imXemThemChiTiet.setImageDrawable(getHinhChiTiet(R.drawable.ic_keyboard_arrow_down_black_24dp));
                        lnThongSoKyThuat.setVisibility(View.GONE);
                    }
                }
            });
        }

    }

    private void HienThiThongSoKyThuat(SanPham sanPham) {
        List<ThongSoKyThuat> chiTietSanPhams = sanPham.getTHONGSOKYTHUAT();
        lnThongSoKyThuat.removeAllViews();

        TextView txtTieuDeThongSoKyThuat = new TextView(this);
        txtTieuDeThongSoKyThuat.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        lnThongSoKyThuat.addView(txtTieuDeThongSoKyThuat);
        for (int i = 0; i < chiTietSanPhams.size(); i++) {
            LinearLayout lnChiTiet = new LinearLayout(this);
            lnChiTiet.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            lnChiTiet.setOrientation(LinearLayout.HORIZONTAL);

            Log.d("chitiet ", chiTietSanPhams.get(i).getTENCHITIET());

            TextView txtTenThongSo = new TextView(this);
            txtTenThongSo.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f));
            txtTenThongSo.setText(chiTietSanPhams.get(i).getTENCHITIET());
            TextView txtGiatriThongSo = new TextView(this);
            txtTenThongSo.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f));
            txtGiatriThongSo.setText(chiTietSanPhams.get(i).getGIATRI());
            lnChiTiet.addView(txtTenThongSo);
            lnChiTiet.addView(txtGiatriThongSo);
            lnThongSoKyThuat.addView(lnChiTiet);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menutrangchu, menu);
        MenuItem iGioHang = menu.findItem(R.id.itGioHang);
        View giaoDienCustomGioHang = MenuItemCompat.getActionView(iGioHang);
        txtGioHang = (TextView) giaoDienCustomGioHang.findViewById(R.id.txtSoLuongSanPhamGioHang);
        txtGioHang.setText(String.valueOf(presenterLogicChiTietSanPham.DemSanPhamCoTrongGioHang(this)));
        giaoDienCustomGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iGioHang = new Intent(ChiTietSanPhamActivity.this, GioHangActivity.class);
                startActivity(iGioHang);
            }
        });
        return true;
    }

    @Override
    public void HienSliderSanPham(String[] linkhinhsanpham) {
        fragmentList = new ArrayList<>();

        for (int i = 0; i < linkhinhsanpham.length; i++) {
            FragmentSliderChiTietSanPham fragmentSliderChiTietSanPham = new FragmentSliderChiTietSanPham();
            Bundle bundle = new Bundle();
            bundle.putString("linkhinh", TrangChuActivity.SERVER + linkhinhsanpham[i]);
            fragmentSliderChiTietSanPham.setArguments(bundle);
            fragmentList.add(fragmentSliderChiTietSanPham);
        }

        AdapterViewPagerSlider adapterViewPagerSlider = new AdapterViewPagerSlider(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(adapterViewPagerSlider);
        adapterViewPagerSlider.notifyDataSetChanged();
        ThemDotSlider(0);
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void ThemGioHangThanhCong() {
        Toast.makeText(this, "Sản phẩm đã được thêm vào giỏ hàng !", Toast.LENGTH_SHORT).show();
//        if (txtGioHang == null) {
//            MenuItem iGioHang = menu.findItem(R.id.itGioHang);
//            View giaoDienCustomGioHang = MenuItemCompat.getActionView(iGioHang);
//            txtGioHang = (TextView) giaoDienCustomGioHang.findViewById(R.id.txtSoLuongSanPhamGioHang);
//        }
//        txtGioHang = (TextView) findViewById(R.id.txtSoLuongSanPhamGioHang);
//
//        txtGioHang.setText(String.valueOf(presenterLogicChiTietSanPham.DemSanPhamCoTrongGioHang(this)));
    }

    @Override
    public void ThemGiohangThatBai() {
        Toast.makeText(this, "Sản phẩm đã có trong giỏ hàng !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void HienThiDanhGia(List<DanhGia> danhGias) {
        AdapterDanhGia adapterDanhGia = new AdapterDanhGia(this, danhGias, 3);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerDanhGiaChiTiet.setLayoutManager(layoutManager);
        recyclerDanhGiaChiTiet.setAdapter(adapterDanhGia);

        adapterDanhGia.notifyDataSetChanged();
    }

    private void ThemDotSlider(int vitrihientai) {
        txtDots = new TextView[fragmentList.size()];
        layoutDots.removeAllViews();
        for (int i = 0; i < fragmentList.size(); i++) {
            txtDots[i] = new TextView(this);
            txtDots[i].setText(Html.fromHtml("&#8226;"));
            txtDots[i].setTextSize(40);
            txtDots[i].setTextColor(getIdColor(R.color.colorSliderInActive));

            layoutDots.addView(txtDots[i]);
        }
        txtDots[vitrihientai].setTextColor(getIdColor(R.color.bgToolbar));
    }

    private Drawable getHinhChiTiet(int idDrawable) {
        Drawable drawable;
        if (Build.VERSION.SDK_INT > 21) {
            drawable = ContextCompat.getDrawable(this, idDrawable);
        } else {
            drawable = getResources().getDrawable(idDrawable);
        }
        return drawable;
    }

    private int getIdColor(int idColor) {
        int color = 0;
        if (Build.VERSION.SDK_INT > 21) {
            color = ContextCompat.getColor(this, idColor);
        } else {
            color = getResources().getColor(idColor);
        }
        return color;
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
//            case R.id.txtVietDanhGia:
//                Intent iThemDanhGia = new Intent(this, ThemDanhGiaActivity.class);
//                iThemDanhGia.putExtra("masp", masp);
//                startActivity(iThemDanhGia);
//                ;
//                break;
//
            case R.id.txtXemTatCaNhanXet:
                Intent iDanhSachDanhGia = new Intent(ChiTietSanPhamActivity.this, DanhSachDanhGiaActivity.class);
                iDanhSachDanhGia.putExtra("masp", masp_glo);
                this.startActivity(iDanhSachDanhGia);
                break;

            case R.id.imThemGioHang:
                Fragment fragment = fragmentList.get(0);
                View view = fragment.getView();
                ImageView imageView = (ImageView) view.findViewById(R.id.imHinhSlider);
                Bitmap bitmap = null;
                if (imageView.getDrawable() != null) {
                    bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    byte[] hinhsanphamgiohang = byteArrayOutputStream.toByteArray();
                    sanPhamGioHang.setHinhgiohang(hinhsanphamgiohang);

                } else sanPhamGioHang.setHinhgiohang(null);

                sanPhamGioHang.setSOLUONGTONKHO(10);

                presenterLogicChiTietSanPham.ThemGioHang(sanPhamGioHang, this);
                break;

//            case R.id.btnMuaNgay:
//                Fragment fragment1 = fragmentList.get(0);
//                View view1 = fragment1.getView();
//                ImageView imageView1 = (ImageView) view1.findViewById(R.id.imHinhSlider);
//                Bitmap bitmap1 = ((BitmapDrawable) imageView1.getDrawable()).getBitmap();
//
//                ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
//                bitmap1.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream1);
//                byte[] hinhsanphamgiohang1 = byteArrayOutputStream1.toByteArray();
//
//                sanPhamGioHang.setHinhgiohang(hinhsanphamgiohang1);
//                sanPhamGioHang.setSOLUONG(1);
//
//                presenterLogicChiTietSanPham.ThemGioHang(sanPhamGioHang, this);
//
//                Intent iThanhToan = new Intent(ChiTietSanPhamActivity.this, ThanhToanActivity.class);
//                startActivity(iThanhToan);
//                break;
        }
    }

    @Override
    public void onPageSelected(int position) {
        ThemDotSlider(position);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
