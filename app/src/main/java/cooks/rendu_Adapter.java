package cooks;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pic2cook_develop.R;
import com.example.pic2cook_develop.RoundImageView;

import java.util.List;

public class rendu_Adapter extends RecyclerView.Adapter< rendu_Adapter.LinberViewHolder_S> {
    private int i=0;
    private List<pengyou_class> redu;
    // 写 构造方法
    public rendu_Adapter (List<pengyou_class> rd){
        redu=rd;
    }

    @NonNull
    @Override
    public rendu_Adapter.LinberViewHolder_S onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //传入每个View——Item样子
        // 首先获得父View ,渲染到 itemview

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.renqin_rll,parent,false);
        // 创建一个holder
        final LinberViewHolder_S mholder = new LinberViewHolder_S(view);
        mholder.follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==0){
                    i=1;
                    int position =mholder.getAdapterPosition();
                    pengyou_class pysss =  redu.get(position);
                    mholder.follow.setImageResource(R.drawable.ff_in_ranking_clicked);
                    AlertDialog.Builder dia = new AlertDialog.Builder(v.getContext());
                    dia.setTitle("你关注了:  "+pysss.getName());
                    dia.setMessage("既然关注了就好好学习做菜吧");
                    dia.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dia.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                     dia.show();
                }
                else {i=0;
                mholder.follow.setImageResource(R.drawable.ff_in_ranks_unclick);

                    int position =mholder.getAdapterPosition();
                    pengyou_class pysss =  redu.get(position);

                    AlertDialog.Builder dia = new AlertDialog.Builder(v.getContext());
                    dia.setTitle("你取消:  "+pysss.getName());
                    dia.setMessage("");
                    dia.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dia.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dia.show();





                }


            }
        });
        return mholder;
    }

    @Override
    // 给 itemView  holder 里面每个具体的内容赋值
    public void onBindViewHolder(@NonNull final LinberViewHolder_S holder, int position) {
        pengyou_class pys = redu.get(position);
        holder.no.setText(pys.getno());
        holder.name.setText(pys.getName());
        holder.scores.setText(pys.getScore());
        holder.redu_sel.setImageResource(pys.getImageID());
        holder.follow.setImageResource(pys.getDianan());


    }


    @Override
    public int getItemCount() {
        return  redu.size();
    }
    // 重新定义holder类
    class LinberViewHolder_S extends RecyclerView.ViewHolder{
        //  get itemView contents
        View redu_view;
        RoundImageView redu_sel;
        ImageView follow;
        TextView no;
        TextView name;
        TextView scores;




        public  LinberViewHolder_S(View itemView){
            super((itemView));
            redu_view =itemView;
            no =itemView.findViewById(R.id.renqing_no);
            name =itemView.findViewById(R.id.renqing_name);
            scores =itemView.findViewById(R.id.renqing_score);
            redu_sel =itemView.findViewById(R.id.renqing_sel);
            follow= itemView.findViewById(R.id.follow_or_not);


        }
    }
}
