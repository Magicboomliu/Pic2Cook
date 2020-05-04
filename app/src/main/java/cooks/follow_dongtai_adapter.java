package cooks;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pic2cook_develop.R;
import com.example.pic2cook_develop.RoundImageView;
import com.mob.MobSDK;

import java.util.List;

import cn.sharesdk.onekeyshare.OnekeyShare;

public class follow_dongtai_adapter extends RecyclerView.Adapter<follow_dongtai_adapter.Follow_Holder> {
    private int i=0;
    private int j=0;

    private List<follow_dongtai_class> follow_dongtai;
    public  follow_dongtai_adapter(List<follow_dongtai_class> fc)
    {
        this.follow_dongtai =fc;

    }

    @NonNull
    @Override
    public follow_dongtai_adapter.Follow_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //传入每个View——Item样子
        // 首先获得父View ,渲染到 itemview

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.follow_dontai_rll,parent,false);
        // 创建一个holder
        final follow_dongtai_adapter.Follow_Holder holder = new follow_dongtai_adapter.Follow_Holder(view);
        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShare();
            }
        });

        holder.dianzan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int postion =holder.getAdapterPosition();
                follow_dongtai_class fff = follow_dongtai.get(postion);
                if(i==0){
                    holder.dianzan.setImageResource(R.drawable.good_clicked);
                   int a = Integer.parseInt(fff.getDianzanshumu())+1;
                   String s = String.valueOf(a);
                    holder.dianzanshu.setText( s);
                    i=1;
                }
                else {

                    i=0;
                    holder.dianzan.setImageResource(R.drawable.good_unclick);
                    int a = Integer.parseInt(fff.getDianzanshumu())-1;
                    String s = String.valueOf(a);
                    holder.dianzanshu.setText( s);

                }

            }
        });
        holder.heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (j==0){
                    j=1;
                    holder.heart.setImageResource(R.drawable.heart_clicked);
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(v.getContext());
                    View view2 = LayoutInflater.from(v.getContext()).inflate(R.layout.alert_dailog_saved, null);
                    builder1.setView(view2).show();

                }
                else {
                    j=0;
                    holder.heart.setImageResource(R.drawable.heart_uncliked);
                }
            }
        });



        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull follow_dongtai_adapter.Follow_Holder holder, int position) {
          follow_dongtai_class pds = follow_dongtai.get(position);
          holder.uploader_image.setImageResource(pds.getUploader_image());
          holder.uplaodername.setText(pds.getUploader_name());
          holder.share.setImageResource(pds.getShare());
          holder.dish_image.setImageResource(pds.getDish_image());
          holder.dish_name.setText(pds.getDish_name());
          holder.dianzan.setImageResource(pds.getDianzan());
          holder.dianzanshu.setText(pds.getDianzanshumu());
          holder.discriptiion.setText(pds.getDiscription());
          holder.pinglun1.setText(pds.getPinglun1());
          holder.pinglun2.setText(pds.getPinglun2());


    }

    @Override
    public int getItemCount() {
        return follow_dongtai.size();
    }



    // 重新定义holder类
    class Follow_Holder extends RecyclerView.ViewHolder{
        //  get itemView contents
        View follow_dongtai_view;
       RoundImageView uploader_image;
       TextView uplaodername;
       ImageView share;
       ImageView dish_image;
       ImageView dianzan;
       TextView dianzanshu;
       ImageView heart;
       TextView discriptiion;
       TextView dish_name;
       TextView pinglun1;
       TextView pinglun2;
       EditText pinglunkuang;



        public  Follow_Holder(View itemView){
            super((itemView));
            follow_dongtai_view =itemView;
           uploader_image = itemView.findViewById(R.id.follow_dongtai_uploader_image);
           uplaodername =itemView.findViewById(R.id.follow_dongtai_name);
           share = itemView.findViewById(R.id.follow_dongtai_share);
           dish_image =itemView.findViewById(R.id.follow_dongtai_dishImage);
           dianzan =itemView.findViewById(R.id.follow_dongtai_dianzan);
           dianzanshu =itemView.findViewById(R.id.follow_dongtai_dianzhushumu);
           heart =itemView.findViewById(R.id.follow_dongtai_heart);
           discriptiion =itemView.findViewById(R.id.follow_dongtai_contents);
           dish_name = itemView.findViewById(R.id.follow_dongtai_dishname);
           pinglun1 =itemView.findViewById(R.id.follow_dongtai_pinglun1);
           pinglun2 =itemView.findViewById(R.id.follow_dongtai_pinglun2);
           pinglunkuang =itemView.findViewById(R.id.follow_dongtai_pinglunneirong);

        }
    }

    private void showShare() {
        final OnekeyShare oks = new OnekeyShare();
        //指定分享的平台，如果为空，还是会调用九宫格的平台列表界面
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle("标题");
        // titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        //启动分享
        oks.show(MobSDK.getContext());
    }
}
