package com.example.demo9.base;

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
        initmvp();
        initview(inflate);
        initdata();
        initlistenner();
        return inflate;
    }

    protected void initmvp() {

    }

    protected void initlistenner() {

    }

    protected void initdata() {

    }

    protected void initview(View inflate) {

    }

    protected abstract int getLayoutID();
}
