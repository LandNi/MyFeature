package com.land.myfeature;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class ViewPageActivity extends AppCompatActivity implements MyFragment.OnFragmentInteractionListener {
    private static final String TAG = "ViewPageActivity";

    private ViewPager viewPager;  //对应的viewPager

    private RadioGroup radioGroup;
    private RadioButton rbSale, rbTrans, rbManage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);
        initView();
    }


    private void initView() {
        radioGroup = findViewById(R.id.radioGroup);
        rbSale = findViewById(R.id.rb_sale);
        rbTrans = findViewById(R.id.rb_trans);
        rbManage = findViewById(R.id.rb_manage);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
                switch (checkId) {
                    case R.id.rb_sale:
                        viewPager.setCurrentItem(0, false);
                        break;
                    case R.id.rb_trans:
                        viewPager.setCurrentItem(1, false);
                        break;
                    case R.id.rb_manage:
                        viewPager.setCurrentItem(2, false);
                        break;
                    default:
                        break;
                }
            }
        });


        viewPager = findViewById(R.id.viewPager);

        MyFragment saleFragment = MyFragment.newInstance("Sale Fragment");
        MyFragment2 transFragment = MyFragment2.newInstance("Trans Fragment");
        MyFragment3 manageFragment = MyFragment3.newInstance("Manage Fragment");

        List<Fragment> alFragment = new ArrayList<>();
        alFragment.add(saleFragment);
        alFragment.add(transFragment);
        alFragment.add(manageFragment);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(new PosFragmentPagerAdapter(getSupportFragmentManager(), alFragment));
        viewPager.setCurrentItem(0);

        //TODO 优化滑动问题，放开手指后滑动过快
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radioGroup.check(R.id.rb_sale);
                        break;
                    case 1:
                        radioGroup.check(R.id.rb_trans);
                        break;
                    case 2:
                        radioGroup.check(R.id.rb_manage);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onItemClick(String str) {
        Log.d(TAG, "onItemClick: String" + str);
    }
}