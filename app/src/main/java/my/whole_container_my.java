package my;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.pic2cook_develop.Costum_ViewPager;
import com.example.pic2cook_develop.R;

import java.util.ArrayList;
import java.util.List;

import about.whole_container_about;

public class whole_container_my extends Fragment {
    public Costum_ViewPager me_vp;
    private  me1 m1;
    private  me2 m2;
    private me3 m3;
    private  me4 m4;
    private  me5 m5;
    private  me6 m6;
    private TabFragmentPagerAdapter_me mAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.my_fragment,container,false);
        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        me_vp =view.findViewById(R.id.vp_me);
        me_vp.setScanScroll(false);
        ArrayList aList = new ArrayList<>();
        aList.add(new me1());
        aList.add(new me2());
        aList.add(new me3());
        aList.add(new me4());
        aList.add(new me5());
        aList.add(new me6());

        mAdapter = new TabFragmentPagerAdapter_me(getChildFragmentManager(), aList);
        me_vp.setAdapter(mAdapter);
        me_vp.setCurrentItem(0);




//        AssetManager assetManager= getActivity().getAssets();
//        Typeface typeFace = Typeface.createFromAsset(assetManager,"AxureHandwriting.otf");


    }
    public class TabFragmentPagerAdapter_me extends FragmentPagerAdapter {
        private FragmentManager mfragmentManager;
        private List<Fragment> mlist;


        public TabFragmentPagerAdapter_me(FragmentManager fm, List<Fragment> list) {
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
