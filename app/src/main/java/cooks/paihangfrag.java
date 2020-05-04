package cooks;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.pic2cook_develop.R;

import java.util.ArrayList;
import java.util.List;

public class paihangfrag extends Fragment {

    private ViewPager viewPager1;
    private pengyoubang p1;
    private redubang rq;
    private xinxiubang xx;
    private TabFragmentPagerAdapter_p mAdapter;
    private TextView p;
    private TextView r;
    private TextView x;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.paihangbang_fragemnt,container,false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager1 = view.findViewById(R.id.vP_rank);
        p = view.findViewById(R.id.pppp);
        r= view.findViewById(R.id.rrrrr);
        x = view.findViewById(R.id.xxxxxx);

        ArrayList aList = new ArrayList<>();
        aList.add(new pengyoubang());
        aList.add(new redubang());
        aList.add(new xinxiubang());
        mAdapter = new TabFragmentPagerAdapter_p(getChildFragmentManager(), aList);
        viewPager1.setAdapter(mAdapter);
        viewPager1.setCurrentItem(0);

        viewPager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position==0){
                   p.setTextColor(Color.parseColor("#FFFFFF"));
                   r.setTextColor(Color.parseColor("#666666"));
                   x.setTextColor(Color.parseColor("#666666"));


                }
                if(position==1){
                    p.setTextColor(Color.parseColor("#666666"));
                    r.setTextColor(Color.parseColor("#FFFFFF"));
                    x.setTextColor(Color.parseColor("#666666"));

                }
                if(position==2){
                    p.setTextColor(Color.parseColor("#666666"));
                    r.setTextColor(Color.parseColor("#666666"));
                    x.setTextColor(Color.parseColor("#FFFFFF"));

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
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.setTextColor(Color.parseColor("#666666"));
                r.setTextColor(Color.parseColor("#666666"));
                x.setTextColor(Color.parseColor("#FFFFFF"));
                viewPager1.setCurrentItem(2);

            }
        });
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.setTextColor(Color.parseColor("#666666"));
                r.setTextColor(Color.parseColor("#FFFFFF"));
                x.setTextColor(Color.parseColor("#666666"));
                viewPager1.setCurrentItem(1);
            }
        });
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.setTextColor(Color.parseColor("#FFFFFF"));
                r.setTextColor(Color.parseColor("#666666"));
                x.setTextColor(Color.parseColor("#666666"));
                viewPager1.setCurrentItem(0);
            }
        });














    }



    public class TabFragmentPagerAdapter_p extends FragmentPagerAdapter {
        private FragmentManager mfragmentManager;
        private List<Fragment> mlist;


        public TabFragmentPagerAdapter_p(FragmentManager fm, List<Fragment> list) {
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


