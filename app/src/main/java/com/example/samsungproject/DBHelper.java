package com.example.samsungproject;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "contactDb";
    public static final String TABLE_CONTACTS = "contacts";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_MAIL = "mail";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Challenges (id integer primary key, name text not null, hard integer, long text not null, descr text, progress text)");
        db.execSQL("create table Events (id integer primary key, name text not null, day text, time text, rate text)");
        db.execSQL("create table MyDay (id integer primary key, name text not null, stat integer not null, time text)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Challenges;");
        db.execSQL("drop table if exists Events;");
        db.execSQL("drop table if exists MyDay;");

        onCreate(db);

    }
}