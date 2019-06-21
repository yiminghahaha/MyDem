package com.example.projectname.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.projectname.R;
import com.example.projectname.bean.WeiChar_Bean;
import java.util.List;

public class WeiChar_adapter extends RecyclerView.Adapter<WeiChar_adapter.ViewHolder> {
    private Context context;
    private List<WeiChar_Bean.NewslistBean> newslistBeans;

    public WeiChar_adapter(Context context, List<WeiChar_Bean.NewslistBean> newslistBeans) {
        this.context = context;
        this.newslistBeans = newslistBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.weichar_item_layout, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(newslistBeans.get(position).getPicUrl()).into(holder.image);
        holder.name.setText(newslistBeans.get(position).getDescription());
        holder.title.setText(newslistBeans.get(position).getTitle());
        holder.text.setText(newslistBeans.get(position).getCtime());
    }

    @Override
    public int getItemCount() {
        return newslistBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView name;
        private final TextView title;
        private final TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.weichar_image);
            name = itemView.findViewById(R.id.weichar_name);
            title = itemView.findViewById(R.id.weichar_title);
            text = itemView.findViewById(R.id.weichar_text);
        }
    }
}
