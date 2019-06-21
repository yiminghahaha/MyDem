package com.example.projectname.fragments;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.projectname.R;
import com.example.projectname.activity.V2exActivity;
import com.example.projectname.adapters.V2ex_Vp;
import com.example.projectname.base.BaseMvpFragment;
import com.example.projectname.bean.V2ex_tab;
import com.example.projectname.medol.V2ex_Medol;
import com.example.projectname.presenter.V2ex_Presenter;
import com.example.projectname.view.V2ex_view;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

public class V2ex extends BaseMvpFragment<V2ex_Medol,V2ex_view,V2ex_Presenter> implements V2ex_view{

    @BindView(R.id.v2ex_tab)
    TabLayout v2exTab;
    @BindView(R.id.v2ex_image)
    ImageView v2exImage;
    @BindView(R.id.v2ex_vp)
    ViewPager v2exVp;
    Unbinder unbinder;
    private ArrayList<Fragment> fragments;
    private V2ex_Vp vp;
    private ArrayList<String> strings;

    @Override
    protected int getLayoutID() {
        return R.layout.v2ex_layout;
    }

    @Override
    protected V2ex_Medol initmvpmedol() {
        return new V2ex_Medol();
    }

    @Override
    protected V2ex_view initmvpview() {
        return this;
    }

    @Override
    protected V2ex_Presenter initmypresenter() {
        return new V2ex_Presenter();
    }

    @Override
    protected void initview(View inflate) {
        fragments =  new ArrayList<>();
        strings = new ArrayList<>();
    }

    @Override
    protected void initdata() {
        initmvppresenter.getdata();
    }

    @Override
    protected void initlistenner() {

        v2exImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), V2exActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void seccuss(final ArrayList<V2ex_tab> v2ex_tab){
           getActivity().runOnUiThread(new Runnable(){
               @Override
               public void run(){
                   if (v2ex_tab!=null){
                       for (int i = 0; i < v2ex_tab.size(); i++){
                           V2ex_tab v2ex_tab1 = v2ex_tab.get(i);
                           fragments.add(new V2ex_again(v2ex_tab1.getUrl()));
                           strings.add(v2ex_tab1.getTab());
                       }
                       vp = new V2ex_Vp(getActivity().getSupportFragmentManager(), fragments, strings);
                       v2exVp.setAdapter(vp);
                       v2exTab.setupWithViewPager(v2exVp);
                   }
               }
           });
    }

    @Override
    public void filed(final String mes) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(), mes, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
