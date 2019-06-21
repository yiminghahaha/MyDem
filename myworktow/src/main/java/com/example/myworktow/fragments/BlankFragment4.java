package com.example.myworktow.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myworktow.R;
import com.example.myworktow.adapters.Vp4;
import com.example.myworktow.beans.Tab_beas;
import com.example.myworktow.tab_medol.Tab_medolimple;
import com.example.myworktow.tab_presenter.Tab_Presenterimple;
import com.example.myworktow.tab_view.Tab_view;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment4 extends Fragment implements Tab_view {

    private TabLayout fra4_tab;
    private ViewPager vp4;
    private ArrayList<Fragment> fragments;
    private Vp4 vp41;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_blank_fragment4, null);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        fra4_tab = (TabLayout) inflate.findViewById(R.id.fra4_tab);
        vp4 = (ViewPager) inflate.findViewById(R.id.vp4);
        fragments = new ArrayList<>();
        Tab_Presenterimple tab_presenterimple = new Tab_Presenterimple(new Tab_medolimple(), this);
        tab_presenterimple.getbean();
    }

    @Override
    public void seccuss(Tab_beas tab_beas) {
        if (tab_beas!=null){
            List<Tab_beas.DataBean> data = tab_beas.getData();
            for (int i = 0; i < data.size(); i++) {
                fragments.add(new BlankFragment5(data.get(i).getName()));
            }
            vp41 = new Vp4(getChildFragmentManager(), fragments, data);
            vp4.setAdapter(vp41);
            fra4_tab.setupWithViewPager(vp4);
        }
    }

    @Override
    public void filed(String mes) {

    }
}
