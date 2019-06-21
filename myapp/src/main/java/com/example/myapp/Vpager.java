package com.example.myapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Vpager extends PagerAdapter {
    private Context context;
    private ArrayList<Bean> bean;


    public Vpager(Context context, ArrayList<Bean> bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public int getCount() {
        return bean.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View inflate = View.inflate(context, R.layout.pager_layout, null);
        ImageView image = inflate.findViewById(R.id.vpager_image);
        TextView tet = inflate.findViewById(R.id.vpager_text);
        Glide.with(context).load(bean.get(position).getImage()).into(image);
        tet.setText(bean.get(position).getName());
        container.addView(inflate);
        return inflate;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
