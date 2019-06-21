package com.example.projectname.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.projectname.R;
import com.example.projectname.adapters.Gank_item;
import com.example.projectname.base.BaseMvpFragment;
import com.example.projectname.bean.Gank_bean;
import com.example.projectname.medol.Gank_Medol;
import com.example.projectname.presenter.Gank_Presenter;
import com.example.projectname.view.Gank_View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import qdx.stickyheaderdecoration.NormalDecoration;

@SuppressLint("ValidFragment")
public class Gank_ANDROID extends BaseMvpFragment<Gank_Medol, Gank_View, Gank_Presenter> implements Gank_View {
    @BindView(R.id.gank_lv)
    RecyclerView gankLv;
    Unbinder unbinder;
    private String string;
    private int num = 10;
    private int page = 5;
    private List<Gank_bean.ResultsBean> resultsBeans;
    private Gank_item gank_item;

    @SuppressLint("ValidFragment")
    public Gank_ANDROID(String string){
        this.string = string;
    }

    @Override
    protected Gank_Medol initmvpmedol() {
        return new Gank_Medol();
    }

    @Override
    protected Gank_View initmvpview() {
        return this;
    }

    @Override
    protected Gank_Presenter initmypresenter() {
        return new Gank_Presenter();
    }

    @Override
    protected void initview(View inflate) {
        LinearLayoutManager ma = new LinearLayoutManager(getContext());
        gankLv.setLayoutManager(ma);
        resultsBeans = new ArrayList<>();
        gank_item = new Gank_item(getContext(), resultsBeans);
        gankLv.setAdapter(gank_item);
        //头布局设置
        NormalDecoration decoration = new NormalDecoration() {
            @Override
            public String getHeaderName(int i) {
                return null;
            }
        };
        decoration.setOnDecorationHeadDraw(new NormalDecoration.OnDecorationHeadDraw() {
            @Override
            public View getHeaderView(int i) {
                View view = View.inflate(getContext(), R.layout.gank_head_layout, null);
                ImageView ima = view.findViewById(R.id.gank_head_image);
                Glide.with(getContext()).load("https://ws1.sinaimg.cn/large/0065oQSqly1fvexaq313uj30qo0wldr4.jpg").into(ima);
                return view;
            }
        });
        gankLv.addItemDecoration(decoration);
    }

    @Override
    protected void initdata(){
        initmvppresenter.getdata(string, num, page);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.gank_android_layout;
    }

    @Override
    public void gankseccuss(Gank_bean gank_bean) {
        List<Gank_bean.ResultsBean> results = gank_bean.getResults();
        resultsBeans.addAll(results);
        gank_item.notifyDataSetChanged();
    }

    @Override
    public void gankfiled(String mes) {
        Toast.makeText(getActivity(), mes, Toast.LENGTH_SHORT).show();
    }


}
