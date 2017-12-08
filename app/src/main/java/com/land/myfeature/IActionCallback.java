package com.land.myfeature;

/**
 * 操作回调
 * <p>
 * Created by terence.wang on 17/4/14
 */

public interface IActionCallback<T> {

    /**
     * 响应操作结果
     */
    public void onActionResult(boolean isSuccessful, String errorMessage, T object);

}
