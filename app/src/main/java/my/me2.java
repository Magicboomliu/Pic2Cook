package my;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pic2cook_develop.R;

public class me2 extends Fragment {
   private ImageView back_settings;
   private TextView tuichu;
   private ImageView top_pp2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.me2,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        back_settings =view.findViewById(R.id.back_settings);
        tuichu = view.findViewById(R.id.Tuichu);
        top_pp2 = view.findViewById(R.id.to_pp2);
        back_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whole_container_my wm=(whole_container_my) getActivity().getSupportFragmentManager().findFragmentById(R.id.FL_C);
                wm.me_vp.setCurrentItem(0);
            }
        });
        tuichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Quit",Toast.LENGTH_SHORT).show();
            }
        });
        top_pp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whole_container_my wm=(whole_container_my) getActivity().getSupportFragmentManager().findFragmentById(R.id.FL_C);
                wm.me_vp.setCurrentItem(2);
            }
        });
    }
}
