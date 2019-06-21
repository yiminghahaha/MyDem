package com.example.myworktow.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.myworktow.R;
import com.example.myworktow.beans.Buer;
import com.example.myworktow.beans.Item_bean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class Myadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Item_bean.DataBean.DatasBean> datasBeans;
    private List<Buer.DataBean> beans;

    public Myadapter(Context context, List<Item_bean.DataBean.DatasBean> datasBeans, List<Buer.DataBean> beans) {
        this.context = context;
        this.datasBeans = datasBeans;
        this.beans = beans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int i = viewType;
        if (i==0){
            View inflate = View.inflate(context, R.layout.buaner, null);
            buer buer = new buer(inflate);
            return buer;
        }else {
            View inflate = View.inflate(context, R.layout.item_adapter_layout, null);
            item item = new item(inflate);
            return item;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int i = getItemViewType(position);
        if (i==0){
            buer buer = (buer) holder;
            buer.buer.setImages(beans);
            buer.buer.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Buer.DataBean bean = (Buer.DataBean) path;
                    Glide.with(context).load(bean.getImagePath()).into(imageView);
                }
            });
            buer.buer.start();
        }else {
            int art_postion = 0;
            if (beans.size()>0){
                art_postion = position-1;
            }
            item item = (item) holder;
            item.title.setText(datasBeans.get(art_postion).getTitle());
            item.name.setText(datasBeans.get(art_postion).getAuthor());
            item.txt.setText(datasBeans.get(art_postion).getDesc());
        }
    }

    @Override
    public int getItemCount() {
        if (beans.size()>0){
            return datasBeans.size()+1;
        }else {
            return datasBeans.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0&&beans.size()>0){
            return 0;
        }else {
            return 1;
        }
    }

    public  class  buer extends RecyclerView.ViewHolder{

        private final Banner buer;

        public buer(View itemView) {
            super(itemView);
            buer = itemView.findViewById(R.id.item_buaner);
        }
    }

    public  class  item extends  RecyclerView.ViewHolder{

        private final TextView name;
        private final TextView txt;
        private final TextView title;

        public item(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_name);
            txt = itemView.findViewById(R.id.item_text);
            title = itemView.findViewById(R.id.item_title);
        }
    }
}
