package com.land.myfeature.myutils;

import android.os.CountDownTimer;

/**
 * Created by LAND on 2017-07-08.
 */

public class MyCountDownTimer extends CountDownTimer {

    private CdtAction mCdtAction;

    public MyCountDownTimer(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    public void setCdtAction(CdtAction cdtAction) {
        mCdtAction = cdtAction;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        mCdtAction.tickAction(millisUntilFinished);
    }

    @Override
    public void onFinish() {
        mCdtAction.finishAcion();
    }


    public interface CdtAction {
        void tickAction(long millisUntilFinished);

        void finishAcion();
    }

}
