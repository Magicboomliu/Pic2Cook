package cooks;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import my.whole_container_my;

public class Search_Recommend_Fragment extends Fragment {

    private List<Recommed_contents_class> rras = new ArrayList<>();
    private RecyclerView recyclerView;
    private List<String> isCOM;
    private List<String>  uploaderName;
    private List<String> time;
    private List<String>isEasy;
    private List<String> Cares;
    private List<String> Caluri;
    private List<String>scores;
    private List<Integer> uploader_images;
    private ImageView Filtessr;
    private List<String> ImageUrllist;
    private List<String> dishnameist;
    private List<String> detailed_urlist;
    private RefreshLayout refreshLayout;
    private DrawerLayout drawerLayout4;
    private ImageView backs;
    private String words;
    private String getImageUrl;
    private String getDishesName = " d";
    private String Nums_of_search;
    private String fuck;
    private  int Nums_of_searched;
    private final static String ENCODE = "UTF-8";
    private TextView search_content_label;
    public String FORTEST="HELLO!";

    public static  final int LLLL1=1;
    private static  final  int  LLLLL2=2;
    private ProgressDialog pg1;



    private Handler handler = new Handler(){

        public void handleMessage(Message msg)
        {
            switch(msg.what){
                case LLLL1:
                    Search_Remm_adatpter adatpter2 = new Search_Remm_adatpter(getContext(),rras);
                    recyclerView.setAdapter(adatpter2);
                    pg1.dismiss();
                    break;
                case LLLLL2:
                    init_first();
                    Search_Remm_adatpter adatpter3 = new Search_Remm_adatpter(getContext(),rras);
                    recyclerView.setAdapter(adatpter3);
                    AlertDialog.Builder dialog  = new AlertDialog.Builder(getContext());
                    dialog.setTitle("抱歉，Pic2Cook未能找到相关搭配");
                    dialog.setMessage("您的搭配过于奇特，Pic2Cook目前还没有呢~，要不然您开发一下这个菜品吧。");
                    dialog.setCancelable(false);
                    dialog.setPositiveButton("好", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog.show();
                default:
                    break;
            }


        }

    };










    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_recommend_layouts,container,false);
        whole_container wm=(whole_container) getActivity().getSupportFragmentManager().findFragmentById(R.id.FL_C);
        words = wm.search_contens.getText().toString();
        search_content_label = view.findViewById(R.id.search_content_label);
        search_content_label.setText(words);
        Filtessr = view.findViewById(R.id.filter_button_of_recomendsss);
        isCOM=new ArrayList<>();
        Collections.addAll(isCOM,"全","全","缺","缺","全","缺","缺","全","全","全");
        uploaderName = new ArrayList<>();
        Collections.addAll(uploaderName,"Lexburner","老番茄","敖厂长","朱一旦","手工耿","凉风KAZA","Lorre","局座","敬汉卿");
        time = new ArrayList<>();
        Collections.addAll(time,"25","36","12","18","30","32","39","55","68","19");
        isEasy = new ArrayList<>();
        Collections.addAll(isEasy,"易","易","难","易","中","难","易","中","中","易");
        Cares = new ArrayList<>();
        Collections.addAll(Cares,"122","322","342","233","111","222","333","322","123","192");
        Caluri = new ArrayList<>();
        Collections.addAll(Caluri,"88","123","99","89","111","92","133","122","123","132");
        scores = new ArrayList<>();
        Collections.addAll(scores,"10.0","9.9","9.9","8.9","8.7","8.6","8.5","8.5","8.4","8.3");
        uploader_images = new ArrayList<>();
        Collections.addAll(uploader_images,R.drawable.ra1,R.drawable.ra2,R.drawable.ra3,R.drawable.ra4,R.drawable.ra5,
                R.drawable.ra6,R.drawable.ra7,R.drawable.ra8,R.drawable.ra9);


        recyclerView = view.findViewById(R.id.recy_view_of_recommend_search);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        init_first();
        Search_Remm_adatpter adatpter = new Search_Remm_adatpter(getContext(),rras);
        recyclerView.setAdapter(adatpter);

        refreshLayout =view.findViewById(R.id.refreshLayout_recomm_search_rem);
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
        pg1 = new ProgressDialog(getContext());
        pg1.setTitle("Pic2Cook奋力加载图片中");
        pg1.setMessage("Crawl from 美食天下（Pic2Cook 网络爬虫合作伙伴）.....");
        pg1.setCancelable(true);
        pg1.show();




        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        new Thread(new Runnable(){
            @Override
            public void run() {

                String chinese =convertChineseWords_to_BYTES(words);

                // this is 爬虫的部分，爬取的数据是美食天下。
                try {
                    Log.d("Result","Begins!");
                    String ss ="https://home.meishichina.com/search/"+chinese;
                    Log.d("Result",ss);
                    Document doc =  Jsoup.connect("https://home.meishichina.com/search/"+chinese).get();
                    Elements elements = doc.select("div.pic");
                    Elements nums =doc.select("div.ui_title_wrap").select("span");
                    Elements hidden_urls =doc.select("div.pic").select("a");

                    try {
                        ImageUrllist  = new ArrayList<>();
                        dishnameist =  new ArrayList<>();
                        detailed_urlist = new ArrayList<>();
                        Log.d("Result",nums.get(0).text());
                        Nums_of_search =nums.get(0).text();
                        String regEx="[^0-9]";
                        Pattern p = Pattern.compile(regEx);
                        Matcher m = p.matcher(Nums_of_search);
                        fuck = m.replaceAll("").trim();
                        Nums_of_searched = Integer.parseInt(fuck);
                        Log.d("Result",fuck);
                        if(Nums_of_searched>8){
                            Nums_of_searched=8;
                        }
                        for(int j=0;j<Nums_of_searched;j++)
                        {

                            ImageUrllist.add(elements.select("img").get(j).attr("data-src"));
                            dishnameist.add(doc.select("div.detail").select("h4").select("a").get(j).text());
                            detailed_urlist.add(hidden_urls.get(j).attr("href"));

                        }
                        for(int i =0;i<ImageUrllist.size();i++)
                        {     Log.d("Result",dishnameist.get(i)) ;
                            Log.d("Result",ImageUrllist.get(i));

                        }

                        Log.d("Result",elements.select("img").get(0).attr("data-src"));
                        getImageUrl = elements.select("img").get(0).attr("data-src");
                        Elements url = doc.select("div.detail").select("h4").select("a");
                        getDishesName = url.get(0).text();
                        Log.d("Result","ss"+ getDishesName);

                        Log.d("Result","Done!");
                        init();
                        Message message = new Message();
                        message.what =LLLL1;
                        handler.sendMessage(message);


                    }
                    catch (Exception e2){
                        pg1.dismiss();
                        Log.d("Result","没有搜索到相关的搭配");
                        Message message = new Message();
                        message.what=LLLLL2;
                        handler.sendMessage(message);

                    }


                } catch (Exception e) {
                    Log.d("Result", e.toString());


                }

            }
        }).start();



        backs = view.findViewById(R.id.quit_recommendbrrbr);
        backs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whole_container wm=(whole_container) getActivity().getSupportFragmentManager().findFragmentById(R.id.FL_C);
                wm.vp_cook.setCurrentItem(0);


            }
        });

        Filtessr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout4.openDrawer(GravityCompat.END);
            }
        });
        drawerLayout4 =view.findViewById(R.id.drawer_layout_search_recommend);

        NavigationView navigationView = view.findViewById(R.id.naV_view_Search_rem);
        navigationView.setCheckedItem(R.id.sorted_scores);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getTitle().equals("按照PIC2评分排序"))
                {

                    init();
                    Search_Remm_adatpter adatpter = new Search_Remm_adatpter(getContext(),rras);
                    recyclerView.setAdapter(adatpter);


                }
                if (menuItem.getTitle().equals("按照耗费的时间排序"))
                {
                    List<Recommed_contents_class> scc_new = orderByTime();
                    Search_Remm_adatpter adapterww = new Search_Remm_adatpter(getContext(),scc_new);
                    recyclerView.setAdapter(adapterww);
                }
                if (menuItem.getTitle().equals("按照点赞人数排序")){

                    List<Recommed_contents_class> scc_new = orderByPeo();
                    Search_Remm_adatpter adapterww = new Search_Remm_adatpter(getContext(),scc_new);
                    recyclerView.setAdapter(adapterww);

                }
                if (menuItem.getTitle().equals("按照卡路里排序")){

                    List<Recommed_contents_class> scc_new = orderByCALO();
                    Search_Remm_adatpter adapterww = new Search_Remm_adatpter(getContext(),scc_new);
                    recyclerView.setAdapter(adapterww);
                }
                if (menuItem.getTitle().equals("按照食材是否齐全排序")){
                    List<Recommed_contents_class> scc_new = orderBYCOM();
                    Search_Remm_adatpter adapterww = new Search_Remm_adatpter(getContext(),scc_new);
                    recyclerView.setAdapter(adapterww);

                }
                if (menuItem.getTitle().equals("按照难易程度排序")){

                    List<Recommed_contents_class> scc_new = orderBYEasy();
                    Search_Remm_adatpter adapterww = new Search_Remm_adatpter(getContext(),scc_new);
                    recyclerView.setAdapter(adapterww);
                }

                drawerLayout4.closeDrawers();
                return true;
            }
        });




    }


    private void init_first(){
        for(int i =0;i<8;i++)
        {
            Recommed_contents_class a = new Recommed_contents_class(isCOM.get(i),"Loading",uploaderName.get(i),
                    time.get(i),isEasy.get(i),Caluri.get(i),scores.get(i),Cares.get(i),"//img.zcool.cn/community/01e5b9554116a0000001e71b366b39.jpg@1280w_1l_2o_100sh.jpg",R.drawable.ra1,
                    "https://home.meishichina.com/recipe-12378.html");
            rras.add(a);

        }
    }

    private void init(){
        rras = new ArrayList<>();
        for(int i =1;i<ImageUrllist.size();i++)
        {

            Recommed_contents_class a = new Recommed_contents_class(isCOM.get(i),dishnameist.get(i),uploaderName.get(i),
                    time.get(i),isEasy.get(i),Caluri.get(i),scores.get(i),Cares.get(i),ImageUrllist.get(i),uploader_images.get(i),
                    detailed_urlist.get(i));
            rras.add(a);

        }


    }
    private List<Recommed_contents_class> orderByTime()
    {

        List<Recommed_contents_class> scc_new =new ArrayList<>();
        int size = rras.size();
        String a;
        int b;
        int min;
        int min_pos;
        scc_new =rras;

        for(int j=0;j<size-2;j++)
        {

            for(int i=j;i<size-1;i++)
            {

                if (changemode(scc_new.get(i+1).getTime())<changemode(scc_new.get(i).getTime()))
                {
                    Recommed_contents_class temp =scc_new.get(i+1);
                    scc_new.set(i+1,scc_new.get(i));
                    scc_new.set(i,temp);


                }


            }
        }

        return scc_new;

    }
    private List<Recommed_contents_class> orderByPeo()
    {

        List<Recommed_contents_class> scc_new =new ArrayList<>();
        int size = rras.size();
        String a;
        int b;
        int min;
        int min_pos;
        scc_new =rras;

        for(int j=0;j<size-2;j++)
        {

            for(int i=j;i<size-1;i++)
            {

                if (changemode(scc_new.get(i+1).getLikes_amount())<changemode(scc_new.get(i).getLikes_amount()))
                {
                    Recommed_contents_class temp =scc_new.get(i+1);
                    scc_new.set(i+1,scc_new.get(i));
                    scc_new.set(i,temp);


                }


            }
        }

        return scc_new;

    }
    private List<Recommed_contents_class> orderByCALO()
    {

        List<Recommed_contents_class> scc_new =new ArrayList<>();
        int size = rras.size();
        String a;
        int b;
        int min;
        int min_pos;
        scc_new =rras;

        for(int j=0;j<size-2;j++)
        {

            for(int i=j;i<size-1;i++)
            {

                if (changemode(scc_new.get(i+1).getCalories())<changemode(scc_new.get(i).getCalories()))
                {
                    Recommed_contents_class temp =scc_new.get(i+1);
                    scc_new.set(i+1,scc_new.get(i));
                    scc_new.set(i,temp);


                }


            }
        }

        return scc_new;

    }
    private List<Recommed_contents_class> orderBYCOM()
    {
        List<Recommed_contents_class> scc_new =new ArrayList<>();
        int size = rras.size();
        List<Recommed_contents_class> scc_news =new ArrayList<>();
        scc_new=rras;
        for(int i=0;i<size;i++)
        {
            if(scc_new.get(i).getIscompleted().equals("全")){


                scc_news.add(scc_new.get(i));
            }

        }
        for (int j=0;j<size;j++){


            if(scc_new.get(j).getIscompleted().equals("缺")){

                scc_news.add(scc_new.get(j));
            }

        }
        Log.d("Result","The amount is"+scc_news.size());
        return scc_news;





    }
    private List<Recommed_contents_class> orderBYEasy()
    {
        List<Recommed_contents_class> scc_new =new ArrayList<>();
        int size = rras.size();
        List<Recommed_contents_class> scc_news =new ArrayList<>();
        scc_new=rras;
        for(int i=0;i<size;i++)
        {
            if(scc_new.get(i).getComplexity().equals("易")){


                scc_news.add(scc_new.get(i));
            }

        }
        for (int j=0;j<size;j++){


            if(scc_new.get(j).getComplexity().equals("中")){

                scc_news.add(scc_new.get(j));
            }

        }
        for (int z=0;z<size;z++){


            if(scc_new.get(z).getComplexity().equals("难")){

                scc_news.add(scc_new.get(z));
            }

        }

        Log.d("Result","The amount is"+scc_news.size());
        return scc_news;





    }





    private int changemode(String a)
    {

        return Integer.parseInt(a);

    }
















    private String convertChineseWords_to_BYTES(String chinese)
    {
        String result = "";
        try {
            result = java.net.URLEncoder.encode(chinese, ENCODE);
            Log.d("mytag",result);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return result;
    }
}
