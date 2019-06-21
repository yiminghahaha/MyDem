package com.example.projectname.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.example.projectname.R;
import com.example.projectname.adapters.GankAdapter;
import com.example.projectname.base.BaseFragment;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.Unbinder;

public class Gank extends BaseFragment {

    @BindView(R.id.Gank_tab)
    TabLayout GankTab;
    @BindView(R.id.Gank_vp)
    ViewPager GankVp;
    Unbinder unbinder;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> strings;
    private GankAdapter gankAdapter;

    @Override
    protected int getLayoutID() {
        return R.layout.gank_layout;
    }

    @Override
    protected void initview(View inflate) {
        fragments = new ArrayList<>();
        strings = new ArrayList<>();
        strings.add("Android");
        strings.add("iOS");
        strings.add("前端");
        strings.add("福利");
        for (int i = 0; i < strings.size(); i++) {
            fragments.add(new Gank_ANDROID(strings.get(i)));
        }
        gankAdapter = new GankAdapter(getChildFragmentManager(), fragments, strings);
        GankVp.setAdapter(gankAdapter);
        GankTab.setupWithViewPager(GankVp);
    }
}
