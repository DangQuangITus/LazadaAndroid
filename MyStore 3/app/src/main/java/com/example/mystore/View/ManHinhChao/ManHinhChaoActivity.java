package com.example.mystore.View.ManHinhChao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.example.mystore.R;
import com.example.mystore.View.TrangChu.TrangChuActivity;


public class ManHinhChaoActivity extends AppCompatActivity {

    Toolbar toolbar;
    LinearLayout ll = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manhinhchao_layout);

        setSupportActionBar(toolbar);
        ll = (LinearLayout) findViewById(R.id.llMainScreen);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iTrangChu = new Intent(ManHinhChaoActivity.this, TrangChuActivity.class);
                startActivity(iTrangChu);
            }
        });
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3500);
                } catch (Exception e) {

                } finally {
                    Intent iTrangChu = new Intent(ManHinhChaoActivity.this, TrangChuActivity.class);
                    startActivity(iTrangChu);
                }
            }
        });

        thread.start();
    }
}
