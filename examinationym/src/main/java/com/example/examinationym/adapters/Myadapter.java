package com.example.examinationym.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.examinationym.R;
import com.example.examinationym.beans.Bean;

import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {
    private Context context;
    private List<Bean.DataBean.ListBean> arrayList;
    private  item listenner;
    private Bean.DataBean.ListBean listBean;
    private  item listenneritem;

    public void setListenneritem(item listenneritem) {
        this.listenneritem = listenneritem;
    }

    public Myadapter(Context context, List<Bean.DataBean.ListBean> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public  interface  item{
        void  holder(int position,View view);
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
        Glide.with(context).load(arrayList.get(position).getPic()).into(holder.image);
            holder.text1.setText(arrayList.get(position).getName());
            holder.text2.setText(arrayList.get(position).getPrice()+".00元");

//            holder.group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(RadioGroup group, int checkedId) {
//                    Log.i("onCheckedChanged", "onCheckedChanged: "+checkedId);
//                }
//            });
            holder.rad.setOnClickListener(new View.OnClickListener() {
                private int price;
                @Override
                public void onClick(View v) {
                    price = arrayList.get(position).getPrice();
                    listenneritem.holder(price,v);
                }
            });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private final RadioGroup group;
        private RadioButton rad;
        private  ImageView image;
        private TextView text1;
        private  TextView text2;

        public ViewHolder(View itemView) {
            super(itemView);
            rad = itemView.findViewById(R.id.rd);
            image = itemView.findViewById(R.id.item_image);
            text1 = itemView.findViewById(R.id.item_text1);
            text2 = itemView.findViewById(R.id.adapter_text2);
            group = itemView.findViewById(R.id.group);
        }
    }
}
