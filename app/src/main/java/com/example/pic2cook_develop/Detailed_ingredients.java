package com.example.pic2cook_develop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pic2cook_develop.picks.pick_fives;
import com.example.pic2cook_develop.picks.pick_fours;
import com.example.pic2cook_develop.picks.pick_ones;
import com.example.pic2cook_develop.picks.pick_sixs;
import com.example.pic2cook_develop.picks.pick_threes;
import com.example.pic2cook_develop.picks.pick_twos;
import com.mob.MobSDK;

import org.w3c.dom.Text;

import cn.sharesdk.onekeyshare.OnekeyShare;

public class Detailed_ingredients extends AppCompatActivity {

    private ImageView back;
    private ImageView share;
    private int thePageNow=1;
    private int isRight =1;
    private ImageView previous;
    private ImageView next;

    // Scr steps
    private pick_ones p1;
    private pick_twos p2;
    private pick_threes p3;
    private pick_fours p4;
    private pick_fives p5;
    private pick_sixs p6;
    private TextView steps_no;
    private TextView detailed_distription_pick;

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
        setContentView(R.layout.activity_detailed_ingredients);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();//隐藏标题
        back =findViewById(R.id.back_detailed);
        share =findViewById(R.id.share_to_inder);
        steps_no =findViewById(R.id.steps_no_pick);
        detailed_distription_pick =findViewById(R.id.detailed_discriptions_pick);

        //教程轮播的实例
        p1 = new pick_ones();
        p2 =new pick_twos();
        p3 =new pick_threes();
        p4= new pick_fours();
        p5= new pick_fives();
        p6 =new pick_sixs();
        next = findViewById(R.id.get_next_method);
        previous =findViewById(R.id.get_prevous_method);

        getSupportFragmentManager().beginTransaction().add(R.id.detailed_item,p1).commitAllowingStateLoss();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(it);
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShare();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (thePageNow>1&&thePageNow<7)
                {
                     thePageNow--;
                     setTexts(thePageNow);
                    isRight=0;
                    changetheSlide(thePageNow+1,isRight);
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(thePageNow>0&&thePageNow<6){
                    thePageNow++;
                    setTexts(thePageNow);
                    isRight=1;
                    changetheSlide(thePageNow-1,isRight);
                }
            }
        });

    }

    public void changetheSlide(int now, int dirextion){
        FragmentManager fm1 = getSupportFragmentManager();
        FragmentTransaction transaction = fm1.beginTransaction();
        if(now==1&&dirextion==1)
        {
            transaction.setCustomAnimations(R.anim.card_flip_right_in,R.anim.card_flip_left_out);
            transaction.replace(R.id.detailed_item,p2);
            transaction.addToBackStack(null);
            transaction.commitAllowingStateLoss();
        }
        if(now ==2&&dirextion==1)
        {
            transaction.setCustomAnimations(R.anim.card_flip_right_in,R.anim.card_flip_left_out);
            transaction.replace(R.id.detailed_item,p3);
            transaction.addToBackStack(null);
            transaction.commitAllowingStateLoss();
        }
        if (now==3&& dirextion==1){

            transaction.setCustomAnimations(R.anim.card_flip_right_in,R.anim.card_flip_left_out);
            transaction.replace(R.id.detailed_item,p4);
            transaction.addToBackStack(null);
            transaction.commitAllowingStateLoss();
        }
        if(now==4 &&dirextion==1)
        {

            transaction.setCustomAnimations(R.anim.card_flip_right_in,R.anim.card_flip_left_out);
            transaction.replace(R.id.detailed_item,p5);
            transaction.addToBackStack(null);
            transaction.commitAllowingStateLoss();

        }
        if (now==5 &&dirextion ==1)
        {

            transaction.setCustomAnimations(R.anim.card_flip_right_in,R.anim.card_flip_left_out);
            transaction.replace(R.id.detailed_item,p6);
            transaction.addToBackStack(null);
            transaction.commitAllowingStateLoss();

        }
        if(now==6&&dirextion ==0){

            transaction.setCustomAnimations(R.anim.card_flip_right_in,R.anim.card_flip_left_out);
            transaction.replace(R.id.detailed_item,p5);

            transaction.commitAllowingStateLoss();

        }
        if(now==5&&dirextion ==0){

            transaction.setCustomAnimations(R.anim.card_flip_right_in,R.anim.card_flip_left_out);
            transaction.replace(R.id.detailed_item,p4);

            transaction.commitAllowingStateLoss();

        }
        if(now==4&&dirextion ==0){

            transaction.setCustomAnimations(R.anim.card_flip_right_in,R.anim.card_flip_left_out);
            transaction.replace(R.id.detailed_item,p3);

            transaction.commitAllowingStateLoss();

        }
        if(now==3&&dirextion ==0){

            transaction.setCustomAnimations(R.anim.card_flip_right_in,R.anim.card_flip_left_out);
            transaction.replace(R.id.detailed_item,p2);

            transaction.commitAllowingStateLoss();

        }
        if(now==2&&dirextion ==0){

            transaction.setCustomAnimations(R.anim.card_flip_right_out,R.anim.card_flip_left_in);
            transaction.replace(R.id.detailed_item,p1);

            transaction.commitAllowingStateLoss();

        }





    }
    public  void setTexts(int now){
        if (now==1){
            steps_no.setText("1/6 一看茭白的外形 ");
            detailed_distription_pick.setText(" 如果茭白的外形比较嫩滑、光亮，而且饱满，笋身比较直，笋皮摸起来很顺溜的话，\n" +
                    "一般来说笋肉还是比较新鲜的。这样的茭白还是值得购买的。");
        }
        if(now==2)
        {
            steps_no.setText("2/6 二看茭白的笋身");
            detailed_distription_pick.setText("如果在购买的过程中，遇到那种笋身扁瘦的、弯曲的、形状不完整的，这样的茭白口感会比较差 不建议选购。此时应当选择那种矮胖矮胖型的，类似于棒槌型的茭白。");

        }
        if(now==3)
        {
            steps_no.setText("3/6 三看茭白的颜色");
            detailed_distription_pick.setText(" 茭白的外皮一定要是很白的，如果发现有的茭白有部分是偏红的，这种黄色有点类似姜黄，\n" +
                    "说明茭白就偏老了，老的茭白口感自然要差得多，所以不建议购买");

        }
        if(now==4){
            steps_no.setText("4/6 四看茭白的笋壳");
            detailed_distription_pick.setText("四看茭白的笋壳\n" +
                    "茭白顶端的笋壳若是颜色过绿的话，或是笋白的部分都是青绿色的话，\n" +
                    "这样的茭白已经过度成熟、老化，口感自然不佳，此类茭白遇上了可千万不要购买哟.");

        }
        if(now==5)
        {
            steps_no.setText("5/6 五看茭白的香味");
            detailed_distription_pick.setText("通常情况下，如果遇到的是刚采摘回来不久的茭白，新鲜度比较高，会散发一股清香，\n" +
                    "若是你闻到的茭白有异味的话，建议不要购买，有可能是不发商贩为了提高茭白的白亮度而用药水浸泡引起的");

        }
        if(now==6)
        {
            steps_no.setText("6/6 六看茭白的肉质");
            detailed_distription_pick.setText("茭白若是过期老化了的话，肉质会松软，此时里边寄生的菌丝会产生厚膜孢子，在肉质内部产生黑点，\n" +
                    "当黑点逐步扩大成为黑褐色的比较大的斑点的话，这类茭白是不能购买的.");

        }
    }
}
