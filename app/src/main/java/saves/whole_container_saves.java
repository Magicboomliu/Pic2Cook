package saves;

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

import com.example.pic2cook_develop.Costum_ViewPager;
import com.example.pic2cook_develop.R;

import java.util.ArrayList;
import java.util.List;

import about.whole_container_about;

public class whole_container_saves extends Fragment {
    private View my_dishes_selected;
    private View my_ingredient_selected;
    private Costum_ViewPager vp2;
    private TabFragmentPagerAdapter1 mAdapter;
    private saved_dishes sd1;
    private saved_ingredients si1;
    private TextView mydish;
    private TextView myindreg;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.saves_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        my_dishes_selected = view.findViewById(R.id.mydish_selected);
        my_ingredient_selected = view.findViewById(R.id.myingredient_selected);
        my_dishes_selected.setVisibility(View.VISIBLE);
        my_ingredient_selected.setVisibility(View.INVISIBLE);
        mydish =view.findViewById(R.id.mydish);
        mydish.setTextColor(Color.parseColor("#FFFFFF"));
        myindreg = view.findViewById(R.id.myingredient);
        vp2 =view.findViewById(R.id.saves_vp);
        ArrayList aList = new ArrayList<>();
        aList.add(new saved_dishes());
        aList.add(new saved_ingredients());
        mAdapter = new TabFragmentPagerAdapter1(getChildFragmentManager(),aList);
        vp2.setAdapter(mAdapter);
        vp2.setScanScroll(true);
        vp2.setCurrentItem(0);

        my_dishes_selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vp2.setCurrentItem(0);
                mydish.setTextColor(Color.parseColor("#FFFFFF"));
                myindreg.setTextColor(Color.parseColor("#CCCCCC"));
            }
        });
        my_ingredient_selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vp2.setCurrentItem(1);
                myindreg.setTextColor(Color.parseColor("#FFFFFF"));
                mydish.setTextColor(Color.parseColor("#CCCCCC"));
            }
        });

        vp2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
             if (position==0){

                 my_dishes_selected.setVisibility(View.VISIBLE);
                 my_ingredient_selected.setVisibility(View.INVISIBLE);
                 mydish.setTextColor(Color.parseColor("#FFFFFF"));
                 myindreg.setTextColor(Color.parseColor("#CCCCCC"));
             }
             if(position==1){

                 my_dishes_selected.setVisibility(View.INVISIBLE);
                 my_ingredient_selected.setVisibility(View.VISIBLE);
                 myindreg.setTextColor(Color.parseColor("#FFFFFF"));
                 mydish.setTextColor(Color.parseColor("#CCCCCC"));
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




    }


// FragmentPagerAdapter
    public class TabFragmentPagerAdapter1 extends FragmentPagerAdapter {
        private FragmentManager mfragmentManager;
        private List<Fragment> mlist;


        public TabFragmentPagerAdapter1(FragmentManager fm, List<Fragment> list) {
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

