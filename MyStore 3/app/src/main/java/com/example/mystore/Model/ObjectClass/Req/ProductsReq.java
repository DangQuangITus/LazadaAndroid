package com.example.mystore.Model.ObjectClass.Req;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class ProductsReq {
    @SerializedName("maloaicha")
    @Expose
    private RequestBody maLoaiCha;

    public ProductsReq(String maLoaiCha) {
        this.maLoaiCha = RequestBody.create(MediaType.parse("multipart/form-data"), maLoaiCha);
    }

    public RequestBody getmaLoaiCha() {
        return maLoaiCha;
    }

    public void setmaLoaiCha(RequestBody maLoaiCha) {
        this.maLoaiCha = maLoaiCha;
    }
}
