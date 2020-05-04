package cooks;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pic2cook_develop.R;

import java.util.List;

public class Search_Remm_adatpter extends RecyclerView.Adapter<Search_Remm_adatpter.Search_Recommend_contentHolder> {

    private List<Recommed_contents_class> recommend_contentsList;

    public Context context;

    private int i =0;
    private  int j=0;
    public  Search_Remm_adatpter(Context context,List<Recommed_contents_class>rcs){

        this.recommend_contentsList = rcs;
        this.context =context;

    }


    @NonNull
    @Override
    public Search_Remm_adatpter.Search_Recommend_contentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_remcc_rll,parent,false);
        // 创建一个holder
        final Search_Remm_adatpter.Search_Recommend_contentHolder holder = new Search_Remm_adatpter.Search_Recommend_contentHolder(view);
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
    public void onBindViewHolder(@NonNull Search_Remm_adatpter.Search_Recommend_contentHolder holder, int position) {
        Recommed_contents_class scc = recommend_contentsList.get(position);

        Glide.with(context)
                .load("https:"+scc.getDish_image())
                .placeholder(R.drawable.image_loadings)
                .into(holder.dish_image3);

//        holder.dish_image2.setImageResource(scc.getDish_image());
        holder.uploader_image3.setImageResource(scc.getUploader_iamge());
        holder.iscompleted3.setText(scc.getIscompleted());
        holder.dish_name3.setText(scc.getDish_name());
        holder.uploader_name3.setText(scc.getUploader_name());
        holder.time3.setText(scc.getTime());
        holder.Complexity3.setText(scc.getComplexity());
        holder.Calories3.setText(scc.getCalories());
        holder.recommend_scores3.setText(scc.getRecommend_scores());
        holder.Likes_amounts3.setText(scc.getLikes_amount());

    }

    @Override
    public int getItemCount() {
        return recommend_contentsList.size();
    }

    // 重新定义holder类
    class Search_Recommend_contentHolder extends RecyclerView.ViewHolder {
        //  get itemView contents
        View Search_Recommend_contents_view;
        ImageView dish_image3;
        ImageView uploader_image3;
        TextView iscompleted3;
        TextView dish_name3;
        TextView uploader_name3;
        TextView time3;
        TextView Complexity3;
        TextView Calories3;
        TextView recommend_scores3;
        TextView Likes_amounts3;


        public Search_Recommend_contentHolder (View itemView) {
            super((itemView));
            Search_Recommend_contents_view= itemView;
            dish_image3 = itemView.findViewById(R.id.search_dish_image3);
            uploader_image3 =itemView.findViewById(R.id.search_user_sel3);
            iscompleted3 = itemView.findViewById(R.id.search_iscompleted3);
            dish_name3 = itemView.findViewById(R.id.search_dish_name3);
            uploader_name3 =itemView.findViewById(R.id.search_user_name3);
            time3 = itemView.findViewById(R.id.search_cooking_times3);
            Complexity3 =itemView.findViewById(R.id.search_difficulty3);
            Calories3  = itemView.findViewById(R.id.calories_per3);
            recommend_scores3 = itemView.findViewById(R.id.search_scores3);
            Likes_amounts3 =itemView.findViewById(R.id.search_likess3);

        }
    }







}


