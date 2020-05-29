package com.example.samsungproject.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.samsungproject.Challenge;
import com.example.samsungproject.DBHelper;
import com.example.samsungproject.Event;
import com.example.samsungproject.R;
import com.example.samsungproject.newdayplan;

import java.util.ArrayList;


public class MainFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, null);
        Button btn = v.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent addActIntent = new Intent(getContext(), newdayplan.class);
                getContext().startActivity(addActIntent);
            }
        });
        ArrayList<Challenge> a = new ArrayList();
        //Получение из БД, пока что исскуственно
        DBHelper dbHelper = new DBHelper(getContext());
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ArrayList<Challenge> challengeList = new ArrayList();
        Cursor cursor = database.query("MyDay", null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex("id");
            int nameIndex = cursor.getColumnIndex("name");
            int timeIndex = cursor.getColumnIndex("time");
            int statIndex = cursor.getColumnIndex("stat");
            do {
                int id = cursor.getInt(idIndex);
                String time =  cursor.getString(timeIndex);
                String name =  cursor.getString(nameIndex);
                int stat = cursor.getInt(statIndex);
                a.add(new Challenge(id,time,stat, name, "descr", 1));

            } while (cursor.moveToNext());
        }



        cursor = database.query("Challenges", null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex("id");
            int nameIndex = cursor.getColumnIndex("name");
            int hardIndex = cursor.getColumnIndex("hard");
            int longIndex = cursor.getColumnIndex("long");
            int descrIndex = cursor.getColumnIndex("descr");
            int proIndex = cursor.getColumnIndex("progress");
            do {
                int id = cursor.getInt(idIndex);
                String lon =  cursor.getString(longIndex);
                int hard =  cursor.getInt(hardIndex);
                String descr =  cursor.getString(descrIndex);
                String name =  cursor.getString(nameIndex);
                int progress =  cursor.getInt(proIndex);
                challengeList.add(new Challenge(id,lon,hard, name, descr, progress));

            } while (cursor.moveToNext());
        }

        cursor.close();
        ArrayList<EventView> eventView = new ArrayList<EventView>();
        for(Challenge x: a){
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
