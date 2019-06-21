package com.example.projectname.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.projectname.R;
import com.example.projectname.bean.V2ex_again_bean;

import java.util.ArrayList;
import java.util.List;

public class V2ex_adapter_item extends RecyclerView.Adapter<V2ex_adapter_item.ViewHolder> {
    private Context context;
    private List<V2ex_again_bean> arrayList;

    public V2ex_adapter_item(Context context, List<V2ex_again_bean> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.v2ex_again_adapter_item_layout, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(arrayList.get(position).getSrc()).into(holder.image);
        holder.count.setText(arrayList.get(position).getCount());
        holder.name.setText(arrayList.get(position).getName());
        holder.text.setText(arrayList.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  ImageView image;
        private  TextView count;
        private  TextView name;
        private  TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.v2ex_image);
            count = itemView.findViewById(R.id.v2ex_count);
            name = itemView.findViewById(R.id.v2ex_name);
            text = itemView.findViewById(R.id.v2ex_text);
        }
    }
}
