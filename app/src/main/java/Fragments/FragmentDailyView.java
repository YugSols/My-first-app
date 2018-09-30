/*
 * Copyright (c) by Sujoy Datta. Created on 2018. For any issues please contact sujoydatta26@gmail.com
 */

package Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ua.dailyexpensetracker.R;

import java.util.Date;

import Managers.DateManager;

public class FragmentDailyView extends Fragment {

    private View view;
    private TextView textView_today_date, textView_today_month, textView_today_day;


    public FragmentDailyView() {
        //required empty constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_daily_view, container, false);
        textView_today_date = view.findViewById(R.id.textView_today_date);
        textView_today_month = view.findViewById(R.id.textView_today_month);
        textView_today_day = view.findViewById(R.id.textView_today_day);
        setUpDate();
        return view;
    }

    @SuppressLint("SetTextI18n")
    private void setUpDate() {
        int current_date = DateManager.getDateValuesAsInt()[0];
        textView_today_date.setText(String.valueOf(current_date));

        String current_month_name = DateManager.getStringNameForMonthValue(DateManager.getDateValuesAsInt()[1]);
        int current_year = DateManager.getDateValuesAsInt()[2];

        textView_today_month.setText(current_month_name + ", " + current_year);
        textView_today_day.setText("" + DateManager.getDayNameForDate(new Date()));
    }
    public static FragmentDailyView newInstance(){
        return new FragmentDailyView();
    }
}
