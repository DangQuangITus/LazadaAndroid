package com.example.mystore.View.TrangChu.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

//import com.example.mystore.Adapter.AdapterDienTu;
//import com.checongbinh.lazada.Adapter.AdapterThuongHieuLonDienTu;
//import com.checongbinh.lazada.Adapter.AdapterTopDienThoaiDienTu;
//import com.checongbinh.lazada.Model.ObjectClass.DienTu;
//import com.checongbinh.lazada.Model.ObjectClass.SanPham;
//import com.checongbinh.lazada.Model.ObjectClass.ThuongHieu;
//import com.checongbinh.lazada.Presenter.TrangChu_DienTu.PresenterLogicDienTu;
import com.example.mystore.Adapter.AdapterDienTu;
import com.example.mystore.Adapter.AdapterThuongHieuLonDienTu;
import com.example.mystore.Adapter.AdapterTopDienThoaiDienTu;
import com.example.mystore.Model.ObjectClass.DienTu;
import com.example.mystore.Model.ObjectClass.SanPham;
import com.example.mystore.Model.ObjectClass.ThuongHieu;
import com.example.mystore.Presenter.TrangChu_DienTu.PresenterLogicDienTu;
import com.example.mystore.R;
import com.example.mystore.View.TrangChu.ViewDienTu;
import com.squareup.picasso.Picasso;
//import com.checongbinh.lazada.View.TrangChu.ViewDienTu;
//import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FragmentDienTu extends Fragment implements ViewDienTu {

    RecyclerView recyclerView,recylerTopCacThuongHieuLon,recylerHangMoiVe;
    List<DienTu> dienTuList;
    PresenterLogicDienTu presenterLogicDienTu;
    ImageView imSanPham1,imSanPham2,imSanPham3;
    TextView txtSanPham1,txtSanPham2,txtSanPham3;

    //add
    List<ThuongHieu> thuongHieuList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_dientu,container,false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerDienTu);
        recylerTopCacThuongHieuLon = (RecyclerView) view.findViewById(R.id.recylerTopCacThuongHieuLon);
        recylerHangMoiVe = (RecyclerView) view.findViewById(R.id.recylerHangMoiVe);
        imSanPham1 = (ImageView) view.findViewById(R.id.imSanPham1);
        imSanPham2 = (ImageView) view.findViewById(R.id.imSanPham2);
        imSanPham3 = (ImageView) view.findViewById(R.id.imSanPham3);
        txtSanPham1 = (TextView) view.findViewById(R.id.txtSanPham1);
        txtSanPham2 = (TextView) view.findViewById(R.id.txtSanPham2);
        txtSanPham3 = (TextView) view.findViewById(R.id.txtSanPham3);

        presenterLogicDienTu = new PresenterLogicDienTu(this);

        dienTuList = new ArrayList<>();

        // add
        thuongHieuList = new ArrayList<>();
//        presenterLogicDienTu.LayDanhSachDienTu();

        presenterLogicDienTu.LayDanhSachDienTu();
        presenterLogicDienTu.LayDanhSachLogoThuongHieu();
        presenterLogicDienTu.LayDanhSachSanPhamMoi();

        return view;
    }

    @Override
    public void HienThiDanhSach(List<DienTu> dienTus) {

        dienTuList = dienTus;

        AdapterDienTu adapterDienTu = new AdapterDienTu(getContext(),dienTuList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterDienTu);

        adapterDienTu.notifyDataSetChanged();
    }

    // add
    @Override
    public void HienThiDanhSachThuongHieu(List<ThuongHieu> thuongHieus) {

        thuongHieuList = thuongHieus;

        DienTu dienTu = new DienTu();
        dienTu.setThuongHieus(thuongHieus);

        dienTuList.add(dienTu);

        AdapterDienTu adapterDienTu = new AdapterDienTu(getContext(),dienTuList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterDienTu);

        adapterDienTu.notifyDataSetChanged();
    }

    @Override
    public void HienThiLogoThuongHieu(List<ThuongHieu> thuongHieus) {
        AdapterThuongHieuLonDienTu adapterThuongHieuLonDienTu = new AdapterThuongHieuLonDienTu(getContext(),thuongHieus);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2,GridLayoutManager.HORIZONTAL,false);

        recylerTopCacThuongHieuLon.setLayoutManager(layoutManager);
        recylerTopCacThuongHieuLon.setAdapter(adapterThuongHieuLonDienTu);
        adapterThuongHieuLonDienTu.notifyDataSetChanged();

    }

    @Override
    public void LoiLayDuLieu() {

    }

    @Override
    public void HienThiSanPhamMoiVe(List<SanPham> sanPhams) {
        AdapterTopDienThoaiDienTu adapterTopDienThoaiDienTu = new AdapterTopDienThoaiDienTu(getContext(),R.layout.custom_layout_topdienthoaivamaytinhbang,sanPhams);

        RecyclerView.LayoutManager layoutManagerTop = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recylerHangMoiVe.setLayoutManager(layoutManagerTop);
        recylerHangMoiVe.setAdapter(adapterTopDienThoaiDienTu);

        adapterTopDienThoaiDienTu.notifyDataSetChanged();
        Random random = new Random();

        int vitri = random.nextInt(sanPhams.size());

//        Picasso.with(getContext()).load(sanPhams.get(vitri).getANHLON()).fit().centerInside().into(imSanPham1);
        Picasso.with(getContext()).load(sanPhams.get(vitri).getANHLON()).resize(180,90).centerInside().into(imSanPham1);

        txtSanPham1.setText(sanPhams.get(vitri).getTENSP());
//        Log.d("SANPHAMMOIVE", sanPhams.get(vitri).getANHLON());
        int vitri1 = random.nextInt(sanPhams.size());
//        Picasso.with(getContext()).load(sanPhams.get(vitri1).getANHLON()).fit().centerInside().into(imSanPham2);
        Picasso.with(getContext()).load(sanPhams.get(vitri1).getANHLON()).resize(180,90).centerInside().into(imSanPham2);

        txtSanPham2.setText(sanPhams.get(vitri1).getTENSP());

        int vitri2 = random.nextInt(sanPhams.size());
//        Picasso.with(getContext()).load(sanPhams.get(vitri2).getANHLON()).fit().centerInside().into(imSanPham3);
        Picasso.with(getContext()).load(sanPhams.get(vitri2).getANHLON()).resize(180,90).centerInside().into(imSanPham3);

        txtSanPham3.setText(sanPhams.get(vitri2).getTENSP());
    }
}
