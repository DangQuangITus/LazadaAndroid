package com.example.mystore.View.TrangChu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mystore.Adapter.ExpandAdater;
import com.example.mystore.Adapter.ViewPagerAdapter;
import com.example.mystore.Model.DangNhap_DangKy.ModelDangNhap;
import com.example.mystore.Model.ObjectClass.LoaiSanPham;
import com.example.mystore.Presenter.TrangChu.XuLyMenu.PresenterLogicXuLyMenu;
import com.example.mystore.R;
import com.example.mystore.View.DangNhapDangKy.DangNhapActivity;
import com.example.mystore.View.GioHang.GioHangActivity;
import com.facebook.AccessToken;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.List;

public class TrangChuActivity extends AppCompatActivity implements ViewXuLyMenu, GoogleApiClient.OnConnectionFailedListener, AppBarLayout.OnOffsetChangedListener {
    public static List<LoaiSanPham> listSP = null;
    public static Context context;

//    public static final String SERVER_NAME = "http://192.168.100.7:8000/users";
public static final String SERVER_NAME = "http://192.168.56.1:8000";
    public static final String SERVER = "http://192.168.10.7/weblazada";
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    ExpandableListView expandableListView;
    PresenterLogicXuLyMenu logicXuLyMenu;
    String tennguoidung = "";
    AccessToken accessToken;
    Menu menu;
    ModelDangNhap modelDangNhap;
    MenuItem itemDangNhap, menuITDangXuat;
    GoogleApiClient mGoogleApiClient;
    GoogleSignInResult googleSignInResult;
    CollapsingToolbarLayout collapsingToolbarLayout;
    AppBarLayout appBarLayout;
    TextView txtGioHang;
    boolean onPause = false;

    Handler myHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.trangchu_layout);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        expandableListView = (ExpandableListView) findViewById(R.id.epMenu);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // đồng bộ drawerLayout
        drawerToggle.syncState();

        // support gói thư viện hỗ trợ
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        logicXuLyMenu = new PresenterLogicXuLyMenu(this);
        modelDangNhap = new ModelDangNhap();

        // hàm này
        logicXuLyMenu.LayDanhSachMenu();

        mGoogleApiClient = modelDangNhap.LayGoogleApiClient(this, this);

        appBarLayout.addOnOffsetChangedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.menutrangchu, menu);
        this.menu = menu;
//
        MenuItem iGioHang = menu.findItem(R.id.itGioHang);
        View giaoDienCustomGioHang = MenuItemCompat.getActionView(iGioHang);
        txtGioHang = (TextView) giaoDienCustomGioHang.findViewById(R.id.txtSoLuongSanPhamGioHang);
//
        giaoDienCustomGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iGioHang = new Intent(TrangChuActivity.this, GioHangActivity.class);
                TrangChuActivity.this.startActivity(iGioHang);
            }
        });
//
//        PresenterLogicChiTietSanPham presenterLogicChiTietSanPham = new PresenterLogicChiTietSanPham();
//        txtGioHang.setText(String.valueOf(presenterLogicChiTietSanPham.DemSanPhamCoTrongGioHang(this)));
//
        itemDangNhap = menu.findItem(R.id.itDangNhap);
        menuITDangXuat = menu.findItem(R.id.itDangXuat);
//
//        accessToken = logicXuLyMenu.LayTokenDungFacebook();
//        googleSignInResult = modelDangNhap.LayThongDangNhapGoogle(mGoogleApiClient);
//
//        if(accessToken != null){
//            GraphRequest graphRequest = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
//                @Override
//                public void onCompleted(JSONObject object, GraphResponse response) {
//                    try {
//                        tennguoidung = object.getString("name");
//
//                        itemDangNhap.setTitle(tennguoidung);
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//
//            Bundle parameter = new Bundle();
//            parameter.putString("fields","name");
//
//            graphRequest.setParameters(parameter);
//            graphRequest.executeAsync();
//        }
//
//
//        if(googleSignInResult != null){
//            itemDangNhap.setTitle(googleSignInResult.getSignInAccount().getDisplayName());
//            Log.d("goo",googleSignInResult.getSignInAccount().getDisplayName());
//        }
//
//        String tennv = modelDangNhap.LayCachedDangNhap(this);
//        if(!tennv.equals("")){
//            itemDangNhap.setTitle(tennv);
//        }
//
//
//        if(accessToken != null || googleSignInResult != null || !tennv .equals("")){
//            menuITDangXuat.setVisible(true);
//        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // chon menu ben trai
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        int id = item.getItemId();
        switch (id) {
            case R.id.itDangNhap:
//                if(accessToken == null && googleSignInResult == null && modelDangNhap.LayCachedDangNhap(this).equals("")){
                Intent iDangNhap = new Intent(TrangChuActivity.this, DangNhapActivity.class);
                TrangChuActivity.this.startActivity(iDangNhap);
//                };
                break;
//            case R.id.itDangXuat:
//                if(accessToken != null){
//                    LoginManager.getInstance().logOut();
//                    this.menu.clear();
//                    this.onCreateOptionsMenu(this.menu);
//                }
//
//                if(googleSignInResult != null){
//                    Auth.GoogleSignInApi.signOut(mGoogleApiClient);
//                    this.menu.clear();
//                    this.onCreateOptionsMenu(this.menu);
//
//                }
//
//                if(!modelDangNhap.LayCachedDangNhap(this).equals("")){
//                    modelDangNhap.CapNhatCachedDangNhap(this,"");
//                    this.menu.clear();
//                    this.onCreateOptionsMenu(this.menu);
//                }
//                break;
//
//            case R.id.itSearch:
//                Intent iTimKiem = new Intent(this, TimKiemActivity.class);
//                startActivity(iTimKiem);
//                break;

        }

        return true;
    }

    @Override
    public void HienThiDanhSachMenu(ViewXuLyMenu viewXuLyMenu, List<LoaiSanPham> loaiSanPhamList) {
        for (int i = 0; i < loaiSanPhamList.size(); i++) {
            Log.d("TRANGCHU_LISTSP", loaiSanPhamList.get(i).getTENLOAISP());
        }
        listSP = loaiSanPhamList;

        final ExpandAdater expandAdater = new ExpandAdater(viewXuLyMenu, this, listSP);
        runOnUiThread(() -> {
            expandableListView.setAdapter(expandAdater);
            expandAdater.notifyDataSetChanged();
        });
        expandAdater.loadData(listSP);

    }

    @Override
    public void HienThiDanhSachMenuCon(ExpandAdater.SecondExpanable secondExpanable, ExpandAdater secondAdapter) {
       runOnUiThread( () -> secondExpanable.setAdapter(secondAdapter));

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

        if (collapsingToolbarLayout.getHeight() + verticalOffset <= 1.5 * ViewCompat.getMinimumHeight(collapsingToolbarLayout)) {
            LinearLayout linearLayout = (LinearLayout) appBarLayout.findViewById(R.id.lnSearch);
            linearLayout.animate().alpha(0).setDuration(200);

            MenuItem itSearch = menu.findItem(R.id.itSearch);
            itSearch.setVisible(true);

        } else {
            LinearLayout linearLayout = (LinearLayout) appBarLayout.findViewById(R.id.lnSearch);
            linearLayout.animate().alpha(1).setDuration(200);
            try {
                MenuItem itSearch = menu.findItem(R.id.itSearch);
                itSearch.setVisible(false);
            } catch (Exception e) {

            }

        }
    }
}

