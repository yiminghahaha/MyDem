package com.example.myworkone.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myworkone.R;
import com.example.myworkone.beans.Dao_bean;

import java.util.ArrayList;
import java.util.List;

public class Shou_adapter extends RecyclerView.Adapter<Shou_adapter.ViewHolder> {
    private Context context;
    private List<Dao_bean> dao_beans;

    public Shou_adapter(Context context, List<Dao_bean> dao_beans) {
        this.context = context;
        this.dao_beans = dao_beans;
    }

    @NonNull
    @Override
    public Shou_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item2_layout, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Shou_adapter.ViewHolder holder, int position) {
        Glide.with(context).load(dao_beans.get(position).getUrl()).into(holder.image);
        holder.txt.setText(dao_beans.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return dao_beans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView txt;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item2_image);
            txt = itemView.findViewById(R.id.item2_text);
        }
    }
}
