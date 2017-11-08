package com.land.myfeature.myutils;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * com.land.myfeature.myutils
 * Created by nikai on 2017-11-07.
 * Description:
 */

public class DeviceUtils {
        public static int getDeviceScreenHeigthPixels(Activity activity){
            WindowManager manager = activity.getWindowManager();
            DisplayMetrics outMetrics = new DisplayMetrics();
            manager.getDefaultDisplay().getMetrics(outMetrics);
            return outMetrics.heightPixels;
        }

    public static int getDeviceScreenWidthPixels(Activity activity){
        WindowManager manager = activity.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    public static int getDeviceScreenDpi(Activity activity){
        WindowManager manager = activity.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.densityDpi;
    }

}
