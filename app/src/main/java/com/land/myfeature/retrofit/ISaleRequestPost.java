package com.land.myfeature.retrofit;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * com.land.myfeature.retrofit
 * Created by nikai on 2017-11-21.
 * Description:
 */

public interface ISaleRequestPost {
    @POST("txn/txn-consume")
    Observable<BaseRespPack> getSaleResult(@Body BaseReqPack baseReqPack);
}
