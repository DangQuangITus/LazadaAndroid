package com.example.mystore.View.GioHang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.mystore.Adapter.AdapterGioHang;
import com.example.mystore.Model.ObjectClass.SanPham;
import com.example.mystore.Presenter.GioHang.PresenterLogicGioHang;
import com.example.mystore.R;

import java.util.List;

public class GioHangActivity extends AppCompatActivity implements ViewGioHang {

    RecyclerView recyclerView = null;
    PresenterLogicGioHang presenterLogicGioHang = null;
    Toolbar toolbar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_giohang);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerGioHang);
        toolbar = findViewById(R.id.toolbar);
        presenterLogicGioHang = new PresenterLogicGioHang(this);

        setSupportActionBar(toolbar);
        presenterLogicGioHang.LayDanhSachSanPhamTrongGioHang(this);
    }

    @Override
    public void HienThiDanhSachSanPhamTrongGioHang(List<SanPham> sanPhamList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        AdapterGioHang adapterGioHang = new AdapterGioHang(this, sanPhamList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterGioHang);
    }
}
