package com.example.demo1.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.demo1.beans.Bean;

import java.util.ArrayList;

public class Vpager extends FragmentStatePagerAdapter {
    private  ArrayList<Fragment> fragments;
    private  ArrayList<String> strings;

    public Vpager(FragmentManager fm,ArrayList<Fragment> fragments,ArrayList<String> strings) {
        super(fm);
        this.fragments = fragments;
        this.strings = strings;
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
        return strings.get(position);
    }
}
