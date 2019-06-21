package com.example.myfragmentmanager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.myfragmentmanager.fragments.BlankFragment;
import com.example.myfragmentmanager.fragments.BlankFragment2;
import com.example.myfragmentmanager.fragments.FragmentUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FrameLayout line1;
    private BlankFragment blankFragment;
    private BlankFragment2 blankFragment2;
    private FragmentManager ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        line1 = (FrameLayout) findViewById(R.id.line1);
        blankFragment = new BlankFragment();
        blankFragment2 = new BlankFragment2();
        ma = getSupportFragmentManager();
        ma.beginTransaction().add(R.id.line1,blankFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1, 1, 1, "首页");
        menu.add(1, 2, 1, "我的");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case 1:
                FragmentUtils.addFragment(ma,BlankFragment.class,R.id.line1,null,true);
                break;
            case 2:
                FragmentUtils.addFragment(ma,BlankFragment2.class,R.id.line1,null,true);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
