package cooks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pic2cook_develop.R;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

public class follow_dongtai extends Fragment {
    private List<follow_dongtai_class> followList = new ArrayList<>();
    RefreshLayout refreshLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.follow_dongtai,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        RecyclerView recyclerView = view.findViewById(R.id.follow_dongtai_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        follow_dongtai_adapter adapter = new follow_dongtai_adapter(followList);
        recyclerView.setAdapter(adapter);
        refreshLayout =view.findViewById(R.id.refreshLayout_follow_dontai);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000/*,false*/);
            }
        });
    }



    public void  init(){
        follow_dongtai_class a =new follow_dongtai_class(R.drawable.ra1,"LexBurner",R.drawable.share,
                R.drawable.ddd1,R.drawable.good_unclick,"32",R.drawable.heart_uncliked,
                "儿子指明要吃的、一定要高温快烤  #早餐~2020年3月6月#","巧克力熔岩蛋糕",
                "卖相不错","可以可以，但我要减肥");
        followList.add(a);
        follow_dongtai_class b =new follow_dongtai_class(R.drawable.ra2,"老番茄",R.drawable.share,
                R.drawable.ddd2,R.drawable.good_unclick,"47",R.drawable.heart_uncliked,
                "自己熬的草莓酱太好吃了，还有大颗粒的草莓~# 早餐 2020年3月6日#","草莓酱馅饼",
                "财大牛逼","我是个没有感情的杀手");
        followList.add(b);
        follow_dongtai_class c =new follow_dongtai_class(R.drawable.ra3,"敖厂长",R.drawable.share,
                R.drawable.ddd3,R.drawable.good_unclick,"77",R.drawable.heart_uncliked,
                "#平平淡淡的幸福#布丁，水果，酸奶#早餐-2020年3月6日#","紫薯吐司布丁",
                "期待每天的c打卡","厂长好");
        followList.add(c);
        follow_dongtai_class d =new follow_dongtai_class(R.drawable.ra4,"朱一旦",R.drawable.share,
                R.drawable.ddd4,R.drawable.good_unclick,"77",R.drawable.heart_uncliked,
                "炸茄子不知道是油太少合适锅不对，茄子比较黏.....#午餐 2020年3月6日#","有钱人的枯燥饭",
                "茄子要提前芍一下","楼上的非洲警告");
        followList.add(d);
        follow_dongtai_class e =new follow_dongtai_class(R.drawable.ra5,"手工耿",R.drawable.share,
                R.drawable.ddd5,R.drawable.good_unclick,"99",R.drawable.heart_uncliked,
                "架子妈咪的早餐 #早餐-2020年3月6日#","烤肠三明治",
                "可以可以","刑部尚书改为御膳房了？");
        followList.add(e);
        follow_dongtai_class f =new follow_dongtai_class(R.drawable.ra6,"凉风KAZA",R.drawable.share,
                R.drawable.ddd6,R.drawable.good_unclick,"99",R.drawable.heart_uncliked,
                "开饭！","家常菜",
                "Tool凉好","可以可以，阅美食无数");
        followList.add(f);
        follow_dongtai_class g =new follow_dongtai_class(R.drawable.ra8,"张召忠",R.drawable.share,
                R.drawable.ddd6,R.drawable.good_unclick,"99",R.drawable.heart_uncliked,
                "我认为是去南京必须吃的！桂花红豆糯米圆子，超级棒~","桂花红豆糯米",
                "好想吃","怎么做呢？？");
        followList.add(g);












    }
}
