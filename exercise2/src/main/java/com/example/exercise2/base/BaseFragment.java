package com.example.exercise2.base;

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
        View inflate = inflater.inflate(getinflater(), null);
        ButterKnife.bind(this,inflate);
        MVP();
        initview(inflate);
        initdata();
        listenner();
        return inflate;
    }

    protected void listenner() {

    }

    protected void initdata() {

    }

    protected void initview(View inflate) {

    }

    protected void MVP() {

    }

    protected abstract int getinflater();
}
