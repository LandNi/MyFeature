package com.land.myfeature.retrofit;

import com.land.myfeature.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * com.land.myfeature.retrofit
 * Created by nikai on 2017-11-28.
 * Description:
 */

public class OkHttpUtils {

    //SECONDS
    private final static long CONNECT_TIMEOUT_MILLISEC = 100L;
    private final static long READ_TIMEOUT_MILLISEC = 30L;
    private final static long WRITE_TIMEOUT_MILLISEC = 30L;

    private OkHttpClient mOkHttpClient;


    private OkHttpUtils() {
        initHttpClient();
    }

    public static final OkHttpUtils getInstance() {
        return OkHttpUtilsHolder.INSTANCE;
    }

    public OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }

    private void initHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(CONNECT_TIMEOUT_MILLISEC, TimeUnit.SECONDS);
        builder.connectTimeout(READ_TIMEOUT_MILLISEC, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(generateInterceptor());
        }

        mOkHttpClient = builder.build();
    }


    private HttpLoggingInterceptor generateInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    private static class OkHttpUtilsHolder {
        private static final OkHttpUtils INSTANCE = new OkHttpUtils();
    }


}
