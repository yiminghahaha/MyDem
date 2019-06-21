package com.example.myactivity.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutID(), null);
        ButterKnife.bind(this,inflate);
        initMVP();
        initdata();
        initview(inflate);
        listenner();
        return inflate;
    }

    protected void listenner() {

    }

    protected void initview(View inflate) {

    }

    protected void initdata() {

    }

    protected void initMVP() {

    }

    protected abstract int getLayoutID();

}
