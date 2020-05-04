package cooks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pic2cook_develop.R;
import com.google.android.material.navigation.NavigationView;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import my.whole_container_my;

public class search_contents extends Fragment {

    private RecyclerView rc_search;
    private ImageView filter;
    private TextView ingredientA;
    private TextView ingredientB;
    private ImageView back;
    private List<search_contents_class> scc = new ArrayList<>();
    RefreshLayout refreshLayout;
    private ImageView filterB;
    private RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.testxx,container,false);
        init();
        back =view.findViewById(R.id.ibback2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                whole_container wm=(whole_container) getActivity().getSupportFragmentManager().findFragmentById(R.id.FL_C);
                wm.vp_cook.setCurrentItem(0);
            }
        });
        recyclerView = (RecyclerView) view.findViewById(R.id.show_the_search_contens);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        Search_Contents_Adapter adapter = new Search_Contents_Adapter(scc);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refreshLayout =view.findViewById(R.id.refreshLayout_suantai);
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
        filterB = view.findViewById(R.id.filter_button03);
        final DrawerLayout drawerLayout = view.findViewById(R.id.drawer_layout1);
        NavigationView navigationView = view.findViewById(R.id.naV_view);
        navigationView.setCheckedItem(R.id.sorted_scores);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                String  items = (String) menuItem.getTitle();
                if (items.equals("按照耗费的时间排序"))
                {
                    List<search_contents_class> scc_new = orderByTime();
                    Search_Contents_Adapter adapter = new Search_Contents_Adapter(scc_new);
                    recyclerView.setAdapter(adapter);

                }
                if (items.equals("按照PIC2评分排序"))
                { init();
                    Search_Contents_Adapter adapter = new Search_Contents_Adapter(scc);
                    recyclerView.setAdapter(adapter);

                }
                if (items.equals("按照点赞人数排序"))
                {
                    List<search_contents_class> scc_new = orderByGoods();
                    Search_Contents_Adapter adapter = new Search_Contents_Adapter(scc_new);
                    recyclerView.setAdapter(adapter);

                }
                if (items.equals("按照难易程度排序"))
                {
                    List<search_contents_class> scc_new = orderByEasy_or_NOT();
                    Search_Contents_Adapter adapter = new Search_Contents_Adapter(scc_new);
                    recyclerView.setAdapter(adapter);

                }
                if (items.equals("按照食材是否齐全排序"))
                {
                    List<search_contents_class> scc_new = CompeletdOrNOT();
                    Search_Contents_Adapter adapter = new Search_Contents_Adapter(scc_new);
                    recyclerView.setAdapter(adapter);

                }
                if (items.equals("按照卡路里排序"))
                {
                    List<search_contents_class> scc_new =Calories();
                    Search_Contents_Adapter adapter = new Search_Contents_Adapter(scc_new);
                    recyclerView.setAdapter(adapter);
                }

                drawerLayout.closeDrawers();
                return true;
            }
        });


        filterB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.END);
            }
        });

    }

    private void init()
    {
        search_contents_class a = new search_contents_class("全","蒜薹炒肉","LexBurner",
                "25","中","98","10.0","143",R.drawable.suantai001,R.drawable.ra1);
        scc.add(a);
        search_contents_class b = new search_contents_class("全","家常蒜薹炒肉","老番茄",
                "15","易","97","9.6","133",R.drawable.suantai002,R.drawable.ra2);
        scc.add(b);
        search_contents_class c = new search_contents_class("全","蒜薹炒肉","敖厂长",
                "16","中","102","9.2","323",R.drawable.suantai003,R.drawable.ra3);
        scc.add(c);
        search_contents_class d = new search_contents_class("缺","里脊蒜薹炒肉","朱一旦",
                "27","难","88","9.0","183",R.drawable.suantai004,R.drawable.ra4);
        scc.add(d);
        search_contents_class e = new search_contents_class("缺","快手蒜薹炒肉","手工耿r",
                "10","易","74","8.6","123",R.drawable.suantai005,R.drawable.ra5);
        scc.add(e);
        search_contents_class f = new search_contents_class("全","蒜薹炒肉","凉风KAZA",
                "12","中","89","8.4","183",R.drawable.suantai006,R.drawable.ra6);
        scc.add(f);
        search_contents_class g = new search_contents_class("缺","蒜薹炒肉-新手","Lorre",
                "19","易","89","8.4","129",R.drawable.suantai007,R.drawable.ra7);
        scc.add(g);
    }
    private List<search_contents_class> orderByTime (){

        List<search_contents_class> scc_new =  new ArrayList<>();
        search_contents_class e = new search_contents_class("缺","快手蒜薹炒肉","手工耿r",
                "10","易","74","8.6","123",R.drawable.suantai005,R.drawable.ra5);
        scc_new.add(e);
        search_contents_class f = new search_contents_class("全","蒜薹炒肉","凉风KAZA",
                "12","中","89","8.4","183",R.drawable.suantai006,R.drawable.ra6);
        scc_new.add(f);
        search_contents_class b = new search_contents_class("全","家常蒜薹炒肉","老番茄",
                "15","易","97","9.6","133",R.drawable.suantai002,R.drawable.ra2);
        scc_new.add(b);
        search_contents_class c = new search_contents_class("全","蒜薹炒肉","敖厂长",
                "16","中","102","9.2","323",R.drawable.suantai003,R.drawable.ra3);
        scc_new.add(c);
        search_contents_class g = new search_contents_class("缺","蒜薹炒肉-新手","Lorre",
                "19","易","89","8.4","129",R.drawable.suantai007,R.drawable.ra7);
        scc_new.add(g);
        search_contents_class a = new search_contents_class("全","蒜薹炒肉","LexBurner",
                "25","中","98","10.0","143",R.drawable.suantai001,R.drawable.ra1);
        scc_new.add(a);
        search_contents_class d = new search_contents_class("缺","里脊蒜薹炒肉","朱一旦",
                "27","难","88","9.0","183",R.drawable.suantai004,R.drawable.ra4);
        scc_new.add(d);
      return  scc_new;

    }
    private List<search_contents_class> orderByGoods (){

        List<search_contents_class> scc_new =  new ArrayList<>();
        search_contents_class c = new search_contents_class("全","蒜薹炒肉","敖厂长",
                "16","中","102","9.2","323",R.drawable.suantai003,R.drawable.ra3);
        scc_new.add(c);
        search_contents_class d = new search_contents_class("缺","里脊蒜薹炒肉","朱一旦",
                "27","难","88","9.0","183",R.drawable.suantai004,R.drawable.ra4);
        scc_new.add(d);
        search_contents_class f = new search_contents_class("全","蒜薹炒肉","凉风KAZA",
                "12","中","89","8.4","183",R.drawable.suantai006,R.drawable.ra6);
        scc_new.add(f);
        search_contents_class a = new search_contents_class("全","蒜薹炒肉","LexBurner",
                "25","中","98","10.0","143",R.drawable.suantai001,R.drawable.ra1);
        scc_new.add(a);
        search_contents_class b = new search_contents_class("全","家常蒜薹炒肉","老番茄",
                "15","易","97","9.6","133",R.drawable.suantai002,R.drawable.ra2);
        scc_new.add(b);
        search_contents_class g = new search_contents_class("缺","蒜薹炒肉-新手","Lorre",
                "19","易","89","8.4","129",R.drawable.suantai007,R.drawable.ra7);
        scc_new.add(g);
        search_contents_class e = new search_contents_class("缺","快手蒜薹炒肉","手工耿r",
                "10","易","74","8.6","123",R.drawable.suantai005,R.drawable.ra5);
        scc_new.add(e);

        return  scc_new;

    }
    private List<search_contents_class> orderByEasy_or_NOT (){

        List<search_contents_class> scc_new =  new ArrayList<>();
        search_contents_class b = new search_contents_class("全","家常蒜薹炒肉","老番茄",
                "15","易","97","9.6","133",R.drawable.suantai002,R.drawable.ra2);
        scc_new.add(b);
        search_contents_class g = new search_contents_class("缺","蒜薹炒肉-新手","Lorre",
                "19","易","89","8.4","129",R.drawable.suantai007,R.drawable.ra7);
        scc_new.add(g);
        search_contents_class e = new search_contents_class("缺","快手蒜薹炒肉","手工耿r",
                "10","易","74","8.6","123",R.drawable.suantai005,R.drawable.ra5);
        scc_new.add(e);
        search_contents_class c = new search_contents_class("全","蒜薹炒肉","敖厂长",
                "16","中","102","9.2","323",R.drawable.suantai003,R.drawable.ra3);
        scc_new.add(c);
        search_contents_class f = new search_contents_class("全","蒜薹炒肉","凉风KAZA",
                "12","中","89","8.4","183",R.drawable.suantai006,R.drawable.ra6);
        scc_new.add(f);
        search_contents_class a = new search_contents_class("全","蒜薹炒肉","LexBurner",
                "25","中","98","10.0","143",R.drawable.suantai001,R.drawable.ra1);
        scc_new.add(a);
        search_contents_class d = new search_contents_class("缺","里脊蒜薹炒肉","朱一旦",
                "27","难","88","9.0","183",R.drawable.suantai004,R.drawable.ra4);
        scc_new.add(d);
        return  scc_new;

    }
    private List<search_contents_class> CompeletdOrNOT (){

        List<search_contents_class> scc_new =  new ArrayList<>();
        search_contents_class b = new search_contents_class("全","家常蒜薹炒肉","老番茄",
                "15","易","97","9.6","133",R.drawable.suantai002,R.drawable.ra2);
        scc_new.add(b);
        search_contents_class c = new search_contents_class("全","蒜薹炒肉","敖厂长",
                "16","中","102","9.2","323",R.drawable.suantai003,R.drawable.ra3);
        scc_new.add(c);
        search_contents_class f = new search_contents_class("全","蒜薹炒肉","凉风KAZA",
                "12","中","89","8.4","183",R.drawable.suantai006,R.drawable.ra6);
        scc_new.add(f);
        search_contents_class a = new search_contents_class("全","蒜薹炒肉","LexBurner",
                "25","中","98","10.0","143",R.drawable.suantai001,R.drawable.ra1);
        scc_new.add(a);
        search_contents_class g = new search_contents_class("缺","蒜薹炒肉-新手","Lorre",
                "19","易","89","8.4","129",R.drawable.suantai007,R.drawable.ra7);
        scc_new.add(g);
        search_contents_class e = new search_contents_class("缺","快手蒜薹炒肉","手工耿r",
                "10","易","74","8.6","123",R.drawable.suantai005,R.drawable.ra5);
        scc_new.add(e);

        search_contents_class d = new search_contents_class("缺","里脊蒜薹炒肉","朱一旦",
                "27","难","88","9.0","183",R.drawable.suantai004,R.drawable.ra4);
        scc_new.add(d);
        return  scc_new;

    }
    private List<search_contents_class> Calories (){

        List<search_contents_class> scc_new =  new ArrayList<>();
        search_contents_class e = new search_contents_class("缺","快手蒜薹炒肉","手工耿r",
                "10","易","74","8.6","123",R.drawable.suantai005,R.drawable.ra5);
        scc_new.add(e);
        search_contents_class d = new search_contents_class("缺","里脊蒜薹炒肉","朱一旦",
                "27","难","88","9.0","183",R.drawable.suantai004,R.drawable.ra4);
        scc_new.add(d);
        search_contents_class g = new search_contents_class("缺","蒜薹炒肉-新手","Lorre",
                "19","易","89","8.4","129",R.drawable.suantai007,R.drawable.ra7);
        scc_new.add(g);
        search_contents_class f = new search_contents_class("全","蒜薹炒肉","凉风KAZA",
                "12","中","89","8.4","183",R.drawable.suantai006,R.drawable.ra6);
        scc_new.add(f);
        search_contents_class b = new search_contents_class("全","家常蒜薹炒肉","老番茄",
                "15","易","97","9.6","133",R.drawable.suantai002,R.drawable.ra2);
        scc_new.add(b);
        search_contents_class a = new search_contents_class("全","蒜薹炒肉","LexBurner",
                "25","中","98","10.0","143",R.drawable.suantai001,R.drawable.ra1);
        scc_new.add(a);

        search_contents_class c = new search_contents_class("全","蒜薹炒肉","敖厂长",
                "16","中","102","9.2","323",R.drawable.suantai003,R.drawable.ra3);
        scc_new.add(c);


        return  scc_new;

    }


}
