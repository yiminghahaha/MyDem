package com.example.demo1.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.demo1.Main2Activity;
import com.example.demo1.R;
import com.example.demo1.beans.Bean;

import java.util.ArrayList;
import java.util.List;

public class Myadapter1 extends RecyclerView.Adapter<Myadapter1.ViewHolder> {
    private Context context;
    private List<Bean.RecentBean> arrayList;
    private  item listenneritem;

    public void setListenneritem(item listenneritem) {
        this.listenneritem = listenneritem;
    }

    public Myadapter1(Context context, List<Bean.RecentBean> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public  interface  item{
        void  holderitem(View view,int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item_layout, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(context).load(arrayList.get(position).getThumbnail()).into(holder.image);
        holder.te1.setText(arrayList.get(position).getNews_id()+"");
        holder.te2.setText(arrayList.get(position).getTitle());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listenneritem.holderitem(v,position);
                return false;
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Main2Activity.class);
                String thumbnail = arrayList.get(position).getUrl();
                intent.putExtra("data",thumbnail);
                context.startActivity(intent);
                Toast.makeText(context, "短", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView te1;
        private final TextView te2;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.fra1_image);
            te1 = itemView.findViewById(R.id.fra1_text1);
            te2 = itemView.findViewById(R.id.fra1_text2);
        }
    }
}
