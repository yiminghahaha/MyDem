package com.example.demo1;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

public class App extends Application {
    private static  App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static App getApp() {
        return app;
    }
}
