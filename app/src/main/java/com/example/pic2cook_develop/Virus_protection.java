package com.example.pic2cook_develop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mob.MobSDK;

import cn.sharesdk.onekeyshare.OnekeyShare;

public class Virus_protection extends AppCompatActivity {

    // init the instances

    private ImageView back;
    private ImageView share;

    //share to different platform
    private void showShare() {
        final OnekeyShare oks = new OnekeyShare();
        //指定分享的平台，如果为空，还是会调用九宫格的平台列表界面
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle("标题");
        // titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        //启动分享
        oks.show(MobSDK.getContext());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virus_protection);
         back =findViewById(R.id.back_virvus);
         share =findViewById(R.id.virvus_share);


         back.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent it3 = new Intent(getApplicationContext(),MainActivity.class);
                 startActivity(it3);
             }
         });
         share.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 showShare();
             }
         });

    }
}
