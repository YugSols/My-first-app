/*
 * Copyright (c) by Sujoy Datta. Created on 2018. For any issues please contact sujoydatta26@gmail.com
 */

package Adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import Fragments.FragmentDailyView;
import Fragments.FragmentMonthlyView;
import Fragments.FragmentYearlyView;

public class MainActivityViewPagerAdapter extends FragmentStatePagerAdapter {

    private static String PAGE_TITLES[] = {"DAILY","MONTHLY","YEARLY"};
    public MainActivityViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return FragmentDailyView.newInstance();
            case 1:
                return FragmentMonthlyView.newInstance();
            case 2:
                return FragmentYearlyView.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return PAGE_TITLES[position];
    }
}
