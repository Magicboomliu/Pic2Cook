package com.example.pic2cook_develop.infoga;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.example.pic2cook_develop.R;
import com.example.pic2cook_develop.guidepage.CFragment;

public class infos extends AppCompatActivity {

    private info1 Afragment;
    private info2 Bfragment;
    private info3 cfragment;

    private String TAG="Info_G";
    private int thePagenow = 1;
    private  int  isRight =1;
    // 添加滑动交互事件
    protected static final float FLIP_DISTANCE = 50; // 定义手势的最长滑动距离
    GestureDetector mDetector;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mDetector.onTouchEvent(event);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();//隐藏标题栏
        Afragment = new info1();
        Bfragment = new info2();
        cfragment = new info3();
        //向Activity初始化fragments
        getSupportFragmentManager().beginTransaction().add(R.id.fl02,Afragment).commitAllowingStateLoss();

        mDetector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {

            }
             // this is the flip
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                if (e1.getX() - e2.getX() > FLIP_DISTANCE) {

                    if (thePagenow>=1&&thePagenow<3){thePagenow ++;}

                    isRight = 1;
                    Log.d(TAG,String.valueOf(thePagenow));
                    changeGuide_Info(thePagenow-1,isRight);

                    return true;
                }
                if (e2.getX() - e1.getX() > FLIP_DISTANCE) {

                    if (thePagenow>1&&thePagenow<=3){
                        thePagenow --; }
                    isRight =0;
                    Log.d(TAG,String.valueOf(thePagenow));
                    changeGuide_Info(thePagenow+1,isRight);

                    return true;
                }
                if (e1.getY() - e2.getY() > FLIP_DISTANCE) {

                    return true;
                }
                if (e2.getY() - e1.getY() > FLIP_DISTANCE) {

                    return true;
                }
                return false;
            }
        });
    }
    // use this function to change the guidepage
    public void changeGuide_Info(int page,int direction){
        FragmentManager fm1 = getSupportFragmentManager();
        FragmentTransaction transaction = fm1.beginTransaction();
        if (page==1&&direction==1){
            transaction.setCustomAnimations(R.anim.slide_right_in,R.anim.slide_left_out);
            transaction.replace(R.id.fl02,Bfragment);
            Log.d(TAG,"Hello");
            transaction.addToBackStack(null);
            transaction.commitAllowingStateLoss();

        }
        if(page==2&&direction==1){
            transaction.setCustomAnimations(R.anim.slide_right_in,R.anim.slide_left_out);
            transaction.replace(R.id.fl02,cfragment);
            transaction.addToBackStack(null);
            transaction.commitAllowingStateLoss();

        }
        if(page==3&&direction==0){
            transaction.setCustomAnimations(R.anim.slide_left_in,R.anim.slide_right_out);
            transaction.replace(R.id.fl02,Bfragment);
            transaction.addToBackStack(null);
            transaction.commitAllowingStateLoss();

        }
        if(page==2&&direction==0){
            transaction.setCustomAnimations(R.anim.slide_left_in,R.anim.slide_right_out);
            transaction.replace(R.id.fl02,Afragment);
            transaction.addToBackStack(null);
            transaction.commitAllowingStateLoss();

        }



    }
}
