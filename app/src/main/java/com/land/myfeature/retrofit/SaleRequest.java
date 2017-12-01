package com.land.myfeature.retrofit;

import android.util.Log;

import com.land.myfeature.rxjava2.BaseObserver;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
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

        BaseReqPack baseReqPack = new BaseReqPack();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.248.14:8020/starryPsv/")
//                .baseUrl("https://wallet.redstarpay.com/starryPsv/")
                .client(OkHttpUtils.getInstance().getOkHttpClient())
                .addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        ISaleRequestPost iSaleRequestPost = retrofit.create(ISaleRequestPost.class);

        iSaleRequestPost.getSaleResult(baseReqPack)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<BaseRespPack>() {
                    Disposable disposable;

                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(BaseRespPack baseRespPack) {
                        disposable.dispose();
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.handleError(e);
                        Log.d(TAG, "onFailure: ", e);

                        disposable.dispose();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
