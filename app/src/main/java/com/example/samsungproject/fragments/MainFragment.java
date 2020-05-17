package com.example.samsungproject.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.samsungproject.Challenge;
import com.example.samsungproject.Event;
import com.example.samsungproject.R;
import com.example.samsungproject.UsersInteractor;

import java.util.ArrayList;


public class MainFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, null);
        ArrayList<Event> a = new ArrayList();
        ArrayList<Challenge> challengeList = new ArrayList();
        //Получение из БД, пока что исскуственно
        for (int te=0; te<15; te++) {
            a.add(new Event(1, "namenamenamenamenamenamenamename", "descr", 1, 2, 2, 3));
            challengeList.add(new Challenge(1, 2, 3, "cnamenamenamenameh", "descr"));
        }
        ArrayList<EventView> eventView = new ArrayList<EventView>();
        for(Event x: a){
            eventView.add(new EventView((x.name), "event"));
        }
        for(Challenge b: challengeList){
            eventView.add(new EventView((b.name), "challenge"));
        }
        RecycleMain adapter = new RecycleMain(eventView);
        RecyclerView purposeList = v.findViewById(R.id.recycle);
        purposeList.setLayoutManager(new GridLayoutManager(v.getContext(), 1));
        purposeList.setAdapter(adapter);

        return v;
    }
    public class EventView{
        String name, stat;
        public EventView(String name, String stat){
            this.name = name;
            this.stat=stat;
        }

    }


}
