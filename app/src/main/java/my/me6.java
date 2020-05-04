package my;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pic2cook_develop.R;

public class me6 extends Fragment {
    private ImageView back;
    private ImageView xihong;
    private ImageView baiyang;
    private ImageView jidan;
    private ImageView yan;
    private ImageView jijing;
    private ImageView haoyou;
    private ImageView xiaoliu;
    private  ImageView big_checked;
    private TextView finshed;

    private LinearLayout xihong_ly;
    private LinearLayout baitang_ly;
    private LinearLayout jidan_ly;
    private LinearLayout yan_ly;
    private LinearLayout jijing_ly;
    private LinearLayout haoyou_ly;
    private LinearLayout xiaoliu_ly;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.me6,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        back = view.findViewById(R.id.back_me6);
        xihong = view.findViewById(R.id.xihong_c);
        baiyang = view.findViewById(R.id.baitang_ch);
        jidan = view.findViewById(R.id.jidan_c);
        yan = view.findViewById(R.id.yan_C);
        jijing = view.findViewById(R.id.jijing_c);
        haoyou = view.findViewById(R.id.hao_c);
        xiaoliu = view.findViewById(R.id.jiaojiu_c);
        big_checked = view.findViewById(R.id.finshied_bb);
        finshed = view.findViewById(R.id.finshed_buyin);

        xihong_ly = view.findViewById(R.id.xihong_ly);
        baitang_ly = view.findViewById(R.id.baitang_ly);
        jidan_ly = view.findViewById(R.id.jidan_ly);
        yan_ly = view.findViewById(R.id.yan_ly);
        jijing_ly = view.findViewById(R.id.jijng_ly);
        haoyou_ly = view.findViewById(R.id.haoyou_ly);
        xiaoliu_ly =view.findViewById(R.id.jiaojiu_ly);
        //初始化的可见性
        baiyang.setVisibility(View.INVISIBLE);

        jijing.setVisibility(View.INVISIBLE);
        yan.setVisibility(View.INVISIBLE);
        haoyou.setVisibility(View.INVISIBLE);
        xiaoliu.setVisibility(View.INVISIBLE);
        big_checked.setVisibility(View.INVISIBLE);
        finshed.setVisibility(View.INVISIBLE);

        xihong_ly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             change(xihong);
             isFull();
            }
        });

        baitang_ly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(baiyang);
                isFull();
            }
        });
       jidan_ly.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               change(jidan);
               isFull();
           }
       });
       yan_ly.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               change(yan);
               isFull();
           }
       });
       jijing_ly.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               change(jijing);
               isFull();
           }
       });
       haoyou_ly.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               change(haoyou);
               isFull();
           }
       });
       xiaoliu_ly.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               change(xiaoliu);
               isFull();
           }
       });
       back.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               whole_container_my wm=(whole_container_my) getActivity().getSupportFragmentManager().findFragmentById(R.id.FL_C);
               wm.me_vp.setCurrentItem(4);
           }
       });






    }
    private void change(ImageView im)
    {
        if (im.getVisibility()==View.INVISIBLE){ im.setVisibility(View.VISIBLE);}
        else {im.setVisibility(View.INVISIBLE);}
    }
    private  void isFull(){
        if((xihong.getVisibility()==View.VISIBLE) && (baiyang.getVisibility()==View.VISIBLE) && (jidan.getVisibility()==View.VISIBLE)
            && (yan.getVisibility()==View.VISIBLE) && (haoyou.getVisibility() ==View.VISIBLE) && (xiaoliu.getVisibility() ==View.VISIBLE))
        {

            big_checked.setVisibility(View.VISIBLE);
            finshed.setVisibility(View.VISIBLE);

        }
        else {
            big_checked.setVisibility(View.INVISIBLE);
            finshed.setVisibility(View.INVISIBLE);

        }
        }

    }


