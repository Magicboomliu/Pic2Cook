package about;

import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.example.pic2cook_develop.R;

public class about_fra1 extends Fragment {
    private ImageView see_the_aurthor;
    //定义一个接口
    public  interface  Change{

        public void gotoFragment(ViewPager viewPager);

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about1,container,false);
        return view;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        see_the_aurthor = view.findViewById(R.id.see_the_author);

        see_the_aurthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                whole_container_about wb = (whole_container_about) getActivity().getSupportFragmentManager().findFragmentById(R.id.FL_C);
                wb.vp1.setCurrentItem(1);
            }
        });


    }
}
