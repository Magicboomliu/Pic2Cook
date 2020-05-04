package com.example.pic2cook_develop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.pic2cook_develop.guidepage.guide_page_container;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {
    private TextView cntdown;
    private String TAG="Splash";



    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            cntdown.setText(msg.what + "s");
            Log.d(TAG,"From hander:"+String.valueOf(msg.what));
            }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();//隐藏标题栏
        setContentView(R.layout.activity_splash);
        cntdown = findViewById(R.id.cnt_down);


        Thread myThread=new Thread(){//创建子线程
            @Override
            public void run() {
                try{
                    for (int i =4;i>=0;i--){
                    handler.sendEmptyMessage(i);
                    Log.d(TAG,"from Thread"+String.valueOf(i));
                    Thread.sleep(1000); }
                    Intent it=new Intent(getApplicationContext(), guide_page_container.class);//启动MainActivity
                    startActivity(it);
                    finish();//关闭当前活动

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };

        myThread.start();//启动线程


    }
}
