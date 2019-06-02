package com.example.mystore.Adapter;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mystore.Model.ObjectClass.LoaiSanPham;
import com.example.mystore.Model.TrangChu.XuLyMenu.XuLyJSONMenu;
import com.example.mystore.R;
import com.example.mystore.View.TrangChu.ViewXuLyMenu;

import java.util.Arrays;
import java.util.List;

public class ExpandAdater extends BaseExpandableListAdapter {

    private Context context;
    private List<LoaiSanPham> loaiSanPhams;
    ViewXuLyMenu viewXuLyMenu;
//    ViewHolderMenu viewHolderMenu;

    // tao constructor
    public ExpandAdater(ViewXuLyMenu viewXuLyMenu, Context context, List<LoaiSanPham> listLoaiSanPham) {
        this.context = context;
        this.loaiSanPhams = listLoaiSanPham;
        this.viewXuLyMenu = viewXuLyMenu;
    }

    public void loadData(List<LoaiSanPham> listLoaiSanPham) {
        XuLyJSONMenu xuLyJSONMenu = new XuLyJSONMenu();

        int count = loaiSanPhams.size();
        for (int i = 0; i < count; i++) {
            Log.d("GetCount", "i: " + i);
            final LoaiSanPham loaiSanPham = listLoaiSanPham.get(i);
            int maloaisp = loaiSanPham.getMALOAISP();
            List<LoaiSanPham> listcon = xuLyJSONMenu.LayLoaiSanPhamTheoMaLoai(maloaisp);
            loaiSanPham.setListCon(listcon);
            Log.d("GetCount", "ExpandAdater size list con" + loaiSanPhams.get(i));
        }

//        notifyDataSetChanged();
    }

    public List<LoaiSanPham> getLoaiSanPhams() {
        return loaiSanPhams;
    }

    @Override
    public int getGroupCount() {
        return loaiSanPhams.size();
    }

    @Override
    public int getChildrenCount(int viTriGroupCha) {
        if (this.loaiSanPhams.get(viTriGroupCha).getListCon() != null) {
            Log.d("GetCount", " : " + loaiSanPhams.get(viTriGroupCha).getListCon().size() + " - viTriGroupCha: " + viTriGroupCha);
            return 1; // Moi cha chi co 1 con dk display
        } else {
            Log.d("GetCount", " NULL ");
            return 0;
        }

    }

    @Override
    public Object getGroup(int viTriGroupCha) {
        return this.loaiSanPhams;
    }

    @Override
    public Object getChild(int viTriGroupCha, int viTriGroupCon) {
        return this.loaiSanPhams.get(viTriGroupCha).getListCon().get(viTriGroupCon);
    }

    @Override
    public long getGroupId(int viTriGroupCha) {
        return this.loaiSanPhams.get(viTriGroupCha).getMALOAISP();
    }

    @Override
    public long getChildId(int viTriGroupCha, int viTriGroupCon) {
        return this.loaiSanPhams.get(viTriGroupCha).getListCon().get(viTriGroupCon).getMALOAISP();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int viTriGroupCha, boolean isExpanded, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewGroupCha = layoutInflater.inflate(R.layout.custom_layout_group_cha, viewGroup, false);

        TextView txtTenLoaiSP = (TextView) viewGroupCha.findViewById(R.id.txtTenLoaiSP);
        txtTenLoaiSP.setText(this.loaiSanPhams.get(viTriGroupCha).getTENLOAISP());
        return viewGroupCha;
    }

    @Override
    public View getChildView(int viTriGroupCha, int viTriGroupCon, boolean isLastChild, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewGroupCon = layoutInflater.inflate(R.layout.custom_layout_group_con, viewGroup, false);
        ExpandableListView expandableListView = (ExpandableListView) viewGroupCon.findViewById(R.id.epMenuCon);
        SecondExpanable secondExpanable = new SecondExpanable(context);

        ExpandAdater secondAdapter = new ExpandAdater(viewXuLyMenu, context,loaiSanPhams.get(viTriGroupCha).getListCon());
        viewXuLyMenu.HienThiDanhSachMenuCon(secondExpanable, secondAdapter);
//        secondExpanable.setAdapter(secondAdapter);

        secondExpanable.setGroupIndicator(null);
        notifyDataSetChanged();

        return secondExpanable;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    // Menu da cap
    public class SecondAdapter extends BaseExpandableListAdapter {
        List<LoaiSanPham> listCon;

        public SecondAdapter(List<LoaiSanPham> listCon) {
            this.listCon = listCon;

            XuLyJSONMenu xuLyJSONMenu = new XuLyJSONMenu();

            int count = listCon.size();
            for (int i = 0; i < count; i++) {
                int maloaisp = listCon.get(i).getMALOAISP();
                listCon.get(i).setListCon(xuLyJSONMenu.LayLoaiSanPhamTheoMaLoai(maloaisp));
            }
        }

        @Override
        public int getGroupCount() {
            return listCon.size();
        }

        @Override
        public int getChildrenCount(int vitriGroupCha) {
            return listCon.get(vitriGroupCha).getListCon().size();
        }

        @Override
        public Object getGroup(int vitriGroupCha) {
            return listCon.get(vitriGroupCha);
        }

        @Override
        public Object getChild(int vitriGroupCha, int vitriGroupCon) {
            return listCon.get(vitriGroupCha).getListCon().get(vitriGroupCon);
        }

        @Override
        public long getGroupId(int vitriGroupCha) {
            return listCon.get(vitriGroupCha).getMALOAISP();
        }

        @Override
        public long getChildId(int vitriGroupCha, int vitriGroupCon) {
            return listCon.get(vitriGroupCha).getListCon().get(vitriGroupCon).getMALOAISP();
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int vitriGroupCha, boolean isExpanded, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View viewGroupCha = layoutInflater.inflate(R.layout.custom_layout_group_cha, viewGroup, false);
            TextView txtTenLoaiSP = (TextView) viewGroupCha.findViewById(R.id.txtTenLoaiSP);
            txtTenLoaiSP.setText(listCon.get(vitriGroupCha).getTENLOAISP());

            return viewGroupCha;
        }

        @Override
        public View getChildView(int vitriGroupCha, int vitriGroupCon, boolean isExpanded, View view, ViewGroup viewGroup) {
            TextView tv = new TextView(context);
            tv.setText(listCon.get(vitriGroupCha).getListCon().get(vitriGroupCon).getTENLOAISP());
            tv.setPadding(15, 5, 5, 5);
            tv.setLayoutParams(new ListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return tv;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return true;
        }
    }

    public class SecondExpanable extends ExpandableListView {

        public SecondExpanable(Context context) {
            super(context);
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Display display = windowManager.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);

            int width = size.x;
            int height = size.y;
            Log.d("size",width + " - " + height);

            widthMeasureSpec = MeasureSpec.makeMeasureSpec(width,MeasureSpec.AT_MOST);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(height,MeasureSpec.AT_MOST);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

}
