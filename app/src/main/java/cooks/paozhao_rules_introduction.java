package cooks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pic2cook_develop.R;

public class paozhao_rules_introduction extends Fragment {

    private ImageView returns;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.paizhao_rules_introduction,container,false);
       return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        returns = view.findViewById(R.id.jiaocheng_back);
        returns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whole_container wm=(whole_container) getActivity().getSupportFragmentManager().findFragmentById(R.id.FL_C);
                wm.vp_cook.setCurrentItem(1);
            }
        });
    }
}
