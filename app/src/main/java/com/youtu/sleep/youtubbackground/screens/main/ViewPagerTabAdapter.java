package com.youtu.sleep.youtubbackground.screens.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by DaiPhongPC on 7/31/2018.
 */

public class ViewPagerTabAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFragments;

    public ViewPagerTabAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position) == null ? null : mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
