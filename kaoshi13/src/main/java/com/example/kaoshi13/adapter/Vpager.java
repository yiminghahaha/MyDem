package com.example.kaoshi13.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.kaoshi13.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class Vpager extends PagerAdapter {
    private Context context;
    private ArrayList<String> strings;

    public Vpager(Context context, ArrayList<String> strings) {
        this.context = context;
        this.strings = strings;
    }

    @Override
    public int getCount() {
        return strings.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        View inflate = View.inflate(context, R.layout.item3_layout, null);
        Banner vbaner = inflate.findViewById(R.id.vpager_baner);
        TextView tex = inflate.findViewById(R.id.vpager_text);
        tex.setText("当前页数为："+position);
        vbaner.setImages(strings);
        vbaner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(strings.get(position)).into(imageView);
            }
        });
        vbaner.start();
        container.addView(inflate);
        return inflate;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
