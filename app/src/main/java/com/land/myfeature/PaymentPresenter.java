package com.land.myfeature;

import android.util.Log;

import com.land.myfeature.mvp.AbstractMvpPersenter;

/**
 * com.land.myfeature
 * Created by nikai on 2017-12-07.
 * Description:
 */

public class PaymentPresenter extends AbstractMvpPersenter<IPaymentView> {
    private static final String TAG = "PaymentPresenter";
    private final ISaleRequest mIRequest;

    public PaymentPresenter() {
        mIRequest = new SaleRequst1();
    }

    public void saleRequset() {
        getMvpView().requestLoading();
        mIRequest.sale(new IActionCallback<String>() {
            @Override
            public void onActionResult(boolean isSuccessful, String errorMessage, String object) {
                if (!isSuccessful) {
                    Log.d(TAG, errorMessage);
                    getMvpView().resultSuccess();
                } else {
                    Log.d(TAG, "成功：" + errorMessage);
                }
            }
        });
    }
}
