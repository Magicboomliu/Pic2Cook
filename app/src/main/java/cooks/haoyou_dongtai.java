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
import com.mob.MobSDK;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.onekeyshare.OnekeyShare;

public class haoyou_dongtai extends Fragment {
    private int i;
    private int j;
    private List<follow_dongtai_class> haoyouList = new ArrayList<>();
    RefreshLayout refreshLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.haoyou_dongtai, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        RecyclerView recyclerView = view.findViewById(R.id.haoyou_dongtai_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        haoyoudongtai_adapter adapter = new haoyoudongtai_adapter(haoyouList);
        recyclerView.setAdapter(adapter);
        refreshLayout =view.findViewById(R.id.refreshLayout_haoyou);
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


    public void init() {
        follow_dongtai_class a = new follow_dongtai_class(R.drawable.haoyou1, "小张", R.drawable.share,
                R.drawable.hh1, R.drawable.good_unclick, "32", R.drawable.heart_uncliked,
                "阳澄湖大闸蟹  #早餐~2020年3月6月#", "大闸蟹",
                "卖相不错", "可以可以，但我要减肥");
        haoyouList.add(a);
        follow_dongtai_class b = new follow_dongtai_class(R.drawable.haoyou2, "小冯", R.drawable.share,
                R.drawable.hh2, R.drawable.good_unclick, "47", R.drawable.heart_uncliked,
                "自己花一天功夫做出来的大补汤# 晚餐 2020年3月6日#", "佛跳墙",
                "辉少牛逼", "我是个没有感情的杀手");
        haoyouList.add(b);
        follow_dongtai_class c = new follow_dongtai_class(R.drawable.haoyou3, "小钟", R.drawable.share,
                R.drawable.hh3, R.drawable.good_unclick, "77", R.drawable.heart_uncliked,
                "#老八自制小汉堡#早餐-2020年3月6日#", "牛肉汉堡",
                "期待每天的c打卡", "sugoi");
        haoyouList.add(c);
        follow_dongtai_class d = new follow_dongtai_class(R.drawable.haoyou4, "小马", R.drawable.share,
                R.drawable.hh4, R.drawable.good_unclick, "77", R.drawable.heart_uncliked,
                "大西北的美味，我今天终于做出来了#午餐 2020年3月6日#", "驴肉黄面",
                "马哥厉害", "good,good");
        haoyouList.add(d);
        follow_dongtai_class e = new follow_dongtai_class(R.drawable.haoyou5, "小赖", R.drawable.share,
                R.drawable.hh5, R.drawable.good_unclick, "99", R.drawable.heart_uncliked,
                "尝尝北方的味道#", "北京烤鸭",
                "广州人的挑战", "你知道怎吃么？");
        haoyouList.add(e);
        follow_dongtai_class f = new follow_dongtai_class(R.drawable.haoyou6, "小陈", R.drawable.share,
                R.drawable.hh6, R.drawable.good_unclick, "99", R.drawable.heart_uncliked,
                "潮州的海鲜适合做日料！", "金枪鱼寿司",
                "可以可以", "可以可以，不错不错");
        haoyouList.add(f);
        follow_dongtai_class g = new follow_dongtai_class(R.drawable.haoyou7, "小阳", R.drawable.share,
                R.drawable.hh7, R.drawable.good_unclick, "99", R.drawable.heart_uncliked,
                "训练之后补充能量", "菲力牛排",
                "好想吃", "怎么做呢？？");
        haoyouList.add(g);
    }


}
