package com.example.pic2cook_develop.infoga;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pic2cook_develop.MainActivity;
import com.example.pic2cook_develop.R;
import com.example.pic2cook_develop.RoundImageView;

public class info1 extends Fragment {

    private RoundImageView student_image;
    private RoundImageView employee_image;
    private View student_selected;
    private View employee_selected;
    private View student_blanked;
    private View employee_blanked;
    private TextView student;
    private TextView employee;
    private TextView skip_info1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.info_gathering_fragment01,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        student_image = view.findViewById(R.id.student_image);
        employee_image =view.findViewById(R.id.emplyee_image);
        student_selected =view.findViewById(R.id.student_selected);
        employee_selected = view.findViewById(R.id.emplyee_selected);
        student_blanked = view.findViewById(R.id.st_white);
        employee_blanked =view.findViewById(R.id.em_white);
        student = view.findViewById(R.id.I_am_a_student);
        employee = view.findViewById(R.id.I_am_a_employee);
        skip_info1 = view.findViewById(R.id.skip_info_1);
        skip_info1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getContext(), MainActivity.class);
                startActivity(it);
            }
        });

        // Set visiable
        student_selected.setVisibility(View.INVISIBLE);
        employee_selected.setVisibility(View.INVISIBLE);
        // set the click listener
        student_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              setVisable(0);
            }
        });
        employee_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              setVisable(1);
            }
        });
        student_blanked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setVisable(0);
            }
        });
        employee_blanked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setVisable(1);
            }
        });
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setVisable(0);
            }
        });
        employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setVisable(1);
            }
        });
    }
    public void setVisable(int i){
        if (i==0){
            student_selected.setVisibility(View.VISIBLE);
            employee_selected.setVisibility(View.INVISIBLE);
        }
        if(i==1){
            employee_selected.setVisibility(View.VISIBLE);
            student_selected.setVisibility(View.INVISIBLE);

        }
    }
}
