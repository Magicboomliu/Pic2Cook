package about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pic2cook_develop.R;

public class about_fra2 extends Fragment {
 private ImageView previous;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about2,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        previous = view.findViewById(R.id.backs_to_about1);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                whole_container_about wb = (whole_container_about) getActivity().getSupportFragmentManager().findFragmentById(R.id.FL_C);
                wb.vp1.setCurrentItem(0);
            }
        });
    }
}
