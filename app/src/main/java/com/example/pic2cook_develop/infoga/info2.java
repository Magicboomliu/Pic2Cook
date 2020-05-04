package com.example.pic2cook_develop.infoga;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pic2cook_develop.MainActivity;
import com.example.pic2cook_develop.R;

import org.w3c.dom.Text;

public class info2 extends Fragment {
    private View master_selected;
    private View super_selected;
    private View normal_selected;
    private View broken_selected;
    private ImageView master_image;
    private ImageView super_image;
    private ImageView normal_image;
    private ImageView broken_image;
    private TextView master_anno;
    private TextView super_anno;
    private TextView normal_anno;
    private TextView broken_anno;
    private TextView skip_info2;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.info_gathering_fragment02,container,false);
       return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // get the instance
        master_image= view.findViewById(R.id.master_ball);
        super_image = view.findViewById(R.id.superball);
        normal_image =view.findViewById(R.id.normal_ball);
        broken_image = view.findViewById(R.id.brokem_ball);
        master_selected= view.findViewById(R.id.master_selected);
        super_selected = view.findViewById(R.id.super_selected);
        normal_selected = view.findViewById(R.id.normal_selected);
        broken_selected = view.findViewById(R.id.weak_selected);
        master_anno =view.findViewById(R.id.full_confi);
        super_anno = view.findViewById(R.id.good_confi);
        normal_anno = view.findViewById(R.id.normal_confi);
        broken_anno = view.findViewById(R.id.weak_confi);
        skip_info2 = view.findViewById(R.id.skip_info_2);
        // Set the init visibility
        skip_info2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getContext(), MainActivity.class);
                startActivity(it);
            }
        });

        master_selected.setVisibility(View.INVISIBLE);
        super_selected.setVisibility(View.INVISIBLE);
        normal_selected.setVisibility(View.INVISIBLE);
        broken_selected.setVisibility(View.INVISIBLE);

        // Set onclick listener
        master_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 master_selected.setVisibility(View.VISIBLE);
                 super_selected.setVisibility(View.INVISIBLE);
                 normal_selected.setVisibility(View.INVISIBLE);
                 broken_selected.setVisibility(View.INVISIBLE);
            }
        });

        master_anno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                master_selected.setVisibility(View.VISIBLE);
                super_selected.setVisibility(View.INVISIBLE);
                normal_selected.setVisibility(View.INVISIBLE);
                broken_selected.setVisibility(View.INVISIBLE);
            }
        });

        super_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                master_selected.setVisibility(View.INVISIBLE);
                super_selected.setVisibility(View.VISIBLE);
                normal_selected.setVisibility(View.INVISIBLE);
                broken_selected.setVisibility(View.INVISIBLE);

            }
        });
        super_anno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                master_selected.setVisibility(View.INVISIBLE);
                super_selected.setVisibility(View.VISIBLE);
                normal_selected.setVisibility(View.INVISIBLE);
                broken_selected.setVisibility(View.INVISIBLE);

            }
        });
        normal_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                master_selected.setVisibility(View.INVISIBLE);
                super_selected.setVisibility(View.INVISIBLE);
                normal_selected.setVisibility(View.VISIBLE);
                broken_selected.setVisibility(View.INVISIBLE);
            }
        });
        normal_anno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                master_selected.setVisibility(View.INVISIBLE);
                super_selected.setVisibility(View.INVISIBLE);
                normal_selected.setVisibility(View.VISIBLE);
                broken_selected.setVisibility(View.INVISIBLE);
            }
        });
        broken_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                master_selected.setVisibility(View.INVISIBLE);
                super_selected.setVisibility(View.INVISIBLE);
                normal_selected.setVisibility(View.INVISIBLE);
                broken_selected.setVisibility(View.VISIBLE);

            }
        });
        broken_anno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                master_selected.setVisibility(View.INVISIBLE);
                super_selected.setVisibility(View.INVISIBLE);
                normal_selected.setVisibility(View.INVISIBLE);
                broken_selected.setVisibility(View.VISIBLE);
            }
        });

    }


}
