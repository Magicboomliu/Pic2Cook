package about;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.pic2cook_develop.Costum_ViewPager;
import com.example.pic2cook_develop.R;

import java.util.ArrayList;
import java.util.List;

public class whole_container_about extends Fragment  {

    public Costum_ViewPager vp1;
    private TabFragmentPagerAdapter mAdapter;
    private ArrayList<View> aList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        vp1 = view.findViewById(R.id.vp_about);
        vp1.setScanScroll(false);
        ArrayList aList = new ArrayList<>();
        aList.add(new about_fra1());
        aList.add(new  about_fra2());
        mAdapter = new TabFragmentPagerAdapter(getChildFragmentManager(), aList);
        vp1.setAdapter(mAdapter);
        vp1.setCurrentItem(0);


//        back_about1.findViewById(R.id.backs_to_about1);
//        see_aurther.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentManager fm1 = getChildFragmentManager();
//                FragmentTransaction transaction = fm1.beginTransaction();
//                transaction.setCustomAnimations(R.anim.slide_right_in,R.anim.slide_left_out);
//                transaction.replace(R.id.about_freg,ab2);
//
//                transaction.commitAllowingStateLoss();
//            }
//        });
//        back_about1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentManager fm1 = getChildFragmentManager();
//                FragmentTransaction transaction = fm1.beginTransaction();
//                transaction.setCustomAnimations(R.anim.slide_right_out,R.anim.slide_left_in);
//                transaction.replace(R.id.about_freg,ab1);
//
//                transaction.commitAllowingStateLoss();
//            }
//        });

    }
    public class TabFragmentPagerAdapter extends FragmentPagerAdapter {
        private FragmentManager mfragmentManager;
        private List<Fragment> mlist;


        public TabFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
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
