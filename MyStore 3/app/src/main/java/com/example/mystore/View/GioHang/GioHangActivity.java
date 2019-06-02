package com.example.mystore.View.GioHang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.mystore.Adapter.AdapterGioHang;
import com.example.mystore.Model.ObjectClass.SanPham;
import com.example.mystore.Presenter.GioHang.PresenterLogicGioHang;
import com.example.mystore.R;
import com.example.mystore.View.ThanhToan.ThanhToanActivity;

import java.util.List;

public class GioHangActivity extends AppCompatActivity implements ViewGioHang, View.OnClickListener {

    RecyclerView recyclerView = null;
    PresenterLogicGioHang presenterLogicGioHang = null;
    Toolbar toolbar = null;
    Button btnMuaNgay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_giohang);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerGioHang);
        toolbar = findViewById(R.id.toolbar);
        presenterLogicGioHang = new PresenterLogicGioHang(this);
        btnMuaNgay = (Button) findViewById(R.id.btnMuaNgay);

        setSupportActionBar(toolbar);
        presenterLogicGioHang.LayDanhSachSanPhamTrongGioHang(this);

        btnMuaNgay.setOnClickListener(this);

    }

    @Override
    public void HienThiDanhSachSanPhamTrongGioHang(List<SanPham> sanPhamList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        AdapterGioHang adapterGioHang = new AdapterGioHang(this, sanPhamList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterGioHang);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnMuaNgay:
                Intent iThanhToan = new Intent(GioHangActivity.this, ThanhToanActivity.class);
                this.startActivity(iThanhToan);
                break;
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
