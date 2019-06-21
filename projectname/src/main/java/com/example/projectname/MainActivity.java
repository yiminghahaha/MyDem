package com.example.projectname;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.projectname.base.BaseActivity;
import com.example.projectname.fragments.Ablout;
import com.example.projectname.fragments.Collect;
import com.example.projectname.fragments.Gank;
import com.example.projectname.fragments.Glidy;
import com.example.projectname.fragments.Setteing;
import com.example.projectname.fragments.V2ex;
import com.example.projectname.fragments.WeiChar;
import com.example.projectname.fragments.ZhiHu;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toobar)
    Toolbar toobar;
    @BindView(R.id.flayout)
    FrameLayout flayout;
    @BindView(R.id.nv)
    NavigationView nv;
    @BindView(R.id.dra)
    DrawerLayout dra;
    @BindView(R.id.searchTextView)
    MaterialSearchView searchTextView;
    private ArrayList<String> toobars;
    private FragmentManager ma;
    private ArrayList<Fragment> fragments;
    private MenuItem item;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initview() {
        toobars = new ArrayList<>();
        fragments = new ArrayList<>();
        toobars.add("知乎日报");
        toobars.add("微信精选");
        toobars.add("干货集中营");
        toobars.add("稀土掘金");
        toobars.add("V2EX");
        toobars.add("收藏");
        toobars.add("设置");
        toobars.add("关于");

        toobar.setTitle("知乎日报");
        setSupportActionBar(toobar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dra, toobar, R.string.app_name, R.string.app_name);
        dra.setDrawerListener(toggle);
        toggle.syncState();
        fragments.add(new ZhiHu());
        fragments.add(new WeiChar());
        fragments.add(new Gank());
        fragments.add(new Glidy());
        fragments.add(new V2ex());
        fragments.add(new Ablout());
        fragments.add(new Setteing());
        fragments.add(new Collect());

        ma = getSupportFragmentManager();
        FragmentTransaction fra = ma.beginTransaction();
        fra.add(R.id.flayout, fragments.get(0));
        fra.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.searchview,menu);
        item = menu.findItem(R.id.searchviewicon);
        item.setVisible(false);
        searchTextView.setMenuItem(item);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void initlistenner(){

        searchTextView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query){

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText){
                return false;
            }
        });

        searchTextView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener(){
            @Override
            public void onSearchViewShown(){
                Toast.makeText(MainActivity.this, "打开", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSearchViewClosed(){
                Toast.makeText(MainActivity.this, "关闭", Toast.LENGTH_SHORT).show();
            }
        });
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.n1:
                        ma.beginTransaction().replace(R.id.flayout, fragments.get(0)).commit();
                        toobar.setTitle(R.string.zhihubok);
                        dra.closeDrawers();
                        break;
                    case R.id.n2:
                        ma.beginTransaction().replace(R.id.flayout, fragments.get(1)).commit();
                        toobar.setTitle(R.string.weichar);
                        item.setVisible(true);
                        dra.closeDrawers();
                        break;
                    case R.id.n3:
                        ma.beginTransaction().replace(R.id.flayout, fragments.get(2)).commit();
                        toobar.setTitle(R.string.gank);
                        item.setVisible(true);
                        dra.closeDrawers();
                        break;
                    case R.id.n4:
                        ma.beginTransaction().replace(R.id.flayout, fragments.get(3)).commit();
                        toobar.setTitle(R.string.glod);
                        dra.closeDrawers();
                        break;
                    case R.id.n5:
                        ma.beginTransaction().replace(R.id.flayout, fragments.get(4)).commit();
                        toobar.setTitle(R.string.V2EX);
                        dra.closeDrawers();
                        break;
                    case R.id.n6:
                        ma.beginTransaction().replace(R.id.flayout, fragments.get(5)).commit();
                        toobar.setTitle(R.string.abslout);
                        dra.closeDrawers();
                        break;
                    case R.id.n7:
                        ma.beginTransaction().replace(R.id.flayout, fragments.get(6)).commit();
                        toobar.setTitle(R.string.setting);
                        dra.closeDrawers();
                        break;
                    case R.id.n8:
                        ma.beginTransaction().replace(R.id.flayout, fragments.get(7)).commit();
                        toobar.setTitle(R.string.collect);
                        dra.closeDrawers();
                        break;
                }
                return true;
            }
        });
    }

}
