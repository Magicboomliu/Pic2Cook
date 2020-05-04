package com.example.pic2cook_develop.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pic2cook_develop.R;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Wechat_login extends AppCompatActivity {

    private TextView Skip;
    private TextView Right_resolve;
    private Button Wechat_btn;
    private Button Phone_numerber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wechat_login);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();//隐藏标题栏
        Skip = findViewById(R.id.skip_wechat);
        Right_resolve =findViewById(R.id.rights_resolved);
        Wechat_btn =findViewById(R.id.Use_wechat_to_log_in);
        Phone_numerber =findViewById(R.id.Use_phone_to_log_in);
        Right_resolve.setText(Html.fromHtml("<s>"+"登录即代表您同意Pic2Cook"+"<u>"+"《用户协议》"+"<u>"+"与"
        +"<u>"+"《隐私政策》"+"<u>"+"<s>"));

        // Log in By Wechat

          Wechat_btn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent it2 =new Intent(getApplicationContext(),wechat_moon.class);
                  startActivity(it2);
              }
          });


        //Log in By Phone
        Phone_numerber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(Wechat_login.this);
                dialog.setTitle("系统提示");
                dialog.setMessage("Pic2Cook正在企图获得您的电话号码与通信录信息");
                dialog.setCancelable(true);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
            }
        });


    }
}
