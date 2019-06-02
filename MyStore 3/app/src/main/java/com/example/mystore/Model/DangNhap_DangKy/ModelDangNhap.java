package com.example.mystore.Model.DangNhap_DangKy;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.mystore.ConnectInternet.ApiUtils;
import com.example.mystore.Model.ResultModel;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

import retrofit2.Response;

/**
 * Created by Lenovo S410p on 7/2/2016.
 */
public class ModelDangNhap {
    AccessToken accessToken;
    AccessTokenTracker accessTokenTracker;

    public AccessToken LayTokenFacebookHienTai() {

        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
                accessToken = currentAccessToken;
            }
        };

        accessToken = AccessToken.getCurrentAccessToken();

        return accessToken;

    }

    public String LayCachedDangNhap(Context context) {
        SharedPreferences cachedDangNhap = context.getSharedPreferences("dangnhap", Context.MODE_PRIVATE);
        String tennv = cachedDangNhap.getString("tennv", "");

        return tennv;
    }

    public void CapNhatCachedDangNhap(Context context, String tenv) {
        SharedPreferences cachedDangNhap = context.getSharedPreferences("dangnhap", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = cachedDangNhap.edit();
        editor.putString("tennv", tenv);

        editor.commit();
    }

    public boolean KiemTraDangNhap(Context context, String tendangnhap, String matkhau) {
        final AtomicBoolean kiemtra = new AtomicBoolean(false);

        Log.d("LOG_IN", "START");
        Thread thread = new Thread(() -> {
            try {
                Response<ResultModel> response = ApiUtils.getServiceGenerator()
                        .dangNhap(tendangnhap,matkhau)
                        .execute();

                ResultModel result = response.body();


                if(result.getResult().equals(true)){
                    kiemtra.set(true);
                    CapNhatCachedDangNhap(context,result.getUser().getName());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return kiemtra.get();
    }

    public GoogleApiClient LayGoogleApiClient(Context context, GoogleApiClient.OnConnectionFailedListener failedListener) {
        GoogleApiClient mGoogleApiClient;
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(context)
                .enableAutoManage(((AppCompatActivity) context), failedListener)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        return mGoogleApiClient;
    }

    public GoogleSignInResult LayThongDangNhapGoogle(GoogleApiClient googleApiClient) {
        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(googleApiClient);
        if (opr.isDone()) {
            return opr.get();
        } else {
            return null;
        }
    }

    public void HuyTokenTracker() {
        accessTokenTracker.stopTracking();
    }
}
