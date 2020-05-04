package my;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pic2cook_develop.R;


public class me1 extends Fragment {
   private ImageView set_user_btn_arrow;
   private TextView set_datas_user;
   private ImageView settings;
   private ImageView weekly;
   private ImageView checklist;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.me1,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
         super.onViewCreated(view, savedInstanceState);
          set_user_btn_arrow =view.findViewById(R.id.set_the_user_data_arrow);
          set_datas_user = view.findViewById(R.id.Set_datas_user);
          settings = view.findViewById(R.id.settings);
          weekly =view.findViewById(R.id.weekly);
          checklist = view.findViewById(R.id.cheklist_iconss);
          //
         checklist.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 whole_container_my wm=(whole_container_my) getActivity().getSupportFragmentManager().findFragmentById(R.id.FL_C);
                 wm.me_vp.setCurrentItem(4);
             }
         });

          set_user_btn_arrow.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                 whole_container_my wm=(whole_container_my) getActivity().getSupportFragmentManager().findFragmentById(R.id.FL_C);
                  wm.me_vp.setCurrentItem(2);
              }
          });
          set_datas_user.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  whole_container_my wm=(whole_container_my) getActivity().getSupportFragmentManager().findFragmentById(R.id.FL_C);
                  wm.me_vp.setCurrentItem(2);
              }
          });
          settings.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  whole_container_my wm=(whole_container_my) getActivity().getSupportFragmentManager().findFragmentById(R.id.FL_C);
                  wm.me_vp.setCurrentItem(1);
              }
          });
          weekly.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  whole_container_my wm=(whole_container_my) getActivity().getSupportFragmentManager().findFragmentById(R.id.FL_C);
                  wm.me_vp.setCurrentItem(3);
              }
          });


    }
}
