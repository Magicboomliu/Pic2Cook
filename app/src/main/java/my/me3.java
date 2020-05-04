package my;

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

public class me3 extends Fragment {
   private TextView saved_changde_data;
   private ImageView back_s;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.me3,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        saved_changde_data =view.findViewById(R.id.saved_setting_datas);
        back_s =view.findViewById(R.id.back_setdit_sel);
        back_s  .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whole_container_my wm=(whole_container_my) getActivity().getSupportFragmentManager().findFragmentById(R.id.FL_C);
                wm.me_vp.setCurrentItem(0);
            }
        });
        saved_changde_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Your selfdata has been saved",Toast.LENGTH_LONG).show();
            }
        });
    }

}
