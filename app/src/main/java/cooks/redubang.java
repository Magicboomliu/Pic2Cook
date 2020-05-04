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

public class redubang extends Fragment {
    private List<pengyou_class> reduList = new ArrayList<>();
    RefreshLayout refreshLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.renqingbang,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         init();
        RecyclerView recyclerView = view.findViewById(R.id.renqi_recyle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        rendu_Adapter adapter = new rendu_Adapter(reduList);
        recyclerView.setAdapter(adapter);

        refreshLayout =view.findViewById(R.id.refreshLayout_renqin);
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
        pengyou_class a = new pengyou_class("1", "lexBurner", "100", R.drawable.ra1, R.drawable.ff_in_ranks_unclick);
        reduList.add(a);
        pengyou_class b = new pengyou_class("2", "老番茄", "99", R.drawable.ra2, R.drawable.ff_in_ranks_unclick);
        reduList.add(b);
        pengyou_class c = new pengyou_class("3", "敖厂长", "98", R.drawable.ra3, R.drawable.ff_in_ranks_unclick);
        reduList.add(c);
        pengyou_class d = new pengyou_class("4", "朱一旦", "97", R.drawable.ra4, R.drawable.ff_in_ranks_unclick);
        reduList.add(d);
        pengyou_class e = new pengyou_class("5", "手工耿", "96", R.drawable.ra5, R.drawable.ff_in_ranks_unclick);
        reduList.add(e);
        pengyou_class f = new pengyou_class("6", "凉风Kaza", "95", R.drawable.ra6, R.drawable.ff_in_ranks_unclick);
        reduList.add(f);
        pengyou_class g = new pengyou_class("7", "努力的Lorre", "94", R.drawable.ra7, R.drawable.ff_in_ranks_unclick);
        reduList.add(g);
        pengyou_class h = new pengyou_class("8", "局座", "93", R.drawable.ra8, R.drawable.ff_in_ranks_unclick);
        reduList.add(h);
        pengyou_class i = new pengyou_class("9", "我是敬汉卿", "92", R.drawable.ra9, R.drawable.ff_in_ranks_unclick);
        reduList.add(i);
    }


}
