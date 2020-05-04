package cooks;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.pic2cook_develop.Costum_ViewPager;
import com.example.pic2cook_develop.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import my.whole_container_my;
import saves.whole_container_saves;

public class paizhaofra extends Fragment {

private TextView to_intro;
private Button use_pic2Cook;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.paizhao_regrement,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        to_intro = view.findViewById(R.id.paizhao_rules_introducations);
        use_pic2Cook = view.findViewById(R.id.start_pic2ook);

        to_intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whole_container wm=(whole_container) getActivity().getSupportFragmentManager().findFragmentById(R.id.FL_C);
                wm.vp_cook.setCurrentItem(5);
            }
        });
        use_pic2Cook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
                View view2 = LayoutInflater.from(getActivity()).inflate(R.layout.alert_dialog_used_camera, null);
                TextView camera_cancel = view2.findViewById(R.id.camera_cancel);
                TextView camera_ok = view2.findViewById(R.id.camera_ok);
                builder1.setView(view2);
                final AlertDialog dia = builder1.show();
                camera_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dia.dismiss();
                    }
                });
                camera_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent it2 = new Intent(getContext(),paizhao_activity.class);
                        startActivity(it2);
                    }
                });
            }
        });




    }





}
