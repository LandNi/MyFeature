package com.land.myfeature.retrofit;

import android.util.Log;

import com.land.myfeature.myutils.PrintUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * com.land.myfeature.retrofit
 * Created by nikai on 2017-11-22.
 * Description:
 */

public class SaleRequest {
    private static final String TAG = "SaleRequest";

    public static void sale() {
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");

        BaseReqPack baseReqPack = new BaseReqPack();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.248.14:8020/starryPsv/")
                .addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        ISaleRequestPost iSaleRequestPost = retrofit.create(ISaleRequestPost.class);
//        Call<BaseRespPack> call = iSaleRequestPost.getSaleResult(baseReqPack);
//        call.enqueue(new Callback<BaseRespPack>() {
//            @Override
//            public void onResponse(Call<BaseRespPack> call, Response<BaseRespPack> response) {
//                BaseRespPack baseRespPack = response.body();
//
//                Log.d(TAG, "response_code:" + response.code());
//                Log.d(TAG, "response_body:" + PrintUtils.printJavaBean(baseRespPack));
//            }
//
//            @Override
//            public void onFailure(Call<BaseRespPack> call, Throwable t) {
//                Log.d(TAG, "onFailure: ",t);
//            }
//        });

        iSaleRequestPost.getSaleResult(baseReqPack)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseRespPack>() {
                    Disposable disposable;

                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(BaseRespPack baseRespPack) {

                        Log.d(TAG, "response_body:" + PrintUtils.printJavaBean(baseRespPack));
                        disposable.dispose();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onFailure: ", e);
                        disposable.dispose();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
