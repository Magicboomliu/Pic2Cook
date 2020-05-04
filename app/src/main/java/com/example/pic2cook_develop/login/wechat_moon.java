package com.example.pic2cook_develop.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.pic2cook_develop.MainActivity;
import com.example.pic2cook_develop.R;

public class wechat_moon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wechat_moon);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();//隐藏标题栏
        final Thread mythread = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    Intent it =new Intent(getApplicationContext(), Main2Activity.class);
                    startActivity(it);

                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        mythread.start();

    }
}
