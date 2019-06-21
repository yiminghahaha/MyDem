package com.example.work1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {
    private Context context;
    private List<Bean.DataBean> arrayList;
    private  item listenneritem;
    private ArrayList<Boolean> booleans = new ArrayList<>();

    public void setListenneritem(item listenneritem) {
        this.listenneritem = listenneritem;
    }


    public Myadapter(Context context, List<Bean.DataBean> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public  interface  item{
        void  holderitem(boolean view,int position);
    }
    @NonNull
    @Override
    public Myadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item_layout, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Myadapter.ViewHolder holder, final int position) {
        for (int i = 0; i < arrayList.size(); i++) {
            booleans.add(false);
        }
        Glide.with(context).load(arrayList.get(position).getPic()).into(holder.image);
        holder.tet.setText(arrayList.get(position).getNum()+"");
        holder.chox.setChecked(booleans.get(position));
        holder.chox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if (isChecked){
                    booleans.set(position,true);
                }else {
                    booleans.set(position,false);
                }
                listenneritem.holderitem(isChecked,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final CheckBox chox;
        private final ImageView image;
        private final TextView tet;

        public ViewHolder(View itemView) {
            super(itemView);
            chox = itemView.findViewById(R.id.checkbox);
            image = itemView.findViewById(R.id.image);
            tet = itemView.findViewById(R.id.price);
        }
    }
}
