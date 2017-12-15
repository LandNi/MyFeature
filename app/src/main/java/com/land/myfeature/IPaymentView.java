package com.land.myfeature;

import com.land.myfeature.mvp.IMvpBaseView;

/**
 * com.land.myfeature
 * Created by nikai on 2017-12-07.
 * Description:
 */

public interface IPaymentView extends IMvpBaseView {
    //请求服务器
    void requestLoading();

    //返回结果
    void resultSuccess();

    //结束交易
    void finishPayment();
}
