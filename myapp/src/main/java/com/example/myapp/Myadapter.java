package com.example.myapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {
    private  Context context;
    private List<Daobean> daobeans;
    private  item listenneritem;
    private Daobean daobean;

    public void setListenneritem(item listenneritem) {
        this.listenneritem = listenneritem;
    }

    public Myadapter(Context context, List<Daobean> daobeans) {
        this.context = context;
        this.daobeans = daobeans;
    }
    public  interface  item{
        void  itemholder(Daobean daobean,int position);
    }

    @NonNull
    @Override
    public Myadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item_layout, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myadapter.ViewHolder holder, final int position) {
        Glide.with(context).load(daobeans.get(position).getImage()).into(holder.image);
        holder.name.setText(daobeans.get(position).getName());
        holder.price.setText(daobeans.get(position).getPrice());
        daobean = daobeans.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenneritem.itemholder(daobean,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return daobeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView name;
        private final TextView price;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item_image);
            name = itemView.findViewById(R.id.item_name);
            price = itemView.findViewById(R.id.item_price);
        }
    }
}
