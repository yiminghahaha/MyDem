package com.example.kaoshi13.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.kaoshi13.R;
import com.example.kaoshi13.beans.Person;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class Myadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Person.ResultBean> personArrayList;
    private  item listenneritem;

    public void setListenneritem(item listenneritem) {
        this.listenneritem = listenneritem;
    }

    public Myadapter(Context context, List<Person.ResultBean> personArrayList) {
        this.context = context;
        this.personArrayList = personArrayList;
    }

    public  interface  item{
        void  itemholder(View view,int position);
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int i = viewType;
        if (i==0){
            View inflate = View.inflate(context, R.layout.buer_layout, null);
            buer buer = new buer(inflate);
            return buer;
        }else {
            View inflate = View.inflate(context, R.layout.item_layout, null);
            image1 image1 = new image1(inflate);
            return image1;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int i = getItemViewType(position);
        if (i==0){
            buer buer = (buer) holder;
            buer.buaner.setImages(personArrayList);
            buer.buaner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Person.ResultBean path1 = (Person.ResultBean) path;
                    Glide.with(context).load(path1.getHeader()).into(imageView);
                }
            });
             buer.buaner.start();
        }else {
            int art = 0;
            if (personArrayList.size()>0){
                art = position-1;
            }
            image1 image1 = (image1) holder;
            Glide.with(context).load(personArrayList.get(art).getThumbnail()).into(image1.item_image);
            image1.item_text.setText(personArrayList.get(art).getText());
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenneritem.itemholder(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return personArrayList.size();

    }

    @Override
    public int getItemViewType(int position) {
        if (personArrayList.size()>0&&position==0){
            return 0;
        }else {
            return 1;
        }
    }

    public  class  buer extends RecyclerView.ViewHolder{

        private final Banner buaner;

        public buer(View itemView) {
            super(itemView);
            buaner = itemView.findViewById(R.id.baner);
        }
    }

    public  class  image1 extends RecyclerView.ViewHolder{

        private final ImageView item_image;
        private final TextView item_text;

        public image1(View itemView) {
            super(itemView);
            item_image = itemView.findViewById(R.id.item_image1);
            item_text = itemView.findViewById(R.id.item_text1);
        }
    }


}
