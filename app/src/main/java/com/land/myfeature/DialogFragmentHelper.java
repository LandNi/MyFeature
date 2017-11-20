package com.land.myfeature;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * com.land.myfeature
 * Created by nikai on 2017-11-17.
 * Description:
 */

public class DialogFragmentHelper {
    private static final String TAG = "DialogFragmentHelper";
    private static final String DIALOG_POSITIVE = "确定";
    private static final String DIALOG_NEGATIVE = "取消";


    /**
     * DialogFragment,显示默认/自定义 ProgressDialog
     */
    private static final int CONNECT_PROGRESS_THEME = R.style.Base_AlertDialog;
    private static final String PROGRESS_TAG = TAG + ":connect_progress";
    private static final int COMFIRM_THEME = R.style.Base_AlertDialog;
    private static final String COMFIRM_TAG = TAG + ":confirm";
    /**
     * 带列表的弹出窗
     */
    private static final int LIST_THEME = R.style.Base_AlertDialog;
    private static final String LIST_TAG = TAG + ":list";
    /**
     * 选择日期
     */
    private static final int DATE_THEME = R.style.Base_AlertDialog;
    private static final String DATE_TAG = TAG + ":date";
    /**
     * 带输入框的弹出窗
     */
    private static final int INSERT_THEME = R.style.Base_AlertDialog;
    private static final String INSERT_TAG = TAG + ":insert";

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

    public static PosDialogFragment showConfirmDialog(FragmentManager fragmentManager, final String message, final IDialogResultListener<Integer> listener,
                                                      boolean cancelable, PosDialogFragment.OnDialogCancelListener cancelListener) {
        PosDialogFragment posDialogFragment = PosDialogFragment.newInstance(new PosDialogFragment.OnCallDialog() {
            @Override
            public Dialog getDialog(Context context) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context, COMFIRM_THEME);
                builder.setMessage(message);
                builder.setPositiveButton(DIALOG_POSITIVE, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d(TAG, "onClick: which:" + which);
                        if (listener != null) {
                            listener.onDataResult(which);
                        }
                    }
                });
                builder.setNegativeButton(DIALOG_NEGATIVE, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d(TAG, "onClick: which:" + which);
                        if (listener != null) {
                            listener.onDataResult(which);
                        }
                    }
                });
                return builder.create();
            }
        }, cancelable, cancelListener);

        posDialogFragment.show(fragmentManager, COMFIRM_TAG);
        return posDialogFragment;
    }

    public static DialogFragment showListDialog(FragmentManager fragmentManager, final String title, final String[] items
            , final IDialogResultListener<Integer> resultListener, boolean cancelable) {
        PosDialogFragment posDialogFragment = PosDialogFragment.newInstance(new PosDialogFragment.OnCallDialog() {
            @Override
            public Dialog getDialog(Context context) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context, LIST_THEME);
                builder.setTitle(title);
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (resultListener != null) {
                            resultListener.onDataResult(which);
                        }
                    }
                });
                return builder.create();
            }
        }, cancelable, null);

        posDialogFragment.show(fragmentManager, LIST_TAG);
        return posDialogFragment;
    }

    public static DialogFragment showDateDialog(FragmentManager fragmentManager, final String title, final Calendar calendar
            , final IDialogResultListener<Calendar> resultListener, final boolean cancelable) {
        PosDialogFragment posDialogFragment = PosDialogFragment.newInstance(new PosDialogFragment.OnCallDialog() {
            @Override
            public Dialog getDialog(Context context) {

                final DatePickerDialog datePickerDialog = new DatePickerDialog(context, DATE_THEME, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(year, month, dayOfMonth);
                        resultListener.onDataResult(calendar);
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.setTitle(title);
                datePickerDialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialog) {
                        datePickerDialog.getButton(DialogInterface.BUTTON_POSITIVE).setText(DIALOG_POSITIVE);
                        datePickerDialog.getButton(DialogInterface.BUTTON_NEGATIVE).setText(DIALOG_NEGATIVE);
                    }
                });
                return datePickerDialog;
            }
        }, cancelable, null);
        posDialogFragment.show(fragmentManager, DATE_TAG);
        return posDialogFragment;
    }

    public static DialogFragment showInsertDialog(FragmentManager manager, final String title, final IDialogResultListener<String> resultListener, final boolean cancelable) {

        PosDialogFragment dialogFragment = PosDialogFragment.newInstance(new PosDialogFragment.OnCallDialog() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public Dialog getDialog(Context context) {
                final EditText editText = new EditText(context);
                editText.setBackground(null);
                editText.setPadding(60, 40, 0, 0);
                AlertDialog.Builder builder = new AlertDialog.Builder(context, INSERT_THEME);
                builder.setTitle(title);
                builder.setView(editText);
                builder.setPositiveButton(DIALOG_POSITIVE, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (resultListener != null) {
                            resultListener.onDataResult(editText.getText().toString());
                        }
                    }
                });
                builder.setNegativeButton(DIALOG_NEGATIVE, null);
                return builder.create();
            }
        }, cancelable, null);
        dialogFragment.show(manager, INSERT_TAG);

        return dialogFragment;
    }
}


