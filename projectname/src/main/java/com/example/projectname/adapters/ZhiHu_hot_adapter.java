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
import com.example.projectname.bean.NewDay_Hot;

import java.util.List;

public class ZhiHu_hot_adapter extends RecyclerView.Adapter<ZhiHu_hot_adapter.ViewHolder> {
    private Context context;
    private List<NewDay_Hot.RecentBean> recentBeans;

    public ZhiHu_hot_adapter(Context context, List<NewDay_Hot.RecentBean> recentBeans) {
        this.context = context;
        this.recentBeans = recentBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.hot_item_layout, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(recentBeans.get(position).getThumbnail()).into(holder.image);
        holder.title.setText(recentBeans.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return recentBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.hot_image);
            title = itemView.findViewById(R.id.hot_title);
        }
    }
}
