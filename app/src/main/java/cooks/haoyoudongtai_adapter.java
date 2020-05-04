package cooks;

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

public class haoyoudongtai_adapter extends RecyclerView.Adapter<haoyoudongtai_adapter.Haoyou_Holder> {
    private List<follow_dongtai_class> haoyou_dongtai;
    private int i=0;
    private int j=0;

    public  haoyoudongtai_adapter(List<follow_dongtai_class> ha)
    {
        this.haoyou_dongtai =ha;

    }


    @NonNull
    @Override
    public haoyoudongtai_adapter.Haoyou_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.haoyou_dongtai_rll,parent,false);
        // 创建一个holder
        final haoyoudongtai_adapter.Haoyou_Holder holder = new haoyoudongtai_adapter.Haoyou_Holder(view);

        holder.h_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShare();
            }
        });
        holder.h_dianzan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int postion =holder.getAdapterPosition();
                follow_dongtai_class fff = haoyou_dongtai.get(postion);
                if(i==0){
                    holder.h_dianzan.setImageResource(R.drawable.good_clicked);
                    int a = Integer.parseInt(fff.getDianzanshumu())+1;
                    String s = String.valueOf(a);
                    holder.h_dianzanshu.setText( s);
                    i=1;
                }
                else {

                    i=0;
                    holder.h_dianzan.setImageResource(R.drawable.good_unclick);
                    int a = Integer.parseInt(fff.getDianzanshumu())-1;
                    String s = String.valueOf(a);
                    holder.h_dianzanshu.setText( s);

                }



            }
        });
        holder.h_heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(j==0){
                    holder.h_heart.setImageResource(R.drawable.heart_clicked);
                    j=1;
                }
                else {
                    j=0;
                    holder.h_heart.setImageResource(R.drawable.heart_uncliked);

                }
            }
        });



        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final haoyoudongtai_adapter.Haoyou_Holder holder, int position) {

        follow_dongtai_class pds = haoyou_dongtai.get(position);
        holder.h_uploader_image.setImageResource(pds.getUploader_image());
        holder.h_uplaodername.setText(pds.getUploader_name());
        holder.h_share.setImageResource(pds.getShare());
        holder.h_dish_image.setImageResource(pds.getDish_image());
        holder.h_dish_name.setText(pds.getDish_name());
        holder.h_dianzan.setImageResource(pds.getDianzan());
        holder.h_dianzanshu.setText(pds.getDianzanshumu());
        holder.h_discriptiion.setText(pds.getDiscription());
        holder.h_pinglun1.setText(pds.getPinglun1());
        holder.h_pinglun2.setText(pds.getPinglun2());

    }

    @Override
    public int getItemCount() {
        return haoyou_dongtai.size();
    }


    // 重新定义holder类
    class Haoyou_Holder extends RecyclerView.ViewHolder{
        //  get itemView contents
        View haoyou_dongtai_view;
        RoundImageView h_uploader_image;
        TextView h_uplaodername;
        ImageView h_share;
        ImageView h_dish_image;
        ImageView h_dianzan;
        TextView h_dianzanshu;
        ImageView h_heart;
        TextView h_discriptiion;
        TextView h_dish_name;
        TextView h_pinglun1;
        TextView h_pinglun2;
        EditText h_pinglunkuang;



        public  Haoyou_Holder(View itemView){
            super((itemView));
            haoyou_dongtai_view =itemView;
            h_uploader_image = itemView.findViewById(R.id.haoyou_dongtai_uploader_image);
            h_uplaodername =itemView.findViewById(R.id.haoyou_dongtai_name);
            h_share = itemView.findViewById(R.id.haoyou_dongtai_share);
            h_dish_image =itemView.findViewById(R.id.haoyou_dongtai_dishImage);
            h_dianzan =itemView.findViewById(R.id.haoyou_dongtai_dianzan);
            h_dianzanshu =itemView.findViewById(R.id.haoyou_dongtai_dianzhushumu);
            h_heart =itemView.findViewById(R.id.haoyou_dongtai_heart);
            h_discriptiion =itemView.findViewById(R.id.haoyou_dongtai_contents);
            h_dish_name = itemView.findViewById(R.id.haoyou_dongtai_dishname);
            h_pinglun1 =itemView.findViewById(R.id.haoyou_dongtai_pinglun1);
            h_pinglun2 =itemView.findViewById(R.id.haoyou_dongtai_pinglun2);
            h_pinglunkuang =itemView.findViewById(R.id.haoyou_dongtai_neirong);

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
