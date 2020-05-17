package com.example.samsungproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context,
                          String name,
                          SQLiteDatabase.CursorFactory factory,
                          int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table challenges(" +
                "id integer primary key autoincrement, hard integer not null, day integer," +
                "name text not null," +
                "description text," + "stat boolean"+
                ");");
        db.execSQL("create table event(id integer primary key autoincrement, name text not null, isDo bool not null default 0, " +
                "description text, deadline text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }


}