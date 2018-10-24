/*
 * Created by Sujoy Datta. Copyright (c) 2018. All rights reserved.
 *
 * To the person who is reading this..
 * When you finally understand how this works, please do explain it to me too at sujoydatta26@gmail.com
 * P.S.: In case you are planning to use this without mentioning me, you will be met with mean judgemental looks and sarcastic comments.
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
import android.widget.ImageView;
import android.widget.TextView;

import com.ua.dailyexpensetracker.R;

import java.util.Calendar;

import Managers.ConstantsManager;

public class FragmentYearlyView extends Fragment {
    private static final String TAG = "FragmentYearlyView";

    private View view;
    private TextView yearlyview_today_year;
    private ImageView icon_next_year, icon_prev_year;

    private int increment_count;

    public FragmentYearlyView() {

    }

    public static FragmentYearlyView newInstance() {
        FragmentYearlyView fragmentYearlyView = new FragmentYearlyView();
        return fragmentYearlyView;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_yearly_view, container, false);

        yearlyview_today_year = view.findViewById(R.id.yearlyView_textView_today_month);
        icon_next_year = view.findViewById(R.id.icon_next_calendar_year);
        icon_prev_year = view.findViewById(R.id.icon_prev_calender_year);

        setUpDate();

        increment_count = 0;

        icon_next_year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpDate(increment_count += 1);
            }
        });

        icon_prev_year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpDate(increment_count -= 1);
            }
        });
        return view;
    }

    @SuppressLint("SetTextI18n")
    private void setUpDate(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, i);

        int year = calendar.get(Calendar.YEAR);
        yearlyview_today_year.setText("" + year);
    }

    @SuppressLint("SetTextI18n")
    private void setUpDate() {
        int year = ConstantsManager.CURRENT_YEAR;
        yearlyview_today_year.setText("" + year);
    }


}
