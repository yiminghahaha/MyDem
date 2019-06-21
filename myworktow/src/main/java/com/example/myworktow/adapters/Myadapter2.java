package com.example.myworktow.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myworktow.R;
import com.example.myworktow.beans.Fra5_bean;

import java.util.ArrayList;

public class Myadapter2 extends RecyclerView.Adapter<Myadapter2.ViewHolder> {
    private Context context;
    private ArrayList<Fra5_bean.DataBean.DatasBean> datasBeans;

    public Myadapter2(Context context, ArrayList<Fra5_bean.DataBean.DatasBean> datasBeans) {
        this.context = context;
        this.datasBeans = datasBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.fra5_item_layout, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(datasBeans.get(position).getEnvelopePic()).into(holder.image);
        holder.t1.setText(datasBeans.get(position).getSuperChapterName());
        holder.t2.setText(datasBeans.get(position).getTitle());
        holder.t3.setText(datasBeans.get(position).getChapterName());
    }

    @Override
    public int getItemCount() {
        return datasBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView t1;
        private final TextView t2;
        private final TextView t3;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.fra5_image);
            t1 = itemView.findViewById(R.id.fra5_tet1);
            t2 = itemView.findViewById(R.id.fra5_tet2);
            t3 = itemView.findViewById(R.id.fra5_tet3);
        }
    }
}
