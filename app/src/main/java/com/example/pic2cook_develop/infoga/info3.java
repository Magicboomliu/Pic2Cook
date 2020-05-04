package com.example.pic2cook_develop.infoga;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pic2cook_develop.MainActivity;
import com.example.pic2cook_develop.R;

import java.sql.BatchUpdateException;

public class info3 extends Fragment {
    private Button init_finshed;
    private View low_cate_selected;
    private View familyhold_selected;
    private View rich_selected;
    private View instant_selected;
    private ImageView low_cate_image;
    private ImageView familyhold_image;
    private  ImageView rich_image;
    private ImageView instant_image;
    private TextView skip_info3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.info_gathering_fragment03,container,false);
        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // init the instance
        init_finshed =view.findViewById(R.id.gather_info_finished);
        low_cate_selected= view.findViewById(R.id.low_cate_selected);
        low_cate_image = view.findViewById(R.id.low_cate_image);
        familyhold_selected = view.findViewById(R.id.family_hold);
        familyhold_image = view.findViewById(R.id.family_hold_image);
        rich_selected = view.findViewById(R.id.rich_dish);
        rich_image = view.findViewById(R.id.rich_dish_image);
        instant_selected = view.findViewById(R.id.instant);
        instant_image = view.findViewById(R.id.instant_dish);
        skip_info3 = view.findViewById(R.id.skip_info_3);


        skip_info3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getContext(),MainActivity.class);
                startActivity(it);
            }
        });


        // set the visibility
        low_cate_selected.setVisibility(View.INVISIBLE);
        familyhold_selected.setVisibility(View.INVISIBLE);
        rich_selected.setVisibility(View.INVISIBLE);
        instant_selected.setVisibility(View.INVISIBLE);
        init_finshed.setVisibility(View.INVISIBLE);

        // Set onClicklister

        low_cate_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                low_cate_selected.setVisibility(View.VISIBLE);
                familyhold_selected.setVisibility(View.INVISIBLE);
                rich_selected.setVisibility(View.INVISIBLE);
                instant_selected.setVisibility(View.INVISIBLE);
                init_finshed.setVisibility(View.VISIBLE);
            }
        });
        familyhold_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                low_cate_selected.setVisibility(View.INVISIBLE);
                familyhold_selected.setVisibility(View.VISIBLE);
                rich_selected.setVisibility(View.INVISIBLE);
                instant_selected.setVisibility(View.INVISIBLE);
                init_finshed.setVisibility(View.VISIBLE);
            }
        });
        rich_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                low_cate_selected.setVisibility(View.INVISIBLE);
                familyhold_selected.setVisibility(View.INVISIBLE);
                rich_selected.setVisibility(View.VISIBLE);
                instant_selected.setVisibility(View.INVISIBLE);
                init_finshed.setVisibility(View.VISIBLE);

            }
        });
        instant_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                low_cate_selected.setVisibility(View.INVISIBLE);
                familyhold_selected.setVisibility(View.INVISIBLE);
                rich_selected.setVisibility(View.INVISIBLE);
                instant_selected.setVisibility(View.VISIBLE);
                init_finshed.setVisibility(View.VISIBLE);
            }
        });
        init_finshed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(getContext(), MainActivity.class);
                startActivity(it);
            }
        });
    }
}
