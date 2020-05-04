package my;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pic2cook_develop.R;

public class me5 extends Fragment {
    private ImageView back;
    private  ImageView tose;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.me5,container,false);
        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        back =view.findViewById(R.id.previous_me5);
        tose =view.findViewById(R.id.see_detailed_checklist);
//
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whole_container_my wm=(whole_container_my) getActivity().getSupportFragmentManager().findFragmentById(R.id.FL_C);
                wm.me_vp.setCurrentItem(0);
            }
        });
        tose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whole_container_my wm=(whole_container_my) getActivity().getSupportFragmentManager().findFragmentById(R.id.FL_C);
                wm.me_vp.setCurrentItem(5);
            }
        });
    }
}
