/*
 * Copyright (c) by Sujoy Datta. Created on 2018. For any issues please contact sujoydatta26@gmail.com
 */

package Fragments;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ua.dailyexpensetracker.R;

import java.util.Calendar;
import java.util.Date;

import Managers.ConstantsManager;
import Managers.DateManager;

public class FragmentDailyView extends Fragment {

    private static final String TAG = "FragmentDailyView";
    private View view;
    private TextView textView_today_date, textView_today_month, textView_today_day;
    private LinearLayout linearLayout_pick_date;
    private ImageView icon_prev, icon_next;

    private int increment_count;

    public FragmentDailyView() {
        //required empty constructor
    }

    public static FragmentDailyView newInstance() {
        return new FragmentDailyView();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_daily_view, container, false);
        textView_today_date = view.findViewById(R.id.textView_today_date);
        textView_today_month = view.findViewById(R.id.textView_today_month);
        textView_today_day = view.findViewById(R.id.textView_today_day);
        linearLayout_pick_date = view.findViewById(R.id.linearLayout_pick_date);
        icon_prev = view.findViewById(R.id.icon_prev_calender);
        icon_next = view.findViewById(R.id.icon_next_calendar);

        increment_count = 0;

        //setting up the date values in the top tab
        setUpDate();

        linearLayout_pick_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickDate();
            }
        });

        icon_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpDate(increment_count -= 1);
            }
        });

        icon_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpDate(increment_count += 1);
            }
        });

        return view;
    }

    private void pickDate() {
        int mYear = ConstantsManager.CURRENT_YEAR;
        int mMonth = ConstantsManager.CURRENT_MONTH;
        int mDay = ConstantsManager.CURRENT_DATE;
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Toast.makeText(getContext(), "Picking dates...", Toast.LENGTH_SHORT).show();
                setUpDate(year, month, dayOfMonth);
            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    @SuppressLint("SetTextI18n")
    private void setUpDate() {
        int current_date = ConstantsManager.CURRENT_DATE;
        textView_today_date.setText(String.valueOf(current_date));

        String current_month_name = DateManager.getStringNameForMonthValue(ConstantsManager.CURRENT_MONTH);
        int current_year = ConstantsManager.CURRENT_YEAR;
        textView_today_month.setText(current_month_name + ", " + current_year);

        textView_today_day.setText("" + DateManager.getDayNameForDate(new Date()));
    }

    @SuppressLint("SetTextI18n")
    private void setUpDate(int value) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, value);
        Date nextDate = calendar.getTime();

        textView_today_date.setText(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
        String current_month_name = DateManager.getStringNameForMonthValue(calendar.get(Calendar.MONTH) + 1);
        int current_year = calendar.get(Calendar.YEAR);
        textView_today_month.setText(current_month_name + ", " + current_year);
        textView_today_day.setText("" + DateManager.getDayNameForIntValue(calendar.get(Calendar.DAY_OF_WEEK)));
    }

    @SuppressLint("SetTextI18n")
    private void setUpDate(int year, int month, int date) {
        textView_today_date.setText(String.valueOf(date));
        String current_month_name = DateManager.getStringNameForMonthValue(month);
        textView_today_month.setText(current_month_name + ", " + year);
        textView_today_day.setText("" + DateManager.getDayNameForIntValue(date));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
