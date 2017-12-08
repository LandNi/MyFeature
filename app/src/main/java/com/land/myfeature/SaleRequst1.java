package com.land.myfeature;

import com.land.myfeature.retrofit.BaseReqPack;
import com.land.myfeature.retrofit.BaseRespPack;
import com.land.myfeature.retrofit.ExceptionHandle;
import com.land.myfeature.retrofit.FastJsonConverterFactory;
import com.land.myfeature.retrofit.ISaleRequestPost;
import com.land.myfeature.retrofit.OkHttpUtils;
import com.land.myfeature.rxjava2.BaseObserver;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * com.land.myfeature
 * Created by nikai on 2017-12-07.
 * Description:
 */

public class SaleRequst1 implements ISaleRequest {
    private static final String TAG = "SaleRequst1";

    @Override
    public void sale(final IActionCallback<String> callback) {
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
                        callback.onActionResult(false, baseRespPack.getResponseMessage(), null);
                        disposable.dispose();
                    }

                    @Override
                    public void onError(Throwable e) {
                        ExceptionHandle.ResponeThrowable ex = super.handleError(e);
                        callback.onActionResult(false, ex.message + ex.code, null);
                        disposable.dispose();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
