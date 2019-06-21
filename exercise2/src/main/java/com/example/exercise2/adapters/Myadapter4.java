package com.example.exercise2.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.exercise2.R;
import com.example.exercise2.beans.WorkBean;

import java.util.ArrayList;

public class Myadapter4 extends RecyclerView.Adapter<Myadapter4.ViewHolder> {
    private Context context;
    private ArrayList<WorkBean.DataBean> arrayList;

    public Myadapter4(Context context, ArrayList<WorkBean.DataBean> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item4_layout, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.text.setText(arrayList.get(position).getName());
        Glide.with(context).load(arrayList.get(position).getThumbnail()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item4_work);
            text = itemView.findViewById(R.id.item4_text);
        }
    }
}
