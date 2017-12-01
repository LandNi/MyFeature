package com.land.myfeature.myutils;

import android.util.Log;

import com.land.myfeature.BuildConfig;


/**
 * Created by nikai on 2017-05-10.
 */

public class LogUtils {

    public static final int VERBOSE = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
    public static final int WARN = 4;
    public static final int ERROR = 5;
    public static final int NOTHING = 6;

    public static final int level = VERBOSE;//此处设定日志打印等级


    public static void v(String tag, String msg) {
        if (BuildConfig.LOG_DEBUG) {
            if (level <= VERBOSE) {
                Log.v(tag, msg);
            }
        }

    }

    public static void d(String tag, String msg) {
        if (BuildConfig.LOG_DEBUG) {
            if (level <= DEBUG) {
                Log.d(tag, msg);
            }
        }

    }

    public static void i(String tag, String msg) {
        if (BuildConfig.LOG_DEBUG) {
            if (level <= INFO) {
                Log.i(tag, msg);
            }
        }
    }

    public static void w(String tag, String msg) {
        if (BuildConfig.LOG_DEBUG) {
            if (level <= WARN) {
                Log.w(tag, msg);
            }
        }
    }

    public static void e(String tag, String msg) {
        if (BuildConfig.LOG_DEBUG) {
            if (level <= ERROR) {
                Log.e(tag, msg);
            }
        }
    }


    public static void v(String tag, String msg, Throwable e) {
        if (BuildConfig.LOG_DEBUG) {
            if (level <= VERBOSE) {
                Log.v(tag, msg, e);
            }
        }

    }

    public static void d(String tag, String msg, Throwable e) {
        if (BuildConfig.LOG_DEBUG) {
            if (level <= DEBUG) {
                Log.d(tag, msg, e);
            }
        }

    }

    public static void i(String tag, String msg, Throwable e) {
        if (BuildConfig.LOG_DEBUG) {
            if (level <= INFO) {
                Log.i(tag, msg, e);
            }
        }
    }

    public static void w(String tag, String msg, Throwable e) {
        if (BuildConfig.LOG_DEBUG) {
            if (level <= WARN) {
                Log.w(tag, msg, e);
            }
        }
    }

    public static void e(String tag, String msg, Throwable e) {
        if (BuildConfig.LOG_DEBUG) {
            if (level <= ERROR) {
                Log.e(tag, msg, e);
            }
        }
    }
}
