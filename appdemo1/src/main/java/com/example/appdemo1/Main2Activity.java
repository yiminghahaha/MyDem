package com.example.appdemo1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class Main2Activity extends AppCompatActivity {

    private Toolbar toobar;
    private MaterialSearchView searchview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        toobar = (Toolbar) findViewById(R.id.toobar);
        setSupportActionBar(toobar);

        searchview = (MaterialSearchView) findViewById(R.id.searchview);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        MenuItem item = menu.findItem(R.id.menu);
        item.setVisible(true);
        searchview.setMenuItem(item);
        return super.onCreateOptionsMenu(menu);
    }
}
