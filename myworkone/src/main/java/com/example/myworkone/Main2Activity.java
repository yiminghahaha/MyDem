package com.example.myworkone;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.myworkone.adapters.Shou_adapter;
import com.example.myworkone.beans.Dao_bean;
import com.example.myworkone.fragments.BlankFragment;
import com.example.myworkone.fragments.BlankFragment2;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private FrameLayout flayout;
    private BlankFragment blankFragment;
    private BlankFragment2 blankFragment2;
    private FragmentManager ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        flayout = (FrameLayout) findViewById(R.id.flayout);
        blankFragment = new BlankFragment();
        blankFragment2 = new BlankFragment2();
        ma = getSupportFragmentManager();
        ma.beginTransaction().add(R.id.flayout,blankFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1,1,1,"ITEM");
        menu.add(1,2,1,"收藏");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                ma.beginTransaction().replace(R.id.flayout,blankFragment).commit();
                break;

            case 2:
                ma.beginTransaction().replace(R.id.flayout,blankFragment2).commit();
//                List<Dao_bean> dao_beans = DaoUtils.getDaoUtils().queryAll();
//                Shou_adapter adapter = new Shou_adapter(this, dao_beans);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
