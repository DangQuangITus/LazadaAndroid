package com.example.mystore.Adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mystore.Model.ObjectClass.SanPham;
import com.example.mystore.R;
import com.example.mystore.View.ChiTietSanPham.ChiTietSanPhamActivity;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterNoiBat extends RecyclerView.Adapter<AdapterNoiBat.ViewHolder> {
    Context context;
    //    List<String> stringList;
    // add
    List<SanPham> sanPhamList;

//    public AdapterNoiBat(Context context, List<String> stringList) {
//        this.context = context;
//        this.stringList = stringList;
//    }

    public AdapterNoiBat(Context context, List<SanPham> sanPhamList) {
        this.context = context;
        this.sanPhamList = sanPhamList;
    }

    //Chạy thứ 2
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.txtTieuDeNoiBat);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            cardView = (CardView) itemView.findViewById(R.id.cardviewNoiBat);

        }
    }

    //Chạy đầu tiên
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_recyclerview_noibat, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    //Chay thứ 3
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(sanPhamList.get(position).getTENSP());
        Picasso.with(context).load(sanPhamList.get(position).getANHLON()).fit().into(holder.imageView);
        final int masp = sanPhamList.get(position).getMASP();

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iChiTetSanPham = new Intent(context, ChiTietSanPhamActivity.class);
                iChiTetSanPham.putExtra("masp", (int) masp);
                context.startActivity(iChiTetSanPham);
            }
        });
    }

    @Override
    public int getItemCount() {
//        return stringList.size();
        return sanPhamList.size();
    }


}
