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
import com.example.projectname.bean.NewDay_bean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;
import java.util.List;

public class ZhiHu_NewDay_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<NewDay_bean.StoriesBean> storiesBeans;
    private List<NewDay_bean.TopStoriesBean> topStoriesBeans;
    private int anInt;

    public ZhiHu_NewDay_adapter(Context context, List<NewDay_bean.StoriesBean> storiesBeans, List<NewDay_bean.TopStoriesBean> topStoriesBeans) {
        this.context = context;
        this.storiesBeans = storiesBeans;
        this.topStoriesBeans = topStoriesBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int i = viewType;
        if (i==0){
            View inflate = View.inflate(context, R.layout.zhihu_buer_layout, null);
            header header = new header(inflate);
            return header;
        }else if (i==1){
            View inflate = View.inflate(context, R.layout.newday_name_adapter_layout, null);
            name name = new name(inflate);
            return name;
        }else if (i==2){
            View inflate = View.inflate(context, R.layout.newday_item_adapter_layout, null);
            item item = new item(inflate);
            return item;
        }
            return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int i = getItemViewType(position);
        if (i==0){
            header header = (header) holder;
            header.baer.setImages(topStoriesBeans);
            header.baer.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    NewDay_bean.TopStoriesBean bean = (NewDay_bean.TopStoriesBean) path;
                    Glide.with(context).load(bean.getImage()).into(imageView);
                }
            });
            header.baer.start();
        }
//        anInt = 0;
//        if (topStoriesBeans.size()>0){
//            anInt =position-1;
//        }
        else if (i==1){
            name name = (name) holder;
            name.text.setText("今日新闻");
        }else {
            item item = (item) holder;
            item.txt.setText(storiesBeans.get(anInt).getTitle());
            Glide.with(context).load(storiesBeans.get(anInt).getImages().get(0)).into(item.image);
        }
    }

    @Override
    public int getItemCount() {
        if (topStoriesBeans.size()>0){
            return storiesBeans.size()+1;
        }else {
            return storiesBeans.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (topStoriesBeans.size()>0&&position==0){
            return 0;
        }else {
            if (position==1){
                return 1;
            }else {
                return 2;
            }
        }

    }

    public  class  header extends RecyclerView.ViewHolder{

        private final Banner baer;

        public header(View itemView) {
            super(itemView);
            baer = itemView.findViewById(R.id.ber);
        }
    }

    public  class  name extends RecyclerView.ViewHolder{

        private final TextView text;

        public name(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
        }
    }

    public  class  item extends RecyclerView.ViewHolder{


        private final ImageView image;
        private final TextView txt;

        public item(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.newday_image);
            txt = itemView.findViewById(R.id.newday_text);

        }
    }
}
