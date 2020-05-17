package com.example.samsungproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DatabaseRepository {
    DatabaseHelper databaseHelper;

    public DatabaseRepository(Context context) {
        initDb(context);
    }

    private void initDb(Context context) {
        databaseHelper = new DatabaseHelper(context, "UserDb", null, 1);
    }

    public boolean insertChallenge(Challenge challenge) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.execSQL(SQLScripts.insertChallenge(challenge));

        return true;
    }
    public boolean insertEvent(Event event) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        String name, descr;
        int imp, hard, deadline, frequency;
        name = event.name;
        descr = event.descr;
        deadline = event.deadline;
        frequency = event.frequency;
        db.execSQL("insert into event" +
                "(often, deadline, name, description )" +
                "values" +
                "(" + frequency +","+  deadline +","+  name+","+  descr +
                ");");

        return true;
    }
    public ArrayList<Challenge> getChallenges() {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        Cursor userCursor = db.rawQuery(SQLScripts.getChallenges(), null);
        // Cтавим позицию курсора на первую строку выборки
        // Eсли в выборке нет строк, вернется false
        if (userCursor.moveToFirst()) {
            // определяем номера столбцов по имени в выборке
            int idColIndex = userCursor.getColumnIndex("id");
            int nameColIndex = userCursor.getColumnIndex("name");
            int hardColIndex = userCursor.getColumnIndex("day");
            int dayColIndex = userCursor.getColumnIndex("hard");
            int descriptionColIndex = userCursor.getColumnIndex("description");

            ArrayList<Challenge> ChallengeList = new ArrayList();
            do {
                // получаем значения по номерам столбцов
                Challenge user = new Challenge(Integer.parseInt(userCursor.getString(idColIndex)),
                        Integer.parseInt(userCursor.getString(hardColIndex)),
                        Integer.parseInt(userCursor.getString(dayColIndex)),
                        userCursor.getString(nameColIndex),
                        userCursor.getString(descriptionColIndex));
                ChallengeList.add(user);
                // переход на следующую строку
                // а если следующей нет (текущая - последняя), то false - выходим из цикла
            } while (userCursor.moveToNext());
            userCursor.close();
            return ChallengeList;
        } else {
            userCursor.close();
            return null;
        }
    }
    public ArrayList<Event> getEvents() {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        Cursor userCursor = db.rawQuery(SQLScripts.getAllEvents(), null);
//        // Cтавим позицию курсора на первую строку выборки
//        // Eсли в выборке нет строк, вернется false
        if (userCursor.moveToFirst()) {
            // определяем номера столбцов по имени в выборке
            int idColIndex = userCursor.getColumnIndex("id");
            int nameColIndex = userCursor.getColumnIndex("name");
            int hardColIndex = userCursor.getColumnIndex("often");
            int dayColIndex = userCursor.getColumnIndex("deadline");
            int descriptionColIndex = userCursor.getColumnIndex("description");

            ArrayList<Event> ChallengeList = new ArrayList();
            do {
                // получаем значения по номерам столбцов
                Event user = new Event(Integer.parseInt(userCursor.getString(idColIndex)),
                        Integer.parseInt(userCursor.getString(hardColIndex)),
                        Integer.parseInt(userCursor.getString(dayColIndex)),
                        userCursor.getString(nameColIndex),
                        userCursor.getString(descriptionColIndex));
                ChallengeList.add(user);
                // переход на следующую строку
                // а если следующей нет (текущая - последняя), то false - выходим из цикла
            } while (userCursor.moveToNext());
            userCursor.close();
            return ChallengeList;
        } else {
            userCursor.close();
            return null;
        }
    }
    public boolean onCreateDay(){
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.execSQL("create table myDay(id integer primary key autoincrement, name text not null, isDo bool not null default 0, " +
                "description text, deadline text)");
        return true;
    }
    public ArrayList<Event> getDaysGoals() {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        Cursor userCursor = db.rawQuery(SQLScripts.getAllEvents(), null);
//        // Cтавим позицию курсора на первую строку выборки
//        // Eсли в выборке нет строк, вернется false
        if (userCursor.moveToFirst()) {
            // определяем номера столбцов по имени в выборке
            int idColIndex = userCursor.getColumnIndex("id");
            int nameColIndex = userCursor.getColumnIndex("name");
            int hardColIndex = userCursor.getColumnIndex("often");
            int dayColIndex = userCursor.getColumnIndex("deadline");
            int descriptionColIndex = userCursor.getColumnIndex("description");

            ArrayList<Event> ChallengeList = new ArrayList();
            do {
                // получаем значения по номерам столбцов
                Event user = new Event(Integer.parseInt(userCursor.getString(idColIndex)),
                        Integer.parseInt(userCursor.getString(hardColIndex)),
                        Integer.parseInt(userCursor.getString(dayColIndex)),
                        userCursor.getString(nameColIndex),
                        userCursor.getString(descriptionColIndex));
                ChallengeList.add(user);
                // переход на следующую строку
                // а если следующей нет (текущая - последняя), то false - выходим из цикла
            } while (userCursor.moveToNext());
            userCursor.close();
            return ChallengeList;
        } else {
            userCursor.close();
            return null;
        }
    }
    }


