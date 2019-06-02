package com.example.mystore.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mystore.Model.GioHang.ModelGioHang;
import com.example.mystore.Model.ObjectClass.SanPham;
import com.example.mystore.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class AdapterGioHang extends RecyclerView.Adapter<AdapterGioHang.ViewHolderGiohang> {


    Context context = null;
    List<SanPham> sanPhamList = new ArrayList<>();

    public AdapterGioHang(Context context, List<SanPham> sanPhamList) {
        this.context = context;
        this.sanPhamList = sanPhamList;
    }

    public class ViewHolderGiohang extends RecyclerView.ViewHolder {

        TextView txtTenTieuDeGioHang, txtGiaTienGioHang, txtSoLuongSanPham;
        ImageView imHinhGioHang, imXoaSanPham;
        ImageButton imTangSoLuongSPGioHang, imGiamSoLuongSPGioHang;


        public ViewHolderGiohang(View itemView) {
            super(itemView);
            txtTenTieuDeGioHang = (TextView) itemView.findViewById(R.id.txtTieuDeGioHang);
            txtGiaTienGioHang = (TextView) itemView.findViewById(R.id.txtGiaGioHang);
            imHinhGioHang = (ImageView) itemView.findViewById(R.id.imHinhGioHang);
            imXoaSanPham = (ImageView) itemView.findViewById(R.id.imXoaSanPham);
            txtSoLuongSanPham = (TextView) itemView.findViewById(R.id.txtSoLuongSanPhamGioHang);
//            imGiamSoLuongSPGioHang = (ImageButton) itemView.findViewById(R.id.im);
//            imTangSoLuongSPGioHang = (ImageButton) itemView.findViewById(R.id.imTangSoLuongSPTrongGioHang);

        }
    }

    @Override
    public ViewHolderGiohang onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout_giohang, viewGroup, false);

        ViewHolderGiohang viewHolderGiohang = new ViewHolderGiohang(view);
        return viewHolderGiohang;
    }

    @Override
    public void onBindViewHolder(ViewHolderGiohang viewHolderGiohang, int i) {
        SanPham sanPham = sanPhamList.get(i);

        viewHolderGiohang.txtTenTieuDeGioHang.setText(sanPham.getTENSP());

        NumberFormat numberFormat = new DecimalFormat("###,###");
        String gia = numberFormat.format(sanPham.getGIA()).toString();
        viewHolderGiohang.txtGiaTienGioHang.setText(gia + " VNĐ ");

//        byte[] bytes = sanPham.getHinhgiohang();
//        Bitmap bitmapGioHang = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
//        viewHolderGiohang.imHinhGioHang.setImageBitmap(bitmapGioHang);


        viewHolderGiohang.imXoaSanPham.setTag(sanPham.getMASP());
        viewHolderGiohang.imXoaSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Xoa san pham", Toast.LENGTH_SHORT).show();
                ModelGioHang modelGioHang = new ModelGioHang();
                modelGioHang.MoKetNoiSQL(context);
                modelGioHang.XoaSanPhamTrongGioHang((int) v.getTag());
                sanPhamList.remove(i);
                notifyDataSetChanged();
            }
        });

//        viewHolderGiohang.txtSoLuongSanPham.setText(String.valueOf(sanPham.getSOLUONG()));

//        holder.imTangSoLuongSPGioHang.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int soluong = Integer.parseInt(holder.txtSoLuongSanPham.getText().toString());
//                int soluongtonkho = sanPham.getSOLUONGTONKHO();
//
//                if (soluong < soluongtonkho) {
//                    soluong++;
//                } else {
//                    Toast.makeText(context, "Số lượng sản phẩm bạn mua quá số lượng có trong kho của cửa hàng !", Toast.LENGTH_SHORT).show();
//                }
//
//                modelGioHang.CapNhatSoLuongSanPhamGioHang(sanPham.getMASP(), soluong);
//                holder.txtSoLuongSanPham.setText(String.valueOf(soluong));
//            }
//        });
//
//        holder.imGiamSoLuongSPGioHang.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int soluong = Integer.parseInt(holder.txtSoLuongSanPham.getText().toString());
//
//                if (soluong > 1) {
//                    soluong--;
//                }
//                modelGioHang.CapNhatSoLuongSanPhamGioHang(sanPham.getMASP(), soluong);
//                holder.txtSoLuongSanPham.setText(String.valueOf(soluong));
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return sanPhamList.size();
    }

}
