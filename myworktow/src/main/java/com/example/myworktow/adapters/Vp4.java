package com.example.myworktow.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.example.myworktow.beans.Tab_beas;
import java.util.ArrayList;
import java.util.List;

public class Vp4 extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> fragments;
    private List<Tab_beas.DataBean> dataBeans;

    public Vp4(FragmentManager fm,ArrayList<Fragment> fragments,List<Tab_beas.DataBean> dataBeans) {
        super(fm);
        this.fragments =fragments;
        this.dataBeans = dataBeans;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return dataBeans.get(position).getName();
    }
}
