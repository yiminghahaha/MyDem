package com.example.exercise2;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.exercise2.base.BaseActivity;
import com.example.exercise2.fragments.BlankFragment1;
import com.example.exercise2.fragments.BlankFragment2;
import com.example.exercise2.fragments.BlankFragment3;
import com.example.exercise2.fragments.BlankFragment4;

import butterknife.BindView;

public class MainActivity extends BaseActivity {


    @BindView(R.id.toobar)
    Toolbar toobar;
    @BindView(R.id.flayout)
    FrameLayout flayout;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.nav)
    NavigationView nav;
    @BindView(R.id.dra)
    DrawerLayout dra;
    private BlankFragment1 fragment1;
    private BlankFragment2 fragment2;
    private BlankFragment3 fragment3;
    private BlankFragment4 fragment4;
    private FragmentManager ma;

    @Override
    protected int getlayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initview() {
        toobar.setTitle("");
        setSupportActionBar(toobar);
        fragment1 = new BlankFragment1();
        fragment2 = new BlankFragment2();
        fragment3 = new BlankFragment3();
        fragment4 = new BlankFragment4();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dra, toobar, R.string.app_name, R.string.app_name);
        toggle.syncState();
        ma = getSupportFragmentManager();
        ma.beginTransaction().add(R.id.flayout,fragment1).commit();
        tab.addTab(tab.newTab().setText("C"));
        tab.addTab(tab.newTab().setText("D"));
    }

    @Override
    protected void listenner() {
        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position==0){
                    ma.beginTransaction().replace(R.id.flayout,fragment3).commit();
                }else if (position==1){
                    ma.beginTransaction().replace(R.id.flayout,fragment4).commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.n1:
                        ma.beginTransaction().replace(R.id.flayout,fragment1).commit();
                        dra.closeDrawers();
                        break;
                    case R.id.n2:
                        ma.beginTransaction().replace(R.id.flayout,fragment2).commit();
                        dra.closeDrawers();
                        break;

                }
                return false;
            }
        });
    }
}
