/*
 * Created by Sujoy Datta. Copyright (c) 2018. All rights reserved.
 *
 * To the person who is reading this..
 * When you finally understand how this works, please do explain it to me too at sujoydatta26@gmail.com
 * P.S.: In case you are planning to use this without mentioning me, you will be met with mean judgemental looks and sarcastic comments.
 */

package Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ua.dailyexpensetracker.R;

import java.util.Calendar;
import java.util.Date;

import Managers.ConstantsManager;
import Managers.DateManager;

public class FragmentMonthlyView extends Fragment {

    private static final String TAG = "FragmentMonthlyView";
    private View view;
    private TextView textView_monthlyview_today_month;
    private ImageView prev_calendar_month, next_calendar_month;

    private int increment_count = 0;

    public FragmentMonthlyView() {
        //empty constructor required
    }

    public static FragmentMonthlyView newInstance() {
        return new FragmentMonthlyView();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_monthly_view, container, false);

        textView_monthlyview_today_month = view.findViewById(R.id.monthlyView_textView_today_month);
        prev_calendar_month = view.findViewById(R.id.icon_prev_calender_month);
        next_calendar_month = view.findViewById(R.id.icon_next_calendar_month);

        increment_count = 0;

        setUpDate();

        prev_calendar_month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpDate(increment_count -= 1);
            }
        });

        next_calendar_month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpDate(increment_count += 1);
            }
        });

        return view;
    }

    private void setUpDate() {
        String current_month = DateManager.getStringNameForMonthValue(ConstantsManager.CURRENT_MONTH);
        int year = ConstantsManager.CURRENT_YEAR;
        String month_and_year = current_month + " , " + year;
        textView_monthlyview_today_month.setText(month_and_year);
    }

    private void setUpDate(int value) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, value);
        Date nextDate = calendar.getTime();

        String current_month = DateManager.getStringNameForMonthValue(calendar.get(Calendar.MONTH) + 1);
        int year = calendar.get(Calendar.YEAR);
        String month_and_year = current_month + " , " + year;

        textView_monthlyview_today_month.setText(month_and_year);
    }

}
