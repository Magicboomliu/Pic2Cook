package cooks;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pic2cook_develop.R;
import com.example.pic2cook_develop.RoundImageView;

import java.util.List;

public class xinxiu_Adapter extends RecyclerView.Adapter<xinxiu_Adapter.XinxiuHolder> {
    private int i=0;
    private List<xinxiu_class> xinxiu;
    public xinxiu_Adapter(List<xinxiu_class> xinxiu_class)
    {
        this.xinxiu = xinxiu_class;
    }


    @NonNull
    @Override
    public xinxiu_Adapter.XinxiuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.xinxiu_rll,parent,false);

       final XinxiuHolder holder =new XinxiuHolder(view);
        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final xinxiu_Adapter.XinxiuHolder holder, final int position) {
          xinxiu_class xinxius = xinxiu.get(position);
          holder.xno.setText(xinxius.getXno());
          holder.xname.setText(xinxius.getXname());
          holder.xscores.setText(xinxius.getXscores());
          holder.xinxiu_sel.setImageResource(xinxius.getXimageID());
          holder.xfollow.setImageResource(xinxius.getXfollow());
          holder.xfollow.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if (i ==0)
                  {
                        holder.xfollow.setImageResource(R.drawable.ff_in_ranking_clicked);
                        i=1;

                        int postion = holder.getAdapterPosition();
                        xinxiu_class xxx= xinxiu.get(position);
                       AlertDialog.Builder dia = new AlertDialog.Builder(v.getContext());
                       dia.setTitle("你关注了:  "+xxx.getXname());
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
                  else{
                      i=0;
                      holder.xfollow.setImageResource(R.drawable.ff_in_ranks_unclick);


                      int postion = holder.getAdapterPosition();
                      xinxiu_class xxx= xinxiu.get(position);
                      AlertDialog.Builder dia = new AlertDialog.Builder(v.getContext());
                      dia.setTitle("你取消关注了:  "+xxx.getXname());
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

    }

    @Override
    public int getItemCount() {
        return xinxiu.size();
    }




    // 重新定义holder类
    class XinxiuHolder extends RecyclerView.ViewHolder{
        //  get itemView contents
        View xinxiu_view;
        RoundImageView xinxiu_sel;
        ImageView xfollow;
        TextView xno;
        TextView xname;
        TextView xscores;




        public  XinxiuHolder(View itemView){
            super((itemView));
            xinxiu_view =itemView;
            xno =itemView.findViewById(R.id.xinxiu_no);
            xname =itemView.findViewById(R.id.xinxiu_name);
            xscores =itemView.findViewById(R.id.xinxiu_score);
            xinxiu_sel =itemView.findViewById(R.id.xinxiu_sel);
            xfollow= itemView.findViewById(R.id.xinxiu_follow);


        }
    }







}
