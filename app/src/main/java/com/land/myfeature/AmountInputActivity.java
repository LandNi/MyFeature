package com.land.myfeature;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.land.myfeature.myutils.LogUtils;
import com.land.myfeature.myutils.MySoundPool;

public class AmountInputActivity extends AppCompatActivity implements View.OnClickListener, IPaymentView {

    private static final String TAG = "AmountInputActivity";
    private static final String DELETE_KEY_VALUE = "del";
    //最大长度包含￥ 和 小数点 及其他数字
    private static final int MAX_INPUT_KEY_COUNT = 14;
    private SparseArray<String> btnAmount;
    private String strDisplayAmount;
    private TextView tvAmount;
    private PaymentPresenter mPaymentPresenter;
    private PosDialogFragment posDialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount_input);
        initInputAmountView();
        mPaymentPresenter = new PaymentPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_pay_return:
                onBackPressed();
                break;
            case R.id.btn_pay_number_1:
            case R.id.btn_pay_number_2:
            case R.id.btn_pay_number_3:
            case R.id.btn_pay_number_4:
            case R.id.btn_pay_number_5:
            case R.id.btn_pay_number_6:
            case R.id.btn_pay_number_7:
            case R.id.btn_pay_number_8:
            case R.id.btn_pay_number_9:
            case R.id.btn_pay_number_0:
            case R.id.btn_pay_point:
                MySoundPool.getInstance().playKeyPressStandard();
                LogUtils.d(TAG, "Pressed Key = " + btnAmount.get(v.getId()));
                pressAmountKey(btnAmount.get(v.getId()));
                break;
            case R.id.btn_pay_del:
                MySoundPool.getInstance().palyKeyPressDelete();
                pressAmountKey(btnAmount.get(v.getId()));
                break;

            case R.id.btn_pay_homeloan:
                mPaymentPresenter.saleRequset();
                break;
            default:
                break;

        }
    }


    private void initInputAmountView() {
        btnAmount = new SparseArray<>();
        ImageButton btnReturn = findViewById(R.id.btn_pay_return);
        Button btnNumber1 = findViewById(R.id.btn_pay_number_1);
        Button btnNumber2 = findViewById(R.id.btn_pay_number_2);
        Button btnNumber3 = findViewById(R.id.btn_pay_number_3);
        Button btnNumber4 = findViewById(R.id.btn_pay_number_4);
        Button btnNumber5 = findViewById(R.id.btn_pay_number_5);
        Button btnNumber6 = findViewById(R.id.btn_pay_number_6);
        Button btnNumber7 = findViewById(R.id.btn_pay_number_7);
        Button btnNumber8 = findViewById(R.id.btn_pay_number_8);
        Button btnNumber9 = findViewById(R.id.btn_pay_number_9);
        Button btnNumber0 = findViewById(R.id.btn_pay_number_0);
        Button btnPoint = findViewById(R.id.btn_pay_point);
        ImageButton btnDelet = findViewById(R.id.btn_pay_del);

        tvAmount = findViewById(R.id.tv_pay_amount);

        btnReturn.setOnClickListener(this);
        btnNumber1.setOnClickListener(this);
        btnNumber2.setOnClickListener(this);
        btnNumber3.setOnClickListener(this);
        btnNumber4.setOnClickListener(this);
        btnNumber5.setOnClickListener(this);
        btnNumber6.setOnClickListener(this);
        btnNumber7.setOnClickListener(this);
        btnNumber8.setOnClickListener(this);
        btnNumber9.setOnClickListener(this);
        btnNumber0.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btnDelet.setOnClickListener(this);

        btnAmount.put(R.id.btn_pay_number_1, "1");
        btnAmount.put(R.id.btn_pay_number_2, "2");
        btnAmount.put(R.id.btn_pay_number_3, "3");
        btnAmount.put(R.id.btn_pay_number_4, "4");
        btnAmount.put(R.id.btn_pay_number_5, "5");
        btnAmount.put(R.id.btn_pay_number_6, "6");
        btnAmount.put(R.id.btn_pay_number_7, "7");
        btnAmount.put(R.id.btn_pay_number_8, "8");
        btnAmount.put(R.id.btn_pay_number_9, "9");
        btnAmount.put(R.id.btn_pay_number_0, "0");
        btnAmount.put(R.id.btn_pay_point, ".");
        btnAmount.put(R.id.btn_pay_del, DELETE_KEY_VALUE);

        strDisplayAmount = this.getResources().getString(R.string.defalut_amount);
        tvAmount.setText(R.string.defalut_amount);


        Button btnPay = findViewById(R.id.btn_pay_homeloan);
        btnPay.setOnClickListener(this);

    }

    private void pressAmountKey(String inputKey) {
        if (TextUtils.isEmpty(inputKey) || ".".equals(inputKey)) {
            LogUtils.d(TAG, "Press Invalid Key");
            return;
        }

        if (DELETE_KEY_VALUE.equals(inputKey)) {
            String strTmpAmount = strDisplayAmount.substring(1, strDisplayAmount.length() - 1);
            LogUtils.d(TAG, "strTmpAmount:" + strTmpAmount);


            strTmpAmount = getMoneyString(strTmpAmount);
            LogUtils.d(TAG, "strTmpAmount:" + strTmpAmount);
            strDisplayAmount = "￥" + strTmpAmount;

            tvAmount.setText(strDisplayAmount);
        } else {

            if (tvAmount.length() >= MAX_INPUT_KEY_COUNT) {
                LogUtils.d(TAG, "Press Key Count Out");
            } else {
                String strTmpAmount = strDisplayAmount.substring(1) + inputKey;
                LogUtils.d(TAG, "strTmpAmount:" + strTmpAmount);


                strTmpAmount = getMoneyString(strTmpAmount);
                LogUtils.d(TAG, "strTmpAmount:" + strTmpAmount);
                strDisplayAmount = "￥" + strTmpAmount;

                tvAmount.setText(strDisplayAmount);
            }

        }


    }

    //定义一个处理字符串的方法
    private String getMoneyString(String money) {
        if (money.substring(money.length() - 1).equals(".")) {
            return money.substring(0, money.length() - 1);
        }
        String overMoney = "";//结果
        String[] pointBoth = money.split("\\.");//分隔点前点后
        String beginOne = pointBoth[0].substring(pointBoth[0].length() - 1);//前一位
        String endOne = pointBoth[1].substring(0, 1);//后一位
        //小数点前一位前面的字符串，小数点后一位后面
        String beginPoint = pointBoth[0].substring(0, pointBoth[0].length() - 1);
        String endPoint = pointBoth[1].substring(1);
        //根据输入输出拼点
        if (pointBoth[1].length() > 2) {//说明输入，小数点要往右移
            overMoney = pointBoth[0] + endOne + "." + endPoint;//拼接实现右移动
        } else if (
                pointBoth[1].length() < 2) {//说明回退,小数点左移
            overMoney = beginPoint + "." + beginOne + pointBoth[1];//拼接实现左移
        } else {
            overMoney = money;
        }
        //去除点前面的0 或者补 0
        String overLeft = overMoney.substring(0, overMoney.indexOf("."));//得到前面的字符串
        if (overLeft == null || overLeft == "" || overLeft.length() < 1) {//如果没有就补零
            overMoney = "0" + overMoney;
        } else if (overLeft.length() > 1 && "0".equals(overLeft.subSequence(0, 1))) {//如果前面有俩个零
            overMoney = overMoney.substring(1);//去第一个0
        }
        return overMoney;
    }

    @Override
    public void requestLoading() {
        posDialogFragment = DialogFragmentHelper.showConnectProgress(getSupportFragmentManager(), "连接中。。。");
    }

    @Override
    public void resultSuccess() {
        posDialogFragment.dismiss();
        Toast.makeText(this, "消费失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void finishPayment() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
