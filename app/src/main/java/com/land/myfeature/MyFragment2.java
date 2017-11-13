package com.land.myfeature;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment2 extends Fragment {
    private static final String TAG = "MyFragment2";
    private static String ARG_PARAM = "param_key";
    private String mParam;
    private Activity mActivity;

    private boolean mIsInited;
    private boolean mIsPrepared;

    private TextView tv;

    public static MyFragment2 newInstance(String str) {
        Log.d(TAG, "MyFragment Instance has be created!");
        MyFragment2 myFragment = new MyFragment2();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM, str);
        myFragment.setArguments(bundle);
        return myFragment;
    }

    @Override
    public void onAttach(Context context) {
        Log.d(TAG, "[onAttach] Begin");
        super.onAttach(context);
        mActivity = (Activity)context;
        mParam = getArguments().getString(ARG_PARAM);
        Log.d(TAG, "onAttach: mParam = " + mParam);
    }

    public void lazyLoad() {
        if (getUserVisibleHint() && mIsPrepared && !mIsInited) {
            //异步初始化，在初始化后显示正常UI
            loadData();
        }
    }

    private void loadData() {
        new Thread() {
            public void run() {
                //1. 加载数据
                //2. 更新UI
                //3. mIsInited = true
                mActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText(mParam + "加载ing");
                    }
                });


                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                mActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText(mParam + "加载完毕");
                    }
                });

                mIsInited = true;
            }
        }.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG, "[onCreateView] Begin");
        View rootView = inflater.inflate(R.layout.fragment_my2, container, false);
        tv = rootView.findViewById(R.id.tv_myfragment_2);
        mIsPrepared = true;
        lazyLoad();
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "[onCreate] Begin");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d(TAG, "[onStart] Begin");
        super.onStart();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            lazyLoad();
        }
    }

    @Override
    public void onResume() {
        Log.d(TAG, "[onResume] Begin");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d(TAG, "[onPause] Begin");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d(TAG, "[onStop] Begin");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "[onDestroyView] Begin");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "[onDestroy] Begin");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d(TAG, "[onDetach] Begin");
        super.onDetach();
    }
}
