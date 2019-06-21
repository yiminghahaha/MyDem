package com.example.demo2.adapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demo2.R;

import java.util.ArrayList;

public class Vpager extends PagerAdapter {
    private  Context context;
    private  ArrayList<String > strings;

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
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View inflate = View.inflate(context, R.layout.image_layout, null);
        ImageView image = inflate.findViewById(R.id.image);
        TextView show = inflate.findViewById(R.id.show);
        Glide.with(context).load(strings.get(position)).into(image);
        show.setText("第"+position+"张图片");
        container.addView(inflate);
        return inflate;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((View) object);

    }
}
