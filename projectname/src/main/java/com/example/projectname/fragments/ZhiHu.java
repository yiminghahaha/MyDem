package com.example.projectname.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.projectname.R;
import com.example.projectname.adapters.Zhihu_Vpadapter;
import com.example.projectname.base.BaseFragment;

import java.util.ArrayList;
import butterknife.BindView;
import butterknife.Unbinder;

public class ZhiHu extends BaseFragment {

    @BindView(R.id.zhihu_tab)
    TabLayout zhihuTab;
    @BindView(R.id.zhihu_vpager)
    ViewPager zhihuVpager;
    Unbinder unbinder;
    private ArrayList<Fragment> fragments;
    private Zhihu_Vpadapter zhihu_vpadapter;

    @Override
    protected int getLayoutID() {
        return R.layout.zhihu_layout;
    }

    @Override
    protected void initview(View inflate) {
        fragments = new ArrayList<>();
        fragments.add(new ZhiHu_NewDay());
        fragments.add(new ZhiHu_Column());
        fragments.add(new ZhiHu_Hot());
        ArrayList<String> strings = new ArrayList<>();
        strings.add("最新日报");
        strings.add("专栏热门");
        strings.add("热门日报");
        zhihu_vpadapter = new Zhihu_Vpadapter(getActivity().getSupportFragmentManager(), fragments, strings);
        zhihuVpager.setAdapter(zhihu_vpadapter);
        zhihuTab.setupWithViewPager(zhihuVpager);
    }
}
