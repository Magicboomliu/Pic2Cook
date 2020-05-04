package cooks;

import android.media.Image;
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

import org.w3c.dom.Text;

import java.util.List;

public class Search_Contents_Adapter extends RecyclerView.Adapter<Search_Contents_Adapter.Search_contentHolder> {
    private List<search_contents_class> search_contentsList;
    private int i =0;
    private  int j=0;

    public Search_Contents_Adapter(List<search_contents_class> sc)

    {
        this.search_contentsList =sc;
    }

    @NonNull
    @Override
    public Search_Contents_Adapter.Search_contentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dishes_selection_rll,parent,false);
        // 创建一个holder
        final Search_Contents_Adapter.Search_contentHolder holder = new Search_Contents_Adapter.Search_contentHolder(view);

        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Search_Contents_Adapter.Search_contentHolder holder, int position) {
      search_contents_class scc = search_contentsList.get(position);
      holder.dish_image.setImageResource(scc.getDish_image());
      holder.uploader_image.setImageResource(scc.getUploader_iamge());
      holder.iscompleted.setText(scc.getIscompleted());
      holder.dish_name.setText(scc.getDish_name());
      holder.uploader_name.setText(scc.getUploader_name());
      holder.time.setText(scc.getTime());
      holder.Complexity.setText(scc.getComplexity());
      holder.Calories.setText(scc.getCalories());
      holder.recommend_scores.setText(scc.getRecommend_scores());
      holder.Likes_amounts.setText(scc.getLikes_amount());


    }

    @Override
    public int getItemCount() {

        return search_contentsList.size();
    }



    // 重新定义holder类
    class Search_contentHolder extends RecyclerView.ViewHolder {
        //  get itemView contents
        View Search_contents_view;
        ImageView dish_image;
        ImageView uploader_image;
        TextView iscompleted;
        TextView dish_name;
        TextView uploader_name;
        TextView time;
        TextView Complexity;
        TextView Calories;
        TextView recommend_scores;
        TextView Likes_amounts;


        public Search_contentHolder (View itemView) {
            super((itemView));
            Search_contents_view = itemView;
            dish_image = itemView.findViewById(R.id.search_dish_image);
            uploader_image =itemView.findViewById(R.id.search_user_sel);
            iscompleted = itemView.findViewById(R.id.search_iscompleted);
            dish_name = itemView.findViewById(R.id.search_dish_name);
            uploader_name =itemView.findViewById(R.id.search_user_name);
            time = itemView.findViewById(R.id.search_cooking_times);
            Complexity =itemView.findViewById(R.id.search_difficulty);
            Calories  = itemView.findViewById(R.id.calories_per);
            recommend_scores = itemView.findViewById(R.id.search_scores);
            Likes_amounts =itemView.findViewById(R.id.search_likess);




        }
    }


}
