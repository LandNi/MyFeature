package com.land.myfeature;

import android.app.Application;
import android.content.Context;

/**
 * com.land.myfeature
 * Created by nikai on 2017-12-01.
 * Description:
 */

public class BaseApplication extends Application {
    private static Context context;

    //返回
    public static Context getContextObject() {
        return context;
    }

    @Override
    public void onCreate() {
        //获取Context
        super.onCreate();
        context = getApplicationContext();
    }
}
