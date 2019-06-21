package com.example.exercise2.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.example.exercise2.R;
import com.example.exercise2.beans.MoneyBean;

import java.util.ArrayList;

public class Myadapter2 extends RecyclerView.Adapter<Myadapter2.ViewHolder> {
    private Context context;
    private ArrayList<MoneyBean.ResultsBean> resultsBeans;

    public Myadapter2(Context context, ArrayList<MoneyBean.ResultsBean> resultsBeans) {
        this.context = context;
        this.resultsBeans = resultsBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.money_item_layout, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(resultsBeans.get(position).getUrl()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return resultsBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item2_image);
        }
    }
}
