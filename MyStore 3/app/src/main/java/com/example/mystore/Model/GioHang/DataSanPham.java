package com.example.mystore.Model.GioHang;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DataSanPham extends SQLiteOpenHelper {

    public static String TB_GIOHANG = "GIOHANG";
    public static String TB_GIOHANG_MASP = "MASP";
    public static String TB_GIOHANG_TENSP = "TENSP";
    public static String TB_GIOHANG_GIATIEN = "GIATIEN";
    public static String TB_GIOHANG_HINHANH = "HINHANH";
    public static String TB_GIOHANG_SOLUONG = "SOLUONG";
    public static String TB_GIOHANG_SOLUONGTONKHO = "SOLUONGTONKHO";

    public static String TB_YEUTHICH = "YEUTHICH";
    public static String TB_YEUTHICH_MASP = "MASP";
    public static String TB_YEUTHICH_TENSP = "TENSP";
    public static String TB_YEUTHICH_GIATIEN = "GIATIEN";
    public static String TB_YEUTHICH_HINHANH = "HINHANH";

    public DataSanPham(Context context) {
        super(context, "SQLSANPHAM5", null, 1);
    }


    public DataSanPham(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
//    public DataSanPham(@androidx.annotation.Nullable Context context, @androidx.annotation.Nullable String name, @androidx.annotation.Nullable SQLiteDatabase.CursorFactory factory, int version, @androidx.annotation.Nullable DatabaseErrorHandler errorHandler) {
//        super(context, name, factory, version, errorHandler);
//    }
//
//    public DataSanPham(@androidx.annotation.Nullable Context context, @androidx.annotation.Nullable String name, int version, @androidx.annotation.NonNull SQLiteDatabase.OpenParams openParams) {
//        super(context, name, version, openParams);
//    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tbGioHang = "CREATE TABLE IF NOT EXISTS " + TB_GIOHANG + " ( ID  INTEGER PRIMARY KEY AUTOINCREMENT, " + TB_GIOHANG_MASP + " INTEGER , "
                + TB_GIOHANG_TENSP + " TEXT, " + TB_GIOHANG_GIATIEN + " REAL, " + TB_GIOHANG_HINHANH + " BLOB, "
                + TB_GIOHANG_SOLUONG + " INTEGER, " + TB_GIOHANG_SOLUONGTONKHO + " INTEGER );";

        String tbYeuThich = "CREATE TABLE " + TB_YEUTHICH + " (" + TB_YEUTHICH_MASP + " INTEGER PRIMARY KEY , "
                + TB_YEUTHICH_TENSP + " TEXT, " + TB_YEUTHICH_GIATIEN + " REAL, " + TB_YEUTHICH_HINHANH + "  BLOB);";

        db.execSQL(tbGioHang);
        db.execSQL(tbYeuThich);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
