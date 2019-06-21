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
import com.example.projectname.bean.Gank_bean;
import java.util.List;

public class Gank_item extends RecyclerView.Adapter<Gank_item.ViewHolder> {
    private Context context;
    private List<Gank_bean.ResultsBean> resultsBeans;

    public Gank_item(Context context, List<Gank_bean.ResultsBean> resultsBeans){
        this.context = context;
        this.resultsBeans = resultsBeans;
    }

    @NonNull
    @Override
    public Gank_item.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View inflate = View.inflate(context, R.layout.gank_item_layout, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Gank_item.ViewHolder holder, int position) {
        holder.name.setText(resultsBeans.get(position).getDesc());
        holder.timer.setText(resultsBeans.get(position).getWho());
        holder.desc.setText(resultsBeans.get(position).getPublishedAt());
    }

    @Override
    public int getItemCount() {
        return resultsBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  TextView name;
        private  TextView timer;
        private  TextView desc;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.gank_item_name);
            timer = itemView.findViewById(R.id.gank_item_timer);
            desc = itemView.findViewById(R.id.gank_item_desc);
        }
    }
}
