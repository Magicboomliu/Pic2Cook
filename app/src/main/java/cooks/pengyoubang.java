package cooks;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

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

public class pengyoubang extends Fragment {
    private List<pengyou_class> pengyouList = new ArrayList<>();
    private TextView rules;
    RefreshLayout refreshLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pengyoubang, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rules = view.findViewById(R.id.rules_introduaction);


        refreshLayout =view.findViewById(R.id.refreshLayout);
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



        initpengyou();
        RecyclerView recyclerView = view.findViewById(R.id.pengyou_recyle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        pengyouAdapter adapter = new pengyouAdapter(pengyouList);
        recyclerView.setAdapter(adapter);
        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
                View view2 = LayoutInflater.from(getActivity()).inflate(R.layout.rules_introductions, null);
                Button confrim = view2.findViewById(R.id.understand_the_rule);
                builder1.setView(view2);
                final AlertDialog dia = builder1.show();
                confrim.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dia.dismiss();
                    }
                });


            }
        });






    }

    private void initpengyou() {
        pengyou_class a = new pengyou_class("1", "友人A", "100", R.drawable.uploader01, R.drawable.good_unclick);
        pengyouList.add(a);
        pengyou_class b = new pengyou_class("2", "友人B", "99", R.drawable.uploader02, R.drawable.good_unclick);
        pengyouList.add(b);
        pengyou_class c = new pengyou_class("3", "友人C", "98", R.drawable.uploader03, R.drawable.good_unclick);
        pengyouList.add(c);
        pengyou_class d = new pengyou_class("4", "友人D", "97", R.drawable.uploader04, R.drawable.good_unclick);
        pengyouList.add(d);
        pengyou_class e = new pengyou_class("5", "友人E", "96", R.drawable.uploader05, R.drawable.good_unclick);
        pengyouList.add(e);
        pengyou_class f = new pengyou_class("6", "友人F", "95", R.drawable.uploader06, R.drawable.good_unclick);
        pengyouList.add(f);
        pengyou_class g = new pengyou_class("7", "友人G", "94", R.drawable.uploader07, R.drawable.good_unclick);
        pengyouList.add(g);
        pengyou_class h = new pengyou_class("8", "友人H", "93", R.drawable.uploader08, R.drawable.good_unclick);
        pengyouList.add(h);
        pengyou_class i = new pengyou_class("9", "友人I", "92", R.drawable.uploader09, R.drawable.good_unclick);
        pengyouList.add(i);
    }
}
