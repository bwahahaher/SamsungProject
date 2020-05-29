package com.example.samsungproject.fragments;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.samsungproject.Challenge;

import com.example.samsungproject.DBHelper;
import com.example.samsungproject.R;


import java.util.ArrayList;


public class ChallengeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        DBHelper dbHelper = new DBHelper(getContext());
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        View v = inflater.inflate(R.layout.fragment_challenge, null);
        ArrayList<Challenge> challengeList = new ArrayList();
        Cursor cursor = database.query("Challenges", null, null, null, null, null, null);

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



        RecycleAdapter adapter = new RecycleAdapter(challengeList);
        RecyclerView purposeList = v.findViewById(R.id.challengeRecycle);
        purposeList.setLayoutManager(new GridLayoutManager(v.getContext(), 1));
        purposeList.setAdapter(adapter);
        return v;
    }



}
