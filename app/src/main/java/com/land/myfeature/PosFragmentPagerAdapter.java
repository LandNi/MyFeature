package com.land.myfeature;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * com.land.myfeature
 * Created by nikai on 2017-11-13.
 * Description:
 */

public class PosFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;


    public PosFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
