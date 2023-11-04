package uz.coder.d2lesson59.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import uz.coder.d2lesson59.ItemTouchHelperAdapter;
import uz.coder.d2lesson59.model.NewsModel;
import uz.coder.d2lesson59.R;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> implements ItemTouchHelperAdapter {
private List<NewsModel> newsModelList;
private Context context;

    public NewsAdapter(Context context,List<NewsModel> newsModelList) {
        this.newsModelList = newsModelList;
        this.context =context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.get().load(newsModelList.get(position).getImg()).into(holder.imgView);
        holder.txtTitle.setText(newsModelList.get(position).getTitle());
        holder.txtDate.setText(newsModelList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return newsModelList.size();
    }

    @Override
    public void onItemMove(int toPosition, int fromPosition) {
        if (fromPosition < toPosition){
            for (int i = fromPosition; i < toPosition ; i++) {
                Collections.swap(newsModelList,i,i+1);
            }
        }else {
            for (int i = toPosition; i > fromPosition; i--) {
                Collections.swap(newsModelList,i,i-1);

            }
        }
        notifyItemMoved(fromPosition,toPosition);
    }

    @Override
    public void onItemDismis(int positio) {

    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtDate,txtTitle;
        ImageView imgView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDate = itemView.findViewById(R.id.txt_date);
            txtTitle = itemView.findViewById(R.id.txt_title);
            imgView = itemView.findViewById(R.id.img_view);
        }
    }

}
