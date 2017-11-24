package com.land.myfeature.rxjava2;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * com.land.myfeature.rxjava2
 * Created by nikai on 2017-11-23.
 * Description:
 */

public class Rxjava2Demo {
    private static final String TAG = "Rxjava2Demo";

    public static void demoOne() {
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.d(TAG, "currentThread-Name:" + Thread.currentThread().getName());
                Log.d(TAG, "subscribe: emitter.onNext1");
                emitter.onNext(1);
                Log.d(TAG, "subscribe: emitter.onNext2");
                emitter.onNext(2);
                Log.d(TAG, "subscribe: emitter.onNext3");
                emitter.onNext(3);
                Log.d(TAG, "subscribe: emitter.onComplete");
                emitter.onComplete();
            }
        });

        Observer<Integer> observer = new Observer<Integer>() {
            private Disposable mDisposable;

            @Override
            public void onSubscribe(Disposable disposable) {
                Log.d(TAG, Thread.currentThread().getName());
                Log.d(TAG, "onSubscribe: ");
                mDisposable = disposable;
            }

            @Override
            public void onNext(Integer integer) {

                Log.d(TAG, "onNext: " + integer);
                Log.d(TAG, "isDisposed : " + mDisposable.isDisposed());
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
                mDisposable.dispose();
                Log.d(TAG, "isDisposed : " + mDisposable.isDisposed());
            }
        };


        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

    public static void demoTwo() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.d(TAG, "subscribe: emitter.onNext1");
                emitter.onNext(1);
                Log.d(TAG, "subscribe: emitter.onNext2");
                emitter.onNext(2);
                Log.d(TAG, "subscribe: emitter.onNext3");
                emitter.onNext(3);
                Log.d(TAG, "subscribe: emitter.onComplete");
                emitter.onComplete();
            }
        }).subscribe(new Observer<Integer>() {
            private Disposable mDisposable;

            @Override
            public void onSubscribe(Disposable disposable) {
                Log.d(TAG, "onSubscribe: ");
                mDisposable = disposable;
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "onNext: " + integer);
                Log.d(TAG, "isDisposed : " + mDisposable.isDisposed());
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
                mDisposable.dispose();
                Log.d(TAG, "isDisposed : " + mDisposable.isDisposed());
            }
        });
    }

}
