package my;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.pic2cook_develop.R;
import com.mob.MobSDK;

import java.util.ArrayList;

import cn.sharesdk.onekeyshare.OnekeyShare;

public class me4 extends Fragment {
    private ImageView backweek;
    private ViewPager interaction_vp;
    private  ViewPager statics_vp;

    private ArrayList<View> aList;
    private ArrayList<View> bList;
    private MyPagerAdapter_me4 mAdapter;
    private MyPagerAdapter_me4 mAdapter2;
    private TextView  liulans;
    private  TextView paizhao_s;
    private  TextView shoucang_s;
    private  TextView reliang;
    private  TextView yinshi;
    private Button share_my_weekly;



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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.me4,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        backweek= view.findViewById(R.id.backweekly);
        interaction_vp = view.findViewById(R.id.interaction_vp);
        statics_vp = view.findViewById(R.id.statics_vp);
        liulans =view.findViewById(R.id.liulan_s);
        paizhao_s = view.findViewById(R.id.paizhao_S);
        shoucang_s = view.findViewById(R.id.shoucang_s);
        reliang = view.findViewById(R.id.ressss);
        yinshi = view.findViewById(R.id.yinshiresss);
        share_my_weekly =view.findViewById(R.id.zhoubao_share);


        reliang.setTextColor(Color.parseColor("#FFFFFF"));

        bList = new ArrayList<View>();
        LayoutInflater li2 = getLayoutInflater();
        bList.add(li2.inflate(R.layout.reliangtu,null,false));
        bList.add(li2.inflate(R.layout.reshijiegoutu,null,false));
        mAdapter2 = new MyPagerAdapter_me4(bList);
        statics_vp.setAdapter(mAdapter2);
        statics_vp.setCurrentItem(0);
        statics_vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position==0){

                    reliang.setTextColor(Color.parseColor("#FFFFFF"));
                    yinshi.setTextColor(Color.parseColor("#666666"));

                }
                if(position==1){
                    reliang.setTextColor(Color.parseColor("#666666"));
                    yinshi.setTextColor(Color.parseColor("#FFFFFF"));

                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {

                if (state == ViewPager.SCROLL_STATE_DRAGGING) {
                    //正在滑动   pager处于正在拖拽中

                } else if (state == ViewPager.SCROLL_STATE_SETTLING) {
                    //pager正在自动沉降，相当于松手后，pager恢复到一个完整pager的过程

                } else if (state == ViewPager.SCROLL_STATE_IDLE) {

                }


            }
        });

            reliang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    statics_vp.setCurrentItem(0);
                }
            });
            yinshi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    statics_vp.setCurrentItem(1);
                }
            });


           share_my_weekly.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                showShare();
               }
           });


        aList = new ArrayList<View>();
        LayoutInflater li = getLayoutInflater();
        aList.add(li.inflate(R.layout.liulan,null,false));
        aList.add(li.inflate(R.layout.paizhaoshibie,null,false));
        aList.add(li.inflate(R.layout.shoucangtu,null,false));
        mAdapter = new MyPagerAdapter_me4(aList);
        interaction_vp.setAdapter(mAdapter);
        interaction_vp.setCurrentItem(0);
        liulans.setTextColor(Color.parseColor("#FFFFFF"));
        interaction_vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position==0){

                    liulans.setTextColor(Color.parseColor("#FFFFFF"));
                    paizhao_s.setTextColor(Color.parseColor("#666666"));
                    shoucang_s.setTextColor(Color.parseColor("#666666"));
                 }
                if(position==1){
                    liulans.setTextColor(Color.parseColor("#666666"));
                    paizhao_s.setTextColor(Color.parseColor("#FFFFFF"));
                    shoucang_s.setTextColor(Color.parseColor("#666666"));

                }
                if(position==2){

                    liulans.setTextColor(Color.parseColor("#666666"));
                    paizhao_s.setTextColor(Color.parseColor("#666666"));
                    shoucang_s.setTextColor(Color.parseColor("#FFFFFF"));

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

                if (state == ViewPager.SCROLL_STATE_DRAGGING) {
                    //正在滑动   pager处于正在拖拽中

                } else if (state == ViewPager.SCROLL_STATE_SETTLING) {
                    //pager正在自动沉降，相当于松手后，pager恢复到一个完整pager的过程

                } else if (state == ViewPager.SCROLL_STATE_IDLE) {

                }


            }
        });





        backweek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whole_container_my wm=(whole_container_my) getActivity().getSupportFragmentManager().findFragmentById(R.id.FL_C);
                wm.me_vp.setCurrentItem(0);
            }
        });

        liulans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interaction_vp.setCurrentItem(0);
            }
        });
        paizhao_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interaction_vp.setCurrentItem(1);
            }
        });
        shoucang_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interaction_vp.setCurrentItem(2);
            }
        });
    }



    public class MyPagerAdapter_me4 extends PagerAdapter {
        private ArrayList<View> viewLists;

        public MyPagerAdapter_me4() {
        }

        public MyPagerAdapter_me4(ArrayList<View> viewLists) {
            super();
            this.viewLists = viewLists;
        }

        @Override
        public int getCount() {
            return viewLists.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewLists.get(position));
            return viewLists.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewLists.get(position));
        }
    }




}
