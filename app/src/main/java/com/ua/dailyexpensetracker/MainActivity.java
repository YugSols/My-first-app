/*
 * Copyright (c) by Sujoy Datta. Created on 2018. For any issues please contact sujoydatta26@gmail.com
 */

package com.ua.dailyexpensetracker;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import Adapters.MainActivityViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "Entered OnCreate View of MainActivity");

        viewPager = findViewById(R.id.main_activity_viewpager);
        MainActivityViewPagerAdapter mainActivityViewPagerAdapter = new MainActivityViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mainActivityViewPagerAdapter);
        viewPager.setOffscreenPageLimit(2);
    }
}
