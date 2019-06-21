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
import com.example.exercise2.beans.Shitimer;

import java.util.List;

//衣铭  日期5.27
public class Myadapter1 extends RecyclerView.Adapter<Myadapter1.ViewHolder> {
    private Context context;
    private List<Shitimer.ResultBean> arrayList;

    public Myadapter1(Context context, List<Shitimer.ResultBean> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.shuitem_layout, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.item1.setText(arrayList.get(position).getText());
        Glide.with(context).load(arrayList.get(position).getImages()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView item1;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            item1 = itemView.findViewById(R.id.show_item1);
        }
    }
}
