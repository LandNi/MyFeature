package com.land.myfeature;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements MyFragment.OnFragmentInteractionListener {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "[onCreate] Begin");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if(savedInstanceState == null){
//            this.getSupportFragmentManager().beginTransaction()
//                    .add(R.id.container,MyFragment.newInstance("myfrag1"),"myfrag1")
//                    .commit();
//        }


        Button button = (Button)findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ViewPageActivity.class);
                startActivity(intent);
            }
        });
    }

    public void changeFragment(){
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
        Log.d(TAG, "onItemClick: str = "+ str);
    }



}
