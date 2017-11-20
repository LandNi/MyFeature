package com.land.myfeature;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity implements MyFragment.OnFragmentInteractionListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private List<Fragment> list;
    private MyAdapter adapter;
    private String[] titles = {"收款", "流水", "管理"};
    private int[] images = {R.drawable.icon_sale_selector, R.drawable.icon_trans_selector, R.drawable.icon_manage_selector};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        viewPager = findViewById(R.id.viewpager1);
        tabLayout = findViewById(R.id.tablayout);

        list = new ArrayList<>();
        list.add(MyFragment.newInstance("sale_frag"));
        list.add(MyFragment2.newInstance("sale_frag"));
        list.add(MyFragment3.newInstance("sale_frag"));

        adapter = new MyAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(adapter.getTabView(i));
        }
    }

    @Override
    public void onItemClick(String str) {

    }

    class MyAdapter extends FragmentPagerAdapter {

        private Context context;

        public MyAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        public View getTabView(int position) {
            View v = LayoutInflater.from(context).inflate(R.layout.tab_custom, null);
            TextView textView = v.findViewById(R.id.tv_title);
            ImageView imageView = v.findViewById(R.id.iv_icon);
            textView.setText(titles[position]);
            imageView.setImageResource(images[position]);
            textView.setTextColor(tabLayout.getTabTextColors());
            return v;
        }
    }
}
