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
public class MyFragment3 extends Fragment {
    private static final String TAG = "MyFragment3";
    private static String ARG_PARAM = "param_key";
    private String mParam;
    private Activity mActivity;

    @Override
    public void onAttach(Context context) {
        Log.d(TAG, "[onAttach] Begin");
        super.onAttach(context);
        mActivity = (Activity)context;
        mParam = getArguments().getString(ARG_PARAM);
        Log.d(TAG, "onAttach: mParam = " + mParam);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG, "[onCreateView] Begin");
        View rootView = inflater.inflate(R.layout.fragment_my2, container, false);
        TextView tv = rootView.findViewById(R.id.tv_myfragment_2);
        tv.setText(mParam);
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

    public static MyFragment3 newInstance(String str){
        Log.d(TAG, "MyFragment Instance has be created!");
        MyFragment3 myFragment = new MyFragment3();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM,str);
        myFragment.setArguments(bundle);
        return myFragment;
    }

}
