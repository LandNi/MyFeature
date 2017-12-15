package com.land.myfeature.mvp;

/**
 * com.land.myfeature.mvp
 * Created by nikai on 2017-12-12.
 * Description: 指定绑定的View必须继承自IMvpBaseView
 */

public abstract class AbstractMvpPersenter<V extends IMvpBaseView> {
    private V mMvpView;

    /**
     * 绑定V层
     *
     * @param view
     */
    public void attachMvpView(V view) {
        this.mMvpView = view;
    }

    /**
     * 解除绑定V层
     */
    public void detachMvpView() {
        mMvpView = null;
    }


    /**
     * 获取V层
     *
     * @return mMvpView
     */
    public V getMvpView() {
        return mMvpView;
    }
}
