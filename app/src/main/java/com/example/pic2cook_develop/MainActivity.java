package com.example.pic2cook_develop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import about.whole_container_about;
import cooks.whole_container;
import market.whole_container_market;
import my.whole_container_my;
import saves.whole_container_saves;

public class MainActivity extends AppCompatActivity {

    private long exitTime =0;
    //引入底部导航栏的碎片
    private whole_container wc_cook;
    private whole_container_market wc_market;
    private whole_container_my wc_my;
    private whole_container_about wc_about;
    private whole_container_saves wc_saves;

    private  ImageView cook;
    private  ImageView me;
    private  ImageView saves;
    private  ImageView market;
    private ImageView about;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();//隐藏标题
        //实例化下厨
        wc_cook =new whole_container();
        wc_about = new whole_container_about();
        wc_market = new whole_container_market();
        wc_my = new whole_container_my();
        wc_saves =new whole_container_saves();

        getSupportFragmentManager().beginTransaction().add(R.id.FL_C,wc_cook).commitAllowingStateLoss();
        cook = findViewById(R.id.cook_contents);
        me = findViewById(R.id.my_contents);
        saves = findViewById(R.id.save_contents);
        market = findViewById(R.id.market_contents);
        about =findViewById(R.id.about_contents);

        cook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                me.setBackground(getResources().getDrawable(R.drawable.under_me_normal));
                saves.setBackground(getResources().getDrawable(R.drawable.under_saved_checked));
                market.setBackground(getResources().getDrawable(R.drawable.under_market_normal));
                about.setBackground(getResources().getDrawable(R.drawable.under_about_normal));

                cook.setBackground(getResources().getDrawable(R.drawable.under_cook_checked));
                FragmentManager fm1 = getSupportFragmentManager();
                FragmentTransaction transaction = fm1.beginTransaction();
                transaction.setCustomAnimations(R.anim.slide_right_in,R.anim.slide_left_out);
                transaction.replace(R.id.FL_C,wc_cook);
                transaction.addToBackStack(null);
                transaction.commitAllowingStateLoss();

            }
        });

        me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cook.setBackground(getResources().getDrawable(R.drawable.under_cook_normal));
                saves.setBackground(getResources().getDrawable(R.drawable.under_saved_checked));
                market.setBackground(getResources().getDrawable(R.drawable.under_market_normal));
                about.setBackground(getResources().getDrawable(R.drawable.under_about_normal));


                me.setBackground(getResources().getDrawable(R.drawable.under_me_checked));
                FragmentManager fm1 = getSupportFragmentManager();
                FragmentTransaction transaction = fm1.beginTransaction();
                transaction.setCustomAnimations(R.anim.slide_right_in,R.anim.slide_left_out);
                transaction.replace(R.id.FL_C,wc_my);
                transaction.addToBackStack(null);
                transaction.commitAllowingStateLoss();
            }
        });

        saves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                me.setBackground(getResources().getDrawable(R.drawable.under_me_normal));
                cook.setBackground(getResources().getDrawable(R.drawable.under_cook_normal));
                market.setBackground(getResources().getDrawable(R.drawable.under_market_normal));
                about.setBackground(getResources().getDrawable(R.drawable.under_about_normal));

                saves.setBackground(getResources().getDrawable(R.drawable.under_saved_normal));
                FragmentManager fm1 = getSupportFragmentManager();
                FragmentTransaction transaction = fm1.beginTransaction();
                transaction.setCustomAnimations(R.anim.slide_right_in,R.anim.slide_left_out);
                transaction.replace(R.id.FL_C,wc_saves);
                transaction.addToBackStack(null);
                transaction.commitAllowingStateLoss();
            }
        });
        market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                me.setBackground(getResources().getDrawable(R.drawable.under_me_normal));
                saves.setBackground(getResources().getDrawable(R.drawable.under_saved_checked));
                cook.setBackground(getResources().getDrawable(R.drawable.under_cook_normal));
                about.setBackground(getResources().getDrawable(R.drawable.under_about_normal));

                market.setBackground(getResources().getDrawable(R.drawable.under_market_checked));
                FragmentManager fm1 = getSupportFragmentManager();
                FragmentTransaction transaction = fm1.beginTransaction();
                transaction.setCustomAnimations(R.anim.slide_right_in,R.anim.slide_left_out);
                transaction.replace(R.id.FL_C,wc_market);
                transaction.addToBackStack(null);
                transaction.commitAllowingStateLoss();
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                me.setBackground(getResources().getDrawable(R.drawable.under_me_normal));
                saves.setBackground(getResources().getDrawable(R.drawable.under_saved_checked));
                market.setBackground(getResources().getDrawable(R.drawable.under_market_normal));
                cook.setBackground(getResources().getDrawable(R.drawable.under_cook_normal));
                about.setBackground(getResources().getDrawable(R.drawable.under_about_checked));
                FragmentManager fm1 = getSupportFragmentManager();
                FragmentTransaction transaction = fm1.beginTransaction();
                transaction.setCustomAnimations(R.anim.slide_right_in,R.anim.slide_left_out);
                transaction.replace(R.id.FL_C,wc_about);
                transaction.addToBackStack(null);
                transaction.commitAllowingStateLoss();

            }
        });

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            exit();
            return false;

        }

        return super.onKeyDown(keyCode, event);


    }

    private void exit(){
        if((System.currentTimeMillis()-exitTime)>2000){
            Toast.makeText(getApplicationContext(),
                    "再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime=System.currentTimeMillis();}

        else{
                finish();
                System.exit(0);
            }
        }
}
