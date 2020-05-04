package cooks;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.pic2cook_develop.R;

import java.util.ArrayList;
import java.util.List;

import about.whole_container_about;

public class guanzhufra extends Fragment {
    private ViewPager vp_cares;
    private TabFragmentPagerAdapter_cares mAdapter;
    private ArrayList<View> aList;
    private TextView follow;
    private TextView haoyou;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.guanzhu_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        vp_cares = view.findViewById(R.id.vp_cares);
        ArrayList aList = new ArrayList<>();
        aList.add(new follow_dongtai());
        aList.add(new haoyou_dongtai());
        mAdapter = new TabFragmentPagerAdapter_cares(getChildFragmentManager(), aList);
        vp_cares.setAdapter(mAdapter);
        vp_cares.setCurrentItem(0);
        follow = view.findViewById(R.id.dongtai_1);
        haoyou = view.findViewById(R.id.dontai_2);

           vp_cares.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position==0){

                   follow.setTextColor(Color.parseColor("#FFFFFF"));
                   haoyou.setTextColor(Color.parseColor("#666666"));

                }
                if(position==1){
                    follow.setTextColor(Color.parseColor("#666666"));
                    haoyou.setTextColor(Color.parseColor("#FFFFFF"));

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
        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                follow.setTextColor(Color.parseColor("#FFFFFF"));
                haoyou.setTextColor(Color.parseColor("#666666"));
                vp_cares.setCurrentItem(0);
            }
        });
        haoyou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                follow.setTextColor(Color.parseColor("#666666"));
                haoyou.setTextColor(Color.parseColor("#FFFFFF"));
                vp_cares.setCurrentItem(1);

            }
        });


















    }


    public class TabFragmentPagerAdapter_cares extends FragmentPagerAdapter {
        private FragmentManager mfragmentManager;
        private List<Fragment> mlist;


        public TabFragmentPagerAdapter_cares(FragmentManager fm, List<Fragment> list) {
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
