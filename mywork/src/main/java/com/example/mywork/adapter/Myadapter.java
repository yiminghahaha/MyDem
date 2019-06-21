package com.example.mywork.adapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.mywork.Daoutils;
import com.example.mywork.DataBean;
import com.example.mywork.R;
import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder>{
    private Context context;
    private List<DataBean> dataBeans;
    private  item listenneritem;

    public List<DataBean> getDataBeans() {
        return dataBeans;
    }

    public void setListenneritem(item listenneritem) {
        this.listenneritem = listenneritem;
    }

    public Myadapter(Context context, List<DataBean> dataBeans) {
        this.context = context;
        this.dataBeans = dataBeans;
    }

    public  interface  item{
        void  itemholder(View view,int position);
    }

    @NonNull
    @Override
    public Myadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_layout, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Myadapter.ViewHolder holder, final int position){
        DataBean dataBean = dataBeans.get(position);
        DataBean bean = Daoutils.getDaoutils().queryOne(dataBean);
        if (bean!=null){
            holder.check.setChecked(true);
        }else {
            holder.check.setChecked(false);
        }

        holder.title.setText(dataBean.getTitle());
        holder.check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenneritem.itemholder(v,position);
            }
        });
    }

    @Override
    public int getItemCount(){
        return dataBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  TextView title;
        private  CheckBox check;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            check = itemView.findViewById(R.id.checkbox);
        }
    }
}
