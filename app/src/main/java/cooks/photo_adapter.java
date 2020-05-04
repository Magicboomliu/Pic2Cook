package cooks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pic2cook_develop.R;

import java.util.List;

public class photo_adapter extends RecyclerView.Adapter<photo_adapter.Search_contentHolderph> {
    private List<search_contents_class> photos;
    public photo_adapter(List<search_contents_class> sc)

    {
        this.photos =sc;
    }




    @NonNull
    @Override
    public photo_adapter.Search_contentHolderph onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.phoyto,parent,false);
        // 创建一个holder
        final photo_adapter.Search_contentHolderph holder = new photo_adapter.Search_contentHolderph(view);


        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull photo_adapter.Search_contentHolderph holder, int position) {
        search_contents_class scc = photos.get(position);
        holder.dish_image1.setImageResource(scc.getDish_image());
        holder.uploader_image1.setImageResource(scc.getUploader_iamge());
        holder.iscompleted1.setText(scc.getIscompleted());
        holder.dish_name1.setText(scc.getDish_name());
        holder.uploader_name1.setText(scc.getUploader_name());
        holder.time1.setText(scc.getTime());
        holder.Complexity1.setText(scc.getComplexity());
        holder.Calories1.setText(scc.getCalories());
        holder.recommend_scores1.setText(scc.getRecommend_scores());
        holder.Likes_amounts1.setText(scc.getLikes_amount());
    }

    @Override
    public int getItemCount() {
        return 0;
    }




    // 重新定义holder类
    class Search_contentHolderph extends RecyclerView.ViewHolder {
        //  get itemView contents
        View Search_contents_view1;
        ImageView dish_image1;
        ImageView uploader_image1;
        TextView iscompleted1;
        TextView dish_name1;
        TextView uploader_name1;
        TextView time1;
        TextView Complexity1;
        TextView Calories1;
        TextView recommend_scores1;
        TextView Likes_amounts1;


        public Search_contentHolderph (View itemView) {
            super((itemView));
            Search_contents_view1 = itemView;
            dish_image1 = itemView.findViewById(R.id.search_dish_image1);
            uploader_image1 =itemView.findViewById(R.id.search_user_sel1);
            iscompleted1 = itemView.findViewById(R.id.search_iscompleted1);
            dish_name1 = itemView.findViewById(R.id.search_dish_name1);
            uploader_name1 =itemView.findViewById(R.id.search_user_name1);
            time1 = itemView.findViewById(R.id.search_cooking_times1);
            Complexity1 =itemView.findViewById(R.id.search_difficulty1);
            Calories1  = itemView.findViewById(R.id.calories_per1);
            recommend_scores1 = itemView.findViewById(R.id.search_scores1);
            Likes_amounts1 =itemView.findViewById(R.id.search_likess1);




        }
    }
}
