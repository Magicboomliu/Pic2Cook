package cooks;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.pic2cook_develop.Costum_ViewPager;
import com.example.pic2cook_develop.MainActivity;
import com.example.pic2cook_develop.R;

import java.util.ArrayList;
import java.util.List;

import my.whole_container_my;

public class whole_container extends Fragment {
    private  int i=0;
    private Button dialy_remcommed;
    private Button photo_reco;
    private Button ranking_list;
    private Button attention;
    private Button share;
    private ImageView Camera_icon;
    private ImageView search_icon;
    private ImageView uploader;
    public EditText search_contens;
    public Costum_ViewPager vp_cook;
    private TabFragmentPagerAdapter_c mAdapter;
    private PopupWindow search_tips;
    private View Search_Blank;
    private ImageView please_show_the_cares;

    private String Search_Text;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cook_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        vp_cook =view.findViewById(R.id.cooking_fenlei);
        vp_cook.setScanScroll(false);
        ArrayList aList = new ArrayList<>();
        aList.add(new recommend_Fragment());
        aList.add(new paizhaofra());
        aList.add(new paihangfrag());
        aList.add(new guanzhufra());
        aList.add(new shangchuanfrag());
        aList.add(new paozhao_rules_introduction());
        aList.add(new search_contents());
        aList.add(new Search_contentS_photoes());
        aList.add(new okok1());
        aList.add(new Recommend_Pagess());
        aList.add(new okok2());
        aList.add(new Search_Recommend_Fragment());


        mAdapter = new TabFragmentPagerAdapter_c(getChildFragmentManager(), aList);
        vp_cook.setAdapter(mAdapter);
        vp_cook.setCurrentItem(0);

        //
        Intent ints = getActivity().getIntent();
        String datas = ints.getStringExtra("extra_data");

        if(datas!=null){
            Toast.makeText(getContext(),datas,Toast.LENGTH_SHORT).show();
            vp_cook.setCurrentItem(9);

        }








        vp_cook.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position==0){

                    dialy_remcommed.setBackground(getResources().getDrawable(R.drawable.round_gray_light_select));
                    dialy_remcommed.setTextColor(Color.parseColor("#262626"));
                    photo_reco.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                    photo_reco.setTextColor(Color.parseColor("#FFFFFF"));
                    ranking_list.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                    ranking_list.setTextColor(Color.parseColor("#FFFFFF"));
                    attention.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                    attention.setTextColor(Color.parseColor("#FFFFFF"));
                    share.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                    share.setTextColor(Color.parseColor("#FFFFFF"));

                }
                if(position==1){
                    dialy_remcommed.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                    dialy_remcommed.setTextColor(Color.parseColor("#FFFFFF"));
                    photo_reco.setBackground(getResources().getDrawable(R.drawable.round_gray_light_select));
                    photo_reco.setTextColor(Color.parseColor("#262626"));
                    ranking_list.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                    ranking_list.setTextColor(Color.parseColor("#FFFFFF"));
                    attention.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                    attention.setTextColor(Color.parseColor("#FFFFFF"));
                    share.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                    share.setTextColor(Color.parseColor("#FFFFFF"));

                }
                if(position==2){

                    dialy_remcommed.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                    dialy_remcommed.setTextColor(Color.parseColor("#FFFFFF"));
                    photo_reco.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                    photo_reco.setTextColor(Color.parseColor("#FFFFFF"));
                    ranking_list.setBackground(getResources().getDrawable(R.drawable.round_gray_light_select));
                    ranking_list.setTextColor(Color.parseColor("#262626"));
                    attention.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                    attention.setTextColor(Color.parseColor("#FFFFFF"));
                    share.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                    share.setTextColor(Color.parseColor("#FFFFFF"));

                }
                if(position==3){ dialy_remcommed.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                    dialy_remcommed.setTextColor(Color.parseColor("#FFFFFF"));
                    photo_reco.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                    photo_reco.setTextColor(Color.parseColor("#FFFFFF"));
                    ranking_list.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                    ranking_list.setTextColor(Color.parseColor("#FFFFFF"));
                    attention.setBackground(getResources().getDrawable(R.drawable.round_gray_light_select));
                    attention.setTextColor(Color.parseColor("#262626"));
                    share.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                    share.setTextColor(Color.parseColor("#FFFFFF"));
                }
                if(position==4){

                    dialy_remcommed.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                    dialy_remcommed.setTextColor(Color.parseColor("#FFFFFF"));
                    photo_reco.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                    photo_reco.setTextColor(Color.parseColor("#FFFFFF"));
                    ranking_list.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                    dialy_remcommed.setTextColor(Color.parseColor("#FFFFFF"));
                    attention.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                    attention.setTextColor(Color.parseColor("#FFFFFF"));
                    share.setBackground(getResources().getDrawable(R.drawable.round_gray_light_select));
                    share.setTextColor(Color.parseColor("#262626"));


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












        dialy_remcommed = view.findViewById(R.id.dialy_remconned);
        photo_reco = view.findViewById(R.id.photo_reco);
        ranking_list = view.findViewById(R.id.Ranking_List);
        attention = view.findViewById(R.id.Attetntion);
        share = view.findViewById(R.id.Share);
        Camera_icon = view.findViewById(R.id.camera_icon);
        search_icon = view.findViewById(R.id.search_icon);
        uploader = view.findViewById(R.id.please_show_the_cares);
        search_contens = view.findViewById(R.id.search_words);
        search_contens.setFocusable(false);
        search_contens.setFocusableInTouchMode(false);
        search_contens.clearFocus(); //让输入框失去焦点
        Search_Blank = view.findViewById(R.id.search_blanked);




        //搜索页面
        search_contens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_contens.setFocusable(true);
                search_contens.setFocusableInTouchMode(true);
                search_contens.requestFocus(); //让输入框获取焦点

                View view_of_pop = getLayoutInflater().inflate(R.layout.popwindow_of_search,null);
                final Button suantai = view_of_pop.findViewById(R.id.suantan_chaorou_search_id);
                final Button photo = view_of_pop.findViewById(R.id.potato_id);
                final TextView qingchu = view_of_pop.findViewById(R.id.delete_search_history);
                search_tips = new PopupWindow(view_of_pop,ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//                search_tips.setBackgroundDrawable(new BitmapDrawable());
                suantai.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        search_tips.dismiss();
                        String search_items = (String) suantai.getText();
                        search_contens.setText(search_items);
                        vp_cook.setCurrentItem(6);
                    }
                });

                photo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        search_tips.dismiss();
                        String search_items = (String) photo.getText();
                        search_contens.setText(search_items);
                        vp_cook.setCurrentItem(7);

                    }
                });

                qingchu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(i==0){
                            suantai.setVisibility(View.INVISIBLE);
                            photo.setVisibility(View.INVISIBLE);
                            i=1;

                        }
                        else {

                            suantai.setVisibility(View.VISIBLE);
                            photo.setVisibility(View.VISIBLE);
                            i=0;

                        }

                    }
                });
                search_tips.setOutsideTouchable(true);
                search_tips.setFocusable(true);
                search_tips.showAsDropDown(Search_Blank);
                InputMethodManager imm = (InputMethodManager) search_contens.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(0, InputMethodManager.SHOW_FORCED);

                search_contens.setFocusable(true);
                search_contens.setFocusableInTouchMode(true);
                search_contens.requestFocus(); //让输入框获取焦点

            }
        });
        search_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_contens.setFocusable(false);
                search_contens.setFocusableInTouchMode(false);
                Search_Text= search_contens.getText().toString();
                search_contens.clearFocus(); //让输入框失去焦点
                InputMethodManager imm = (InputMethodManager) search_contens.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0); //强制隐藏键盘
                vp_cook.setCurrentItem(11);
//                Intent intent_search = new Intent(getContext(),MainActivity.class);
//                String finalresult ="search";
//                intent_search.putExtra("extra_data",finalresult);
//                startActivity(intent_search);

            }
        });


        //初始化
        photo_reco.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
        photo_reco.setTextColor(Color.parseColor("#FFFFFF"));
        ranking_list.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
        ranking_list.setTextColor(Color.parseColor("#FFFFFF"));
        attention.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
        attention.setTextColor(Color.parseColor("#FFFFFF"));
        share.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
        share.setTextColor(Color.parseColor("#FFFFFF"));

        //每日推荐页面
        // Click the daily_recommend
        dialy_remcommed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialy_remcommed.setBackground(getResources().getDrawable(R.drawable.round_gray_light_select));
                dialy_remcommed.setTextColor(Color.parseColor("#262626"));
                photo_reco.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                photo_reco.setTextColor(Color.parseColor("#FFFFFF"));
                ranking_list.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                ranking_list.setTextColor(Color.parseColor("#FFFFFF"));
                attention.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                attention.setTextColor(Color.parseColor("#FFFFFF"));
                share.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                share.setTextColor(Color.parseColor("#FFFFFF"));
                vp_cook.setCurrentItem(0);
            }
        });
        //拍照识别
        // Click the photo recognition
        photo_reco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialy_remcommed.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                dialy_remcommed.setTextColor(Color.parseColor("#FFFFFF"));
                photo_reco.setBackground(getResources().getDrawable(R.drawable.round_gray_light_select));
                photo_reco.setTextColor(Color.parseColor("#262626"));
                ranking_list.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                ranking_list.setTextColor(Color.parseColor("#FFFFFF"));
                attention.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                attention.setTextColor(Color.parseColor("#FFFFFF"));
                share.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                share.setTextColor(Color.parseColor("#FFFFFF"));
                vp_cook.setCurrentItem(1);
            }
        });
        //排行榜
        // click the rankingList
        ranking_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialy_remcommed.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                dialy_remcommed.setTextColor(Color.parseColor("#FFFFFF"));
                photo_reco.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                photo_reco.setTextColor(Color.parseColor("#FFFFFF"));
                ranking_list.setBackground(getResources().getDrawable(R.drawable.round_gray_light_select));
                ranking_list.setTextColor(Color.parseColor("#262626"));
                attention.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                attention.setTextColor(Color.parseColor("#FFFFFF"));
                share.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                share.setTextColor(Color.parseColor("#FFFFFF"));
                vp_cook.setCurrentItem(2);
            }
        });

        //我的关注页面
        //Click the attention
        attention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialy_remcommed.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                dialy_remcommed.setTextColor(Color.parseColor("#FFFFFF"));
                photo_reco.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                photo_reco.setTextColor(Color.parseColor("#FFFFFF"));
                ranking_list.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                ranking_list.setTextColor(Color.parseColor("#FFFFFF"));
                attention.setBackground(getResources().getDrawable(R.drawable.round_gray_light_select));
                attention.setTextColor(Color.parseColor("#262626"));
                share.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                share.setTextColor(Color.parseColor("#FFFFFF"));
                vp_cook.setCurrentItem(3);

            }
        });

        //分享页面
        // click the share
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialy_remcommed.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                dialy_remcommed.setTextColor(Color.parseColor("#FFFFFF"));
                photo_reco.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                photo_reco.setTextColor(Color.parseColor("#FFFFFF"));
                ranking_list.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                dialy_remcommed.setTextColor(Color.parseColor("#FFFFFF"));
                attention.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                attention.setTextColor(Color.parseColor("#FFFFFF"));
                share.setBackground(getResources().getDrawable(R.drawable.round_gray_light_select));
                share.setTextColor(Color.parseColor("#262626"));
                vp_cook.setCurrentItem(4);
            }
        });




        Camera_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialy_remcommed.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                dialy_remcommed.setTextColor(Color.parseColor("#FFFFFF"));
                photo_reco.setBackground(getResources().getDrawable(R.drawable.round_gray_light_select));
                photo_reco.setTextColor(Color.parseColor("#262626"));
                ranking_list.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                ranking_list.setTextColor(Color.parseColor("#FFFFFF"));
                attention.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                attention.setTextColor(Color.parseColor("#FFFFFF"));
                share.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                share.setTextColor(Color.parseColor("#FFFFFF"));
                vp_cook.setCurrentItem(1);


            }
        });
        uploader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialy_remcommed.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                dialy_remcommed.setTextColor(Color.parseColor("#FFFFFF"));
                photo_reco.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                photo_reco.setTextColor(Color.parseColor("#FFFFFF"));
                ranking_list.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                dialy_remcommed.setTextColor(Color.parseColor("#FFFFFF"));
                attention.setBackground(getResources().getDrawable(R.drawable.back_round_rect));
                attention.setTextColor(Color.parseColor("#FFFFFF"));
                share.setBackground(getResources().getDrawable(R.drawable.round_gray_light_select));
                share.setTextColor(Color.parseColor("#262626"));
                vp_cook.setCurrentItem(4);
            }
        });

    }

    public class TabFragmentPagerAdapter_c extends FragmentPagerAdapter {
        private FragmentManager mfragmentManager;
        private List<Fragment> mlist;


        public TabFragmentPagerAdapter_c(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.mlist = list;
        }

        @Override
        public void setPrimaryItem(ViewGroup container, int position, Object object) {
            super.setPrimaryItem(container, position, object);
        }

        @Override
        public Fragment getItem(int arg0) {
            return mlist.get(arg0);//显示第几个页面
        }

        @Override
        public int getCount() {
            return mlist.size();//有几个页面
        }
    }

}
