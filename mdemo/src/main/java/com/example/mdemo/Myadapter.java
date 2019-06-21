package com.example.mdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {
    private Context context;
    private List<Bean.DataBean.ListBean> listBeans;
    private  item listenneritem;


    public void setListenneritem(item listenneritem) {
        this.listenneritem = listenneritem;
    }

    public Myadapter(Context context, List<Bean.DataBean.ListBean> listBeans) {
        this.context = context;
        this.listBeans = listBeans;
    }

    public  interface  item{
        void  itemholder(View view,int position);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item_layout, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(context).load(listBeans.get(position).getPic()).into(holder.image);
        holder.name.setText(listBeans.get(position).getName());
        holder.price.setText(listBeans.get(position).getPrice()+"");
        holder.checkox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenneritem.itemholder(v,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private RadioButton checkox;
        private  ImageView image;
        private  TextView name;
        private  TextView price;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            checkox = itemView.findViewById(R.id.checkbox);
        }
    }
}
