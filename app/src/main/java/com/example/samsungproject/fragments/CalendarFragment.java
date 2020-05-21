package com.example.samsungproject.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.samsungproject.Challenge;
import com.example.samsungproject.Event;
import com.example.samsungproject.R;
import com.example.samsungproject.UsersInteractor;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarListener;


public class CalendarFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_calendar, null);
        HorizontalCalendar horizontalCalendar;

        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        horizontalCalendar = new HorizontalCalendar.Builder(v.getRootView(), R.id.calendarView)
                .startDate(startDate.getTime())
                .endDate(endDate.getTime())
                .datesNumberOnScreen(5)
                .dayNameFormat("EEE")
                .dayNumberFormat("dd")
                .monthFormat("MMM")
                .textSize(24f, 24f, 0f)
                .showDayName(true)
                .showMonthName(true)

                .build();

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Date date, int position) {
                String d;
                d = DateFormat.getDateInstance().format(date);
                ArrayList<Event> challengeList = new ArrayList();
                challengeList.add(new Event(1,"1,7","3",3, 3, 2, 3));
                challengeList.add(new Event(1,"1,7","3",3, 3, 2, 3));
                CalendarAdapter adapter = new CalendarAdapter(challengeList);
                RecyclerView purposeList = v.findViewById(R.id.rec);
                purposeList.setLayoutManager(new GridLayoutManager(v.getContext(), 1));
                purposeList.setAdapter(adapter);
            }

        });

        return v;
    }

}
