package cooks;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.pic2cook_develop.R;

import java.util.List;

public class reommend_rv_adatpter extends RecyclerView.Adapter<reommend_rv_adatpter.Recommend_contentHolder> {
    private List<Recommed_contents_class> recommend_contentsList;

    public Context context;

    private int i =0;
    private  int j=0;
    public  reommend_rv_adatpter(Context context,List<Recommed_contents_class>rcs){

        this.recommend_contentsList = rcs;
            this.context =context;

    }


    @NonNull
    @Override
    public reommend_rv_adatpter.Recommend_contentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recogn_contents_rll,parent,false);
        // 创建一个holder
        final reommend_rv_adatpter.Recommend_contentHolder holder = new reommend_rv_adatpter.Recommend_contentHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.getAdapterPosition();
                Recommed_contents_class rcc = recommend_contentsList.get(pos);

                Intent intent = new Intent(v.getContext(),show_more_details_activitys_from_search.class);
                intent.putExtra("urls",rcc.getNextPageUrls());
                v.getContext().startActivity(intent);

            }
        });
        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull reommend_rv_adatpter.Recommend_contentHolder  holder, int position) {
        Recommed_contents_class scc = recommend_contentsList.get(position);

        Glide.with(context)
                .load("https:"+scc.getDish_image())
                .placeholder(R.drawable.image_loadings)
                .into(holder.dish_image2);

//        holder.dish_image2.setImageResource(scc.getDish_image());
        holder.uploader_image2.setImageResource(scc.getUploader_iamge());
        holder.iscompleted2.setText(scc.getIscompleted());
        holder.dish_name2.setText(scc.getDish_name());
        holder.uploader_name2.setText(scc.getUploader_name());
        holder.time2.setText(scc.getTime());
        holder.Complexity2.setText(scc.getComplexity());
        holder.Calories2.setText(scc.getCalories());
        holder.recommend_scores2.setText(scc.getRecommend_scores());
        holder.Likes_amounts2.setText(scc.getLikes_amount());




    }

    @Override
    public int getItemCount() {
        return recommend_contentsList.size();
    }

    // 重新定义holder类
    class Recommend_contentHolder extends RecyclerView.ViewHolder {
        //  get itemView contents
        View Recommend_contents_view;
        ImageView dish_image2;
        ImageView uploader_image2;
        TextView iscompleted2;
        TextView dish_name2;
        TextView uploader_name2;
        TextView time2;
        TextView Complexity2;
        TextView Calories2;
        TextView recommend_scores2;
        TextView Likes_amounts2;


        public Recommend_contentHolder (View itemView) {
            super((itemView));
            Recommend_contents_view= itemView;
            dish_image2 = itemView.findViewById(R.id.search_dish_image2);
            uploader_image2 =itemView.findViewById(R.id.search_user_sel2);
            iscompleted2 = itemView.findViewById(R.id.search_iscompleted2);
            dish_name2 = itemView.findViewById(R.id.search_dish_name2);
            uploader_name2 =itemView.findViewById(R.id.search_user_name2);
            time2 = itemView.findViewById(R.id.search_cooking_times2);
            Complexity2 =itemView.findViewById(R.id.search_difficulty2);
            Calories2  = itemView.findViewById(R.id.calories_per2);
            recommend_scores2 = itemView.findViewById(R.id.search_scores2);
            Likes_amounts2 =itemView.findViewById(R.id.search_likess2);

        }
    }

}
