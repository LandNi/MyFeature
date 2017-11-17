package com.land.myfeature;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.land.myfeature.myutils.MyCountDownTimer;

/**
 * com.land.myfeature
 * Created by nikai on 2017-11-17.
 * Description:
 */

public class PosProgressDialog extends ProgressDialog {

    private static final String TAG = "PosProgressDialog";

    private TextView tvCdt;
    private MyCountDownTimer myCountDownTimer;
    private String cdtDisplayStr;

    public PosProgressDialog(Context context) {
        super(context);
    }

    public PosProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_dialog);

        tvCdt = findViewById(R.id.tv_load_dialog_cdt);

        myCountDownTimer = new MyCountDownTimer(5 * 1000 + 1050, 1000);
        myCountDownTimer.setCdtAction(new MyCountDownTimer.CdtAction() {
            @Override
            public void tickAction(long millisUntilFinished) {
                cdtDisplayStr = (millisUntilFinished / 1000 - 1) + "秒";
                tvCdt.setText(cdtDisplayStr);
                Log.d(TAG, "tickAction: -1");
            }

            @Override
            public void finishAcion() {
            }
        });


        myCountDownTimer.start();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        myCountDownTimer.cancel();
        Log.d(TAG, "onStop: invoke");
    }
}
