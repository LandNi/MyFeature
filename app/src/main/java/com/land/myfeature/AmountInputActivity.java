package com.land.myfeature;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class AmountInputActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount_input);
        initInputAmountView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_pay_return:
                onBackPressed();
                break;
            default:
                break;

        }
    }


    private void initInputAmountView() {
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

        TextView tvAmount = findViewById(R.id.tv_pay_amount);

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

        tvAmount.setText(R.string.defalut_amount);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
