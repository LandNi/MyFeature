package com.land.myfeature.rxjava2;

import android.util.Log;

import com.land.myfeature.retrofit.BaseRespPack;
import com.land.myfeature.retrofit.ExceptionHandle;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * com.land.myfeature.rxjava2
 * Created by nikai on 2017-11-28.
 * Description:
 */

public abstract class BaseObserver<T extends BaseRespPack> implements Observer<T> {
    private static final String TAG = "BaseObserver";

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {

    }

    public ExceptionHandle.ResponeThrowable handleError(Throwable e) {
        ExceptionHandle.ResponeThrowable ex = ExceptionHandle.handleException(e);
        Log.d(TAG, "e.code = " + ex.code + "|e.String = " + ex.message);
        return ex;
    }

    @Override
    public void onComplete() {

    }


}
