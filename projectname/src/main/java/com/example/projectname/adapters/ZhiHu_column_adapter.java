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
import com.example.projectname.bean.NewDay_colomn;

import java.util.ArrayList;
import java.util.List;

public class ZhiHu_column_adapter extends RecyclerView.Adapter<ZhiHu_column_adapter.ViewHolder> {
    private Context context;
    private List<NewDay_colomn.DataBean> dataBeans;

    public ZhiHu_column_adapter(Context context, List<NewDay_colomn.DataBean> dataBeans) {
        this.context = context;
        this.dataBeans = dataBeans;
    }

    @NonNull
    @Override
    public ZhiHu_column_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.column_item_layout, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ZhiHu_column_adapter.ViewHolder holder, int position) {
        holder.name.setText(dataBeans.get(position).getName());
        holder.title.setText(dataBeans.get(position).getDescription());
        Glide.with(context).load(dataBeans.get(position).getThumbnail()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView name;
        private final ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.column_title);
            name = itemView.findViewById(R.id.column_name);
            image = itemView.findViewById(R.id.column_image);
        }
    }
}
