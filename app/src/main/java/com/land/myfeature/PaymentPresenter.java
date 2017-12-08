package com.land.myfeature;

import android.util.Log;

/**
 * com.land.myfeature
 * Created by nikai on 2017-12-07.
 * Description:
 */

public class PaymentPresenter {
    private static final String TAG = "PaymentPresenter";
    private final IPaymentView mIPaymentView;
    private final ISaleRequest mIRequest;

    public PaymentPresenter(IPaymentView mIPaymentView) {
        this.mIPaymentView = mIPaymentView;
        mIRequest = new SaleRequst1();
    }

    public void saleRequset() {
        mIPaymentView.requestLoading();
        mIRequest.sale(new IActionCallback<String>() {
            @Override
            public void onActionResult(boolean isSuccessful, String errorMessage, String object) {
                if (!isSuccessful) {
                    Log.d(TAG, errorMessage);
                    mIPaymentView.resultSuccess();
                } else {
                    Log.d(TAG, "成功：" + errorMessage);
                }
            }
        });
    }
}
