package com.example.demo9.base;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseMedol {

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();
    public void clear() {
        compositeDisposable.clear();
    }
}
