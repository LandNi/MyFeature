package com.land.myfeature;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

/**
 * com.land.myfeature
 * Created by nikai on 2017-11-15.
 * Description:
 */

public class PosDialogFragment extends DialogFragment {

    private static final String TAG = "MyDialogFragment";

    /**
     * 回调获得需要显示的 dialog
     */
    private OnCallDialog mOnCallDialog;

    /**
     * 监听弹出窗是否被取消
     */
    private OnDialogCancelListener mCancelListener;


    public static PosDialogFragment newInstance(OnCallDialog callDialog, boolean cancelable) {
        return newInstance(callDialog, cancelable, null);
    }

    public static PosDialogFragment newInstance(OnCallDialog callDialog, boolean cancelable, OnDialogCancelListener cancelListener) {
        PosDialogFragment intance = new PosDialogFragment();
        intance.mOnCallDialog = callDialog;
        intance.mCancelListener = cancelListener;
        intance.setCancelable(cancelable);
        return intance;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if (null == mOnCallDialog) {
            super.onCreate(savedInstanceState);
        }
        return mOnCallDialog.getDialog(getActivity());
    }


    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {

            // 在 5.0 以下的版本会出现白色背景边框，若在 5.0 以上设置则会造成文字部分的背景也变成透明
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
                // 目前只有这两个 dialog 会出现边框
                if (dialog instanceof ProgressDialog || dialog instanceof DatePickerDialog) {
                    getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                }
            }

            Window window = getDialog().getWindow();
            WindowManager.LayoutParams windowParams = window.getAttributes();
            windowParams.dimAmount = 0.0f;
            window.setAttributes(windowParams);
        }
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        Log.d(TAG, "onCancel: Dialog canceled");
        if (mCancelListener != null) {
            mCancelListener.onCancel();
        }
    }


    @Override
    public void dismiss() {
        super.dismiss();
        Log.d(TAG, "dismiss: invoke");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: invoke");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: invoke");
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        Log.d(TAG, "onDismiss: invoke");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach: invoke");
    }

    public interface OnDialogCancelListener {
        void onCancel();
    }


    public interface OnCallDialog {
        Dialog getDialog(Context context);
    }
}
