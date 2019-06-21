package com.example.mdemo2.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mdemo2.Main2Activity;
import com.example.mdemo2.R;
import com.example.mdemo2.bean.Bean;
import java.util.List;

public class Myadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Bean.DataBean.DatasBean> datasBeans;
    private itemview listenner;

    public void setListenner(itemview listenner) {
        this.listenner = listenner;
    }

    public Myadapter(Context context, List<Bean.DataBean.DatasBean> datasBeans) {
        this.context = context;
        this.datasBeans = datasBeans;
    }

    public  interface  itemview{
        void  holderitem(View view,int position);
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int i = viewType;
        if (i==0){
            View inflate = View.inflate(context, R.layout.image_layout, null);
            image image = new image(inflate);
            return image;
        }else {
            View inflate = View.inflate(context, R.layout.item_layout, null);
            item item = new item(inflate);
            return item;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int i = getItemViewType(position);
        if (i==0){
            image imageview = (image) holder;
            Glide.with(context).load(datasBeans.get(position).getEnvelopePic()).into(imageview.image);
        }else {
            item item = (item) holder;
            Glide.with(context).load(datasBeans.get(position).getEnvelopePic()).into(item.item_image);
            item.item_title.setText(datasBeans.get(position).getTitle());
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenner.holderitem(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datasBeans.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position%6==0){
            return 0;
        }else {
            return 1;
        }
    }

    public class  item extends RecyclerView.ViewHolder{


        private final ImageView item_image;
        private final TextView item_title;

        public item(View itemView) {
            super(itemView);

            item_image = itemView.findViewById(R.id.item_image);
            item_title = itemView.findViewById(R.id.item_title);
        }
    }

    public  class  image extends RecyclerView.ViewHolder{

        private final ImageView image;

        public image(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
        }
    }
}
