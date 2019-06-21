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
import com.example.exercise2.beans.Newbook;

import java.util.List;

public class Myadapter3 extends RecyclerView.Adapter<Myadapter3.ViewHolder> {
    private Context context;
    private List<Newbook.StoriesBean> newbooks;

    public Myadapter3(Context context, List<Newbook.StoriesBean> newbooks) {
        this.context = context;
        this.newbooks = newbooks;
    }

    @NonNull
    @Override
    public Myadapter3.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.newitem_layout, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myadapter3.ViewHolder holder, int position) {
        Glide.with(context).load(newbooks.get(position).getImages().get(0)).into(holder.image);
        holder.text.setText(newbooks.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return newbooks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  ImageView image;
        private  TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.newimage);
            text = itemView.findViewById(R.id.newtext);
        }
    }
}
