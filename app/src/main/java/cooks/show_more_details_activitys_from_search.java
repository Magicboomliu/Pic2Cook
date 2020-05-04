package cooks;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.pic2cook_develop.R;
import com.mob.MobSDK;

import cn.sharesdk.onekeyshare.OnekeyShare;

public class show_more_details_activitys_from_search extends AppCompatActivity {

    private ProgressDialog pg1;
    private Button share;
    private Button saves;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_more_details_activitys_from_search);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();//隐藏标题
        share= findViewById(R.id.shareeeee);
        saves=findViewById(R.id.addddddd);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShare();
            }
        });



        WebView webView001 = findViewById(R.id.webview01);
        webView001.getSettings().setJavaScriptEnabled(true);
        webView001.setWebViewClient(new WebViewClient());
        Intent intent = getIntent();
        final String data =intent.getStringExtra("urls");
        saves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog =new AlertDialog.Builder(getApplicationContext());
                dialog.setTitle("食材清单生成提醒");
                dialog.setMessage("这个菜谱的食材清单已经生成，请在“我的”中查看");
                dialog.setCancelable(false);
                dialog.setPositiveButton("Ok.I get it", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setNegativeButton("Well,emm..", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
            }
        });

//
//        webView001.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
//                view.loadUrl(url);
//                return true;
//            }
//
//
//            //网络请求部分
//            @Override
//            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
//
//                url = url.toLowerCase();
//                if(url.contains("meishichina.com")){
//                    return super.shouldInterceptRequest(view, url);
//                }else{
////去掉广
//                    return new WebResourceResponse(null,null,null); } }});



        pg1 = new ProgressDialog(show_more_details_activitys_from_search.this);
        pg1.setTitle("正在加载详细的食谱信息");
        pg1.setMessage("Recipe is Loading");
        pg1.setCancelable(true);
        pg1.show();
        webView001.loadUrl(data);
        pg1.dismiss();


    }
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
}
