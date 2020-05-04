package com.example.pic2cook_develop.guidepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pic2cook_develop.MainActivity;
import com.example.pic2cook_develop.R;
import com.example.pic2cook_develop.login.Wechat_login;

public class CFragment extends Fragment {


    //首先可以定义一些widgets
    private ImageView ImageView_frag1;
    private Button to_wechat;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.guiding_page03_fragment,container,false);
        return view;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView_frag1 = view.findViewById(R.id.guiding_page03);
        to_wechat=view.findViewById(R.id.from_guide_to_login_btn);

        to_wechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1 =new Intent(getContext(), Wechat_login.class);
                startActivity(it1);
            }
        });
    }







}
