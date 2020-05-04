package com.example.pic2cook_develop.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.pic2cook_develop.R;
import com.example.pic2cook_develop.infoga.infos;

public class Main2Activity extends AppCompatActivity {
    private TextView skips;
    private TextView cancel;
    private Button wechat_agree;
    private Button whchat_cancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();//隐藏标题栏

        skips=findViewById(R.id.skip_wechat);
        cancel =findViewById(R.id.shut_down_wecaht);
        wechat_agree=findViewById(R.id.agree_wechat);
        whchat_cancel =findViewById(R.id.disagree_wechat);


        skips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1= new Intent(getApplicationContext(), infos.class);

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it2 =new Intent(getApplicationContext(),Wechat_login.class);
                startActivity(it2);
            }
        });
        wechat_agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it3 =new Intent(getApplicationContext(),infos.class);
                startActivity(it3);
            }
        });
        whchat_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it4 = new Intent(getApplicationContext(),Wechat_login.class);
                startActivity(it4);
            }
        });



    }

}
