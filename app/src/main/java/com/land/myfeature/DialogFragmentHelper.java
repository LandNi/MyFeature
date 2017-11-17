package com.land.myfeature;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.v4.app.FragmentManager;

/**
 * com.land.myfeature
 * Created by nikai on 2017-11-17.
 * Description:
 */

public class DialogFragmentHelper {
    private static final String TAG = "DialogFragmentHelper";


    /**
     * DialogFragment,显示默认/自定义 ProgressDialog
     */
    private static final int CONNECT_PROGRESS_THEME = R.style.Base_AlertDialog;
    private static final String PROGRESS_TAG = TAG + ":connect_progress";


    public static PosDialogFragment showConnectProgress(FragmentManager fragmentManager, String message) {
        return showConnectProgress(fragmentManager, message, false);
    }


    public static PosDialogFragment showConnectProgress(FragmentManager fragmentManager, final String message, boolean cancelable) {
        PosDialogFragment posDialogFragment = PosDialogFragment.newInstance(new PosDialogFragment.OnCallDialog() {
            @Override
            public Dialog getDialog(Context context) {
                ProgressDialog progressDialog = new ProgressDialog(context, CONNECT_PROGRESS_THEME);
                progressDialog.setMessage(message);
                return progressDialog;

//                PosProgressDialog progressDialog = new PosProgressDialog(context, CONNECT_PROGRESS_THEME);
//                progressDialog.setMessage(message);
//                return progressDialog;

            }
        }, cancelable);

        posDialogFragment.show(fragmentManager, PROGRESS_TAG);
        return posDialogFragment;
    }


}
