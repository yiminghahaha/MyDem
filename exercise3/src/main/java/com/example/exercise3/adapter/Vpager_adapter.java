package com.example.exercise3.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.exercise3.Bean;
import com.example.exercise3.R;

import java.util.ArrayList;

public class Vpager_adapter extends PagerAdapter {
    private Context context;
    private ArrayList<Bean.ResultsBean> resultsBeans;

    public Vpager_adapter(Context context, ArrayList<Bean.ResultsBean> resultsBeans) {
        this.context = context;
        this.resultsBeans = resultsBeans;
    }

    @Override
    public int getCount() {
        return resultsBeans.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View inflate = View.inflate(context, R.layout.image_layout, null);
        ImageView imageView = inflate.findViewById(R.id.image);
        TextView text = inflate.findViewById(R.id.text);
        text.setText("第"+position+"张图片");
        Glide.with(context).load(resultsBeans.get(position).getUrl()).into(imageView);
        container.addView(inflate);
        return inflate;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
