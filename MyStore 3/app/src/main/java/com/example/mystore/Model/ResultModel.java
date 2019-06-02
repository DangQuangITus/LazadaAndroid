package com.example.mystore.Model;

import com.example.mystore.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultModel {

    @SerializedName("result")
    @Expose
    private Boolean result;

    @SerializedName("user")
    @Expose
    private User user;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
