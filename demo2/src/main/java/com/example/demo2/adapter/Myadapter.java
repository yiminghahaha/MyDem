package com.example.demo2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.demo2.R;
import com.example.demo2.beans.Bean;

import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {
    private Context context;
    private List<Bean.ResultsBean> resultsBeans;
    private  item listenneritem;
    private Bean.ResultsBean bean;
    public void setListenneritem(item listenneritem) {
        this.listenneritem = listenneritem;
    }

    public Myadapter(Context context, List<Bean.ResultsBean> resultsBeans) {
        this.context = context;
        this.resultsBeans = resultsBeans;
    }
    public  interface  item{
        void  itemholder(View view,int position);
    }
    @NonNull
    @Override
    public Myadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item_layout, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myadapter.ViewHolder holder, final int position) {
        Glide.with(context).load(resultsBeans.get(position).getUrl()).into(holder.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                bean = resultsBeans.get(position);
                listenneritem.itemholder(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultsBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item_image);
        }
    }
}
