package cooks;

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

public class pengyouAdapter extends RecyclerView.Adapter< pengyouAdapter.LinberViewHolder> {
    private int i=0;
    private List<pengyou_class> pengyou;
    // 写 构造方法
    public pengyouAdapter(List<pengyou_class> py){
        pengyou=py;
    }

    @NonNull
    @Override
    public pengyouAdapter.LinberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //传入每个View——Item样子
        // 首先获得父View ,渲染到 itemview

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pengyou_rll,parent,false);
        // 创建一个holder
        final   LinberViewHolder holder = new LinberViewHolder(view);

        return holder;
    }

    @Override
    // 给 itemView  holder 里面每个具体的内容赋值
    public void onBindViewHolder(@NonNull final LinberViewHolder holder, int position) {
          pengyou_class pys = pengyou.get(position);
           holder.no.setText(pys.getno());
           holder.name.setText(pys.getName());
           holder.scores.setText(pys.getScore());
           holder.pengyou_sel.setImageResource(pys.getImageID());
           holder.dianzan.setImageResource(pys.getDianan());

           holder.dianzan.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                   int position = holder.getAdapterPosition();
                   if(i==0){
                       i=1;
                       holder.dianzan.setImageResource(R.drawable.good_clicked);
                   }
                   else { i=0;
                       holder.dianzan.setImageResource(R.drawable.good_unclick);}

               }
           });
    }


    @Override
    public int getItemCount() {
        return  pengyou.size();
    }
    // 重新定义holder类
    class LinberViewHolder extends RecyclerView.ViewHolder{
        //  get itemView contents
        View pengyou_view;
        RoundImageView pengyou_sel;
        ImageView dianzan;
        TextView no;
        TextView name;
        TextView scores;




        public  LinberViewHolder(View itemView){
            super((itemView));
            pengyou_view =itemView;
            no =itemView.findViewById(R.id.pengyou_no);
            name =itemView.findViewById(R.id.pengyou_name);
            scores =itemView.findViewById(R.id.pengyou_scro);
            pengyou_sel =itemView.findViewById(R.id.pengyou_sel);
            dianzan= itemView.findViewById(R.id.good_or_not);


        }
    }
}
