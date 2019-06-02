package com.example.mystore.View.TrangChu.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import com.checongbinh.lazada.Adapter.AdapterNoiBat;
import com.example.mystore.Adapter.AdapterNoiBat;
import com.example.mystore.Model.ObjectClass.SanPham;
import com.example.mystore.Model.TrangChu_DienTu.ModelDienTu;
import com.example.mystore.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentNoiBat extends Fragment {
    RecyclerView recyclerView;
    AdapterNoiBat adapterNoiBat;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_noibat,container,false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyleNoiBat);
        List<String> dulieu = new ArrayList<>();
        ModelDienTu modelDienTu = new ModelDienTu();
        List<SanPham> sanPhamList = modelDienTu.LayDanhSachSanPhamTOP("LayDanhSachTopDienThoaiVaMayTinhBang","TOPDIENTHOAI&MAYTINHBANG");
        for (int i=0 ;i<50;i++){
            String ten = " San pham noi bat " + i;
            dulieu.add(ten);
        }


//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),3);
        adapterNoiBat = new AdapterNoiBat(getActivity(),dulieu);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterNoiBat);

        adapterNoiBat.notifyDataSetChanged();
        return view;
    }
}
