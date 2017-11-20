package com.land.myfeature;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class MainActivity extends AppCompatActivity implements MyFragment.OnFragmentInteractionListener {
    private static final String TAG = "MainActivity";

    private PosDialogFragment posDialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "[onCreate] Begin");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn1 = findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewPageActivity.class);
                startActivity(intent);
            }
        });


        Button btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TabLayoutActivity.class);
                startActivity(intent);
            }
        });

        Button btn3 = findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BottomNaviBarActivity.class);
                startActivity(intent);
            }
        });

        Button button1 = findViewById(R.id.btn_main_1);
        button1.setText("ProgressDialogFragment");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                posDialogFragment = DialogFragmentHelper.showConnectProgress(getSupportFragmentManager(), "连接中。。。");
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        posDialogFragment.dismiss();
                    }
                }, 5000);
            }
        });


        Button button2 = findViewById(R.id.btn_main_2);
        button2.setText("ComfirmDialogFragment");
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                posDialogFragment = DialogFragmentHelper.showConfirmDialog(getSupportFragmentManager(),
                        "无任何渠道号！", new IDialogResultListener<Integer>() {
                            @Override
                            public void onDataResult(Integer result) {
                                switch (result) {
                                    case DialogInterface.BUTTON_POSITIVE:
                                        Log.d(TAG, "onDataResult: 点击了确认按钮");
                                        break;
                                    case DialogInterface.BUTTON_NEGATIVE:
                                        Log.d(TAG, "onDataResult: 点击了取消按钮");
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }, true, new PosDialogFragment.OnDialogCancelListener() {
                            @Override
                            public void onCancel() {
                                Log.d(TAG, "onDataResult: 取消了选择");
                            }
                        });
            }
        });


        Button button3 = findViewById(R.id.btn_main_3);
        button3.setText("ListDialogFragment");
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleList = "选择哪种方向？";
                final String[] languanges = new String[]{"Android", "iOS", "web 前端", "Web 后端", "老子不打码了"};
                DialogFragmentHelper.showListDialog(getSupportFragmentManager(), titleList, languanges, new IDialogResultListener<Integer>() {
                    @Override
                    public void onDataResult(Integer result) {
                        Log.d(TAG, "onDataResult: " + languanges[result]);
                    }
                }, true);
            }
        });

        Button button4 = findViewById(R.id.btn_main_4);
        button4.setText("DateDialogFragment");
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleDate = "请选择日期";
                Calendar calendar = Calendar.getInstance();
                DialogFragmentHelper.showDateDialog(getSupportFragmentManager(), titleDate, calendar, new IDialogResultListener<Calendar>() {
                    @Override
                    public void onDataResult(Calendar result) {
                        Log.d(TAG, "onDataResult: " +
                                result.get(GregorianCalendar.YEAR) + "年" +
                                (result.get(GregorianCalendar.MONTH) + 1) + "月" +
                                result.get(GregorianCalendar.DAY_OF_MONTH) + "日");
                    }
                }, true);
            }
        });

        Button button5 = findViewById(R.id.btn_main_5);
        button5.setText("InsertDialogFragment");
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleInsert = "请输入想输入的内容";
                DialogFragmentHelper.showInsertDialog(getSupportFragmentManager(), titleInsert, new IDialogResultListener<String>() {
                    @Override
                    public void onDataResult(String result) {
                        Log.d(TAG, "onDataResult: result" + result);
                    }
                }, true);
            }
        });


    }

    public void changeFragment() {
//        this.getSupportFragmentManager().beginTransaction()
//                .replace(R.id.container,MyFragment2.newInstance("myfrag2"),"myfrag2")
//                .addToBackStack(null)
//                .commit();
    }


    @Override
    protected void onStart() {
        Log.d(TAG, "[onStart] Begin");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "[onResume] Begin");
        super.onResume();
        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                MyFragment frag1 = (MyFragment)MainActivity.this.getSupportFragmentManager().findFragmentByTag("myfrag1");
//                frag1.setButton("btn");
//            }
//        }, 2000);


    }

    @Override
    protected void onPause() {
        Log.d(TAG, "[onPause] Begin");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "[onStop] Begin");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "[onDestroy] Begin");
        super.onDestroy();
    }


    @Override
    public void onItemClick(String str) {
        Log.d(TAG, "onItemClick: str = " + str);
    }


}
