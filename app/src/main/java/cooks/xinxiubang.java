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

public class xinxiubang extends Fragment {

    private List<xinxiu_class> xinxiuList = new ArrayList<>();
    RefreshLayout refreshLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.xinxiubang,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        RecyclerView recyclerView = view.findViewById(R.id.xinxiu_recyle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        xinxiu_Adapter adapter = new xinxiu_Adapter(xinxiuList);
        recyclerView.setAdapter(adapter);
        refreshLayout =view.findViewById(R.id.refreshLayout_xinxiu);
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

    private void init() {
        xinxiu_class a = new xinxiu_class("1", "lexBurner", "100", R.drawable.ra1, R.drawable.ff_in_ranks_unclick);
        xinxiuList.add(a);
        xinxiu_class b = new xinxiu_class("2", "老番茄", "99", R.drawable.ra2, R.drawable.ff_in_ranks_unclick);
        xinxiuList.add(b);
        xinxiu_class c = new xinxiu_class("3", "敖厂长", "98", R.drawable.ra3, R.drawable.ff_in_ranks_unclick);
        xinxiuList.add(c);
        xinxiu_class d = new xinxiu_class("4", "朱一旦", "97", R.drawable.ra4, R.drawable.ff_in_ranks_unclick);
        xinxiuList.add(d);
        xinxiu_class e = new xinxiu_class("5", "手工耿", "96", R.drawable.ra5, R.drawable.ff_in_ranks_unclick);
        xinxiuList.add(e);
        xinxiu_class f = new xinxiu_class("6", "凉风Kaza", "95", R.drawable.ra6, R.drawable.ff_in_ranks_unclick);
        xinxiuList.add(f);
        xinxiu_class g = new xinxiu_class("7", "努力的Lorre", "94", R.drawable.ra7, R.drawable.ff_in_ranks_unclick);
        xinxiuList.add(g);
        xinxiu_class h = new xinxiu_class("8", "局座", "93", R.drawable.ra8, R.drawable.ff_in_ranks_unclick);
        xinxiuList.add(h);
        xinxiu_class i = new xinxiu_class("9", "我是敬汉卿", "92", R.drawable.ra9, R.drawable.ff_in_ranks_unclick);
        xinxiuList.add(i);
    }
}
