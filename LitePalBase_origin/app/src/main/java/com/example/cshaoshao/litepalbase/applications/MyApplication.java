package com.example.cshaoshao.litepalbase.applications;

import android.app.Application;

import org.litepal.LitePal;

/**
 * Created by cshaoshao on 2017/6/12.
 */

public class MyApplication extends Application
{
    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);
    }
}
