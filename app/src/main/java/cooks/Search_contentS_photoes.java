package cooks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

public class Search_contentS_photoes extends Fragment {

    private RecyclerView rc_search;
    private ImageView filter;
    private TextView ingredientA;
    private TextView ingredientB;
    private ImageView back;
    private List<search_contents_class> scc = new ArrayList<>();
    RefreshLayout refreshLayout;
    private DrawerLayout drawerLayout2;
    private ImageView Filters;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.textx,container,false);

        back =view.findViewById(R.id.iback2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whole_container wm=(whole_container) getActivity().getSupportFragmentManager().findFragmentById(R.id.FL_C);
                wm.vp_cook.setCurrentItem(0);
            }
        });




        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.show_the_search_contens_PH);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        init();
        Search_Contents_Adapter adapter = new Search_Contents_Adapter(scc);
        recyclerView.setAdapter(adapter);

        drawerLayout2 =view.findViewById(R.id.drawer_layout2);

        NavigationView navigationView = view.findViewById(R.id.naV_viewPH);

        navigationView.setCheckedItem(R.id.sorted_scores);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getTitle().equals("按照PIC2评分排序")){

                    init();
                    Search_Contents_Adapter adapter = new Search_Contents_Adapter(scc);
                    recyclerView.setAdapter(adapter);

                }
                if (menuItem.getTitle().equals("按照耗费的时间排序")){

                    List<search_contents_class> scc_new = OrderByTime();
                    Search_Contents_Adapter adapter = new Search_Contents_Adapter(scc_new);
                    recyclerView.setAdapter(adapter);

                }
                if (menuItem.getTitle().equals("按照点赞人数排序")){

                    List<search_contents_class> scc_new = OrderByGood();
                    Search_Contents_Adapter adapter = new Search_Contents_Adapter(scc_new);
                    recyclerView.setAdapter(adapter);

                }
                if (menuItem.getTitle().equals("按照难易程度排序")){

                    List<search_contents_class> scc_new = OrderByESAY();
                    Search_Contents_Adapter adapter = new Search_Contents_Adapter(scc_new);
                    recyclerView.setAdapter(adapter);

                }
                if (menuItem.getTitle().equals("按照食材是否齐全排序")){

                    List<search_contents_class> scc_new = OrderByCOM();
                    Search_Contents_Adapter adapter = new Search_Contents_Adapter(scc_new);
                    recyclerView.setAdapter(adapter);

                }
                if (menuItem.getTitle().equals("按照卡路里排序")){

                    List<search_contents_class> scc_new = OrderByCAL();
                    Search_Contents_Adapter adapter = new Search_Contents_Adapter(scc_new);
                    recyclerView.setAdapter(adapter);

                }



                drawerLayout2.closeDrawers();
                return true;
            }
        });


        Filters =view.findViewById(R.id.filter_button04);

        Filters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawerLayout2.openDrawer(GravityCompat.END);
            }
        });

        refreshLayout =view.findViewById(R.id.refreshLayout_tudou);
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

    private void init()
    {
        search_contents_class a = new search_contents_class("全","香煎土豆片","LexBurner",
                "25","易","98","10.0","98",R.drawable.photo01,R.drawable.ra1);
        scc.add(a);
        search_contents_class b = new search_contents_class("全","土豆肉末拌饭","老番茄",
                "43","难","97","9.6","124",R.drawable.photo02,R.drawable.ra2);
        scc.add(b);
        search_contents_class c = new search_contents_class("缺","干锅土豆","敖厂长",
                "20","中","102","9.2","88",R.drawable.photo03,R.drawable.ra3);
        scc.add(c);
        search_contents_class d = new search_contents_class("缺","孜然土豆","朱一旦",
                "27","中","88","9.0","123",R.drawable.photo05,R.drawable.ra4);
        scc.add(d);
        search_contents_class e = new search_contents_class("全","醋溜土豆丝","手工耿r",
                "10","易","74","8.6","123",R.drawable.photo06,R.drawable.ra5);
        scc.add(e);
        search_contents_class f = new search_contents_class("全","火山土豆泥","凉风KAZA",
                "40","中","89","8.4","123",R.drawable.photo07,R.drawable.ra6);
        scc.add(f);
        search_contents_class g = new search_contents_class("缺","土豆新吃法","Lorre",
                "29","易","89","8.4","223",R.drawable.photo08,R.drawable.ra7);
        scc.add(g);
        search_contents_class h = new search_contents_class("全","黑培根土豆包","局座",
                "39","难","89","8.4","103",R.drawable.photo09,R.drawable.ra8);
        scc.add(h);
        search_contents_class i = new search_contents_class("缺","土豆可乐饼","敬汉卿",
                "44","中","89","8.4","123",R.drawable.photo10,R.drawable.ra9);
        scc.add(i);

    }
    private List<search_contents_class> OrderByTime()
    {
        List<search_contents_class> scc_new =new ArrayList<>();
        search_contents_class e = new search_contents_class("全","醋溜土豆丝","手工耿r",
                "10","易","74","8.6","123",R.drawable.photo06,R.drawable.ra5);
        scc_new.add(e);
        search_contents_class c = new search_contents_class("缺","干锅土豆","敖厂长",
                "20","中","102","9.2","183",R.drawable.photo03,R.drawable.ra3);
        scc_new.add(c);
        search_contents_class a = new search_contents_class("全","香煎土豆片","LexBurner",
                "25","易","98","10.0","88",R.drawable.photo01,R.drawable.ra1);
        scc_new.add(a);
        search_contents_class d = new search_contents_class("缺","孜然土豆","朱一旦",
                "27","中","88","9.0","89",R.drawable.photo05,R.drawable.ra4);
        scc_new.add(d);
        search_contents_class g = new search_contents_class("缺","土豆新吃法","Lorre",
                "29","易","89","8.4","92",R.drawable.photo08,R.drawable.ra7);
        scc_new.add(g);
        search_contents_class h = new search_contents_class("全","黑培根土豆包","局座",
                "39","难","89","8.4","125",R.drawable.photo09,R.drawable.ra8);
        scc_new.add(h);
        search_contents_class f = new search_contents_class("全","火山土豆泥","凉风KAZA",
                "40","中","89","8.4","123",R.drawable.photo07,R.drawable.ra6);
        scc_new.add(f);

        search_contents_class b = new search_contents_class("全","土豆肉末拌饭","老番茄",
                "43","难","97","9.6","123",R.drawable.photo02,R.drawable.ra2);
        scc_new.add(b);

        search_contents_class i = new search_contents_class("缺","土豆可乐饼","敬汉卿",
                "44","中","89","8.4","123",R.drawable.photo10,R.drawable.ra9);
        scc_new.add(i);

        return  scc_new;
    }
    private List<search_contents_class> OrderByGood()
    {
        List<search_contents_class> scc_new =new ArrayList<>();
        search_contents_class a = new search_contents_class("全","香煎土豆片","LexBurner",
                "25","易","98","10.0","88",R.drawable.photo01,R.drawable.ra1);
        scc_new.add(a);
        search_contents_class d = new search_contents_class("缺","孜然土豆","朱一旦",
                "27","中","88","9.0","89",R.drawable.photo05,R.drawable.ra4);
        scc_new.add(d);
        search_contents_class g = new search_contents_class("缺","土豆新吃法","Lorre",
                "29","易","89","8.4","92",R.drawable.photo08,R.drawable.ra7);
        scc_new.add(g);
        search_contents_class h = new search_contents_class("全","黑培根土豆包","局座",
                "39","难","89","8.4","125",R.drawable.photo09,R.drawable.ra8);
        scc_new.add(h);
        search_contents_class e = new search_contents_class("全","醋溜土豆丝","手工耿r",
                "10","易","74","8.6","129",R.drawable.photo06,R.drawable.ra5);
        scc_new.add(e);
        search_contents_class c = new search_contents_class("缺","干锅土豆","敖厂长",
                "20","中","102","9.2","133",R.drawable.photo03,R.drawable.ra3);
        scc_new.add(c);

        search_contents_class f = new search_contents_class("全","火山土豆泥","凉风KAZA",
                "40","中","89","8.4","143",R.drawable.photo07,R.drawable.ra6);
        scc_new.add(f);

        search_contents_class b = new search_contents_class("全","土豆肉末拌饭","老番茄",
                "43","难","97","9.6","155",R.drawable.photo02,R.drawable.ra2);
        scc_new.add(b);

        search_contents_class i = new search_contents_class("缺","土豆可乐饼","敬汉卿",
                "44","中","89","8.4","222",R.drawable.photo10,R.drawable.ra9);
        scc_new.add(i);

        return  scc_new;
    }


    private List<search_contents_class> OrderByESAY()
    {
        List<search_contents_class> scc_new =new ArrayList<>();
        search_contents_class e = new search_contents_class("全","醋溜土豆丝","手工耿r",
                "10","易","74","8.6","129",R.drawable.photo06,R.drawable.ra5);
        scc_new.add(e);
        search_contents_class a = new search_contents_class("全","香煎土豆片","LexBurner",
                "25","易","98","10.0","88",R.drawable.photo01,R.drawable.ra1);
        scc_new.add(a);
        search_contents_class g = new search_contents_class("缺","土豆新吃法","Lorre",
                "29","易","89","8.4","92",R.drawable.photo08,R.drawable.ra7);
        scc_new.add(g);
        search_contents_class i = new search_contents_class("缺","土豆可乐饼","敬汉卿",
                "44","中","89","8.4","222",R.drawable.photo10,R.drawable.ra9);
        scc_new.add(i);
        search_contents_class d = new search_contents_class("缺","孜然土豆","朱一旦",
                "27","中","88","9.0","89",R.drawable.photo05,R.drawable.ra4);
        scc_new.add(d);
        search_contents_class c = new search_contents_class("缺","干锅土豆","敖厂长",
                "20","中","102","9.2","133",R.drawable.photo03,R.drawable.ra3);
        scc_new.add(c);
        search_contents_class f = new search_contents_class("全","火山土豆泥","凉风KAZA",
                "40","中","89","8.4","143",R.drawable.photo07,R.drawable.ra6);
        scc_new.add(f);
        search_contents_class h = new search_contents_class("全","黑培根土豆包","局座",
                "39","难","89","8.4","125",R.drawable.photo09,R.drawable.ra8);
        scc_new.add(h);
        search_contents_class b = new search_contents_class("全","土豆肉末拌饭","老番茄",
                "43","难","97","9.6","155",R.drawable.photo02,R.drawable.ra2);
        scc_new.add(b);



        return  scc_new;
    }
    private List<search_contents_class> OrderByCOM()
    {
        List<search_contents_class> scc_new =new ArrayList<>();
        search_contents_class e = new search_contents_class("全","醋溜土豆丝","手工耿r",
                "10","易","74","8.6","129",R.drawable.photo06,R.drawable.ra5);
        scc_new.add(e);
        search_contents_class a = new search_contents_class("全","香煎土豆片","LexBurner",
                "25","易","98","10.0","88",R.drawable.photo01,R.drawable.ra1);
        scc_new.add(a);

        search_contents_class f = new search_contents_class("全","火山土豆泥","凉风KAZA",
                "40","中","89","8.4","143",R.drawable.photo07,R.drawable.ra6);
        scc_new.add(f);
        search_contents_class h = new search_contents_class("全","黑培根土豆包","局座",
                "39","难","89","8.4","125",R.drawable.photo09,R.drawable.ra8);
        scc_new.add(h);
        search_contents_class b = new search_contents_class("全","土豆肉末拌饭","老番茄",
                "43","难","97","9.6","155",R.drawable.photo02,R.drawable.ra2);
        search_contents_class g = new search_contents_class("缺","土豆新吃法","Lorre",
                "29","易","89","8.4","92",R.drawable.photo08,R.drawable.ra7);
        scc_new.add(g);
        search_contents_class i = new search_contents_class("缺","土豆可乐饼","敬汉卿",
                "44","中","89","8.4","222",R.drawable.photo10,R.drawable.ra9);
        scc_new.add(i);
        search_contents_class d = new search_contents_class("缺","孜然土豆","朱一旦",
                "27","中","88","9.0","89",R.drawable.photo05,R.drawable.ra4);
        scc_new.add(d);
        search_contents_class c = new search_contents_class("缺","干锅土豆","敖厂长",
                "20","中","102","9.2","133",R.drawable.photo03,R.drawable.ra3);
        scc_new.add(c);
        scc_new.add(b);
        return  scc_new;
    }


    private List<search_contents_class> OrderByCAL()
    {
        List<search_contents_class> scc_new =new ArrayList<>();
        search_contents_class e = new search_contents_class("全","醋溜土豆丝","手工耿r",
                "10","易","74","8.6","129",R.drawable.photo06,R.drawable.ra5);
        scc_new.add(e);
        search_contents_class d = new search_contents_class("缺","孜然土豆","朱一旦",
                "27","中","88","9.0","89",R.drawable.photo05,R.drawable.ra4);
        scc_new.add(d);
        search_contents_class f = new search_contents_class("全","火山土豆泥","凉风KAZA",
                "40","中","89","8.4","143",R.drawable.photo07,R.drawable.ra6);
        scc_new.add(f);
        search_contents_class h = new search_contents_class("全","黑培根土豆包","局座",
                "39","难","89","8.4","125",R.drawable.photo09,R.drawable.ra8);
        scc_new.add(h);
        search_contents_class g = new search_contents_class("缺","土豆新吃法","Lorre",
                "29","易","89","8.4","92",R.drawable.photo08,R.drawable.ra7);
        scc_new.add(g);

        search_contents_class i = new search_contents_class("缺","土豆可乐饼","敬汉卿",
                "44","中","90","8.4","222",R.drawable.photo10,R.drawable.ra9);
        scc_new.add(i);
        search_contents_class b = new search_contents_class("全","土豆肉末拌饭","老番茄",
                "43","难","97","9.6","155",R.drawable.photo02,R.drawable.ra2);
        search_contents_class a = new search_contents_class("全","香煎土豆片","LexBurner",
                "25","易","98","10.0","88",R.drawable.photo01,R.drawable.ra1);
        scc_new.add(a);
        search_contents_class c = new search_contents_class("缺","干锅土豆","敖厂长",
                "20","中","102","9.2","133",R.drawable.photo03,R.drawable.ra3);
        scc_new.add(c);
        scc_new.add(b);
        return  scc_new;
    }










}
