package com.land.myfeature.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * com.land.myfeature.mvp
 * Created by nikai on 2017-12-12.
 * Description:
 */

public abstract class AbstractMvpActivity<V extends IMvpBaseView, P extends AbstractMvpPersenter<V>>
        extends AppCompatActivity implements IMvpBaseView {
    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mPresenter == null) {
            mPresenter = creatPresenter();
        }

        if (mPresenter == null) {
            throw new NullPointerException("presenter 不能为空!");
        }
        //绑定view
        mPresenter.attachMvpView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除绑定
        if (mPresenter != null) {
            mPresenter.detachMvpView();
        }
    }

    /**
     * 创建Presenter
     *
     * @return 子类自己需要的Presenter
     */
    protected abstract P creatPresenter();

    /**
     * 获取Presenter
     *
     * @return 返回子类创建的Presenter
     */
    public P getPresenter() {
        return mPresenter;
    }

}
