package com.example.samsungproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.samsungproject.Challenge;

import java.util.ArrayList;

public class UsersInteractor {
    DatabaseRepository repository;

    public UsersInteractor(Context context) {
        repository = new DatabaseRepository(context);
    }

    public boolean insertChallenge(Challenge challenge) {
        return repository.insertChallenge(challenge);
    }
    public boolean insertEvent(Event event) {
        return repository.insertEvent(event);
    }

    public ArrayList<Challenge> getChallenge() {
        return repository.getChallenges();
    }
    public ArrayList<Event> getEvents() {
        return repository.getEvents();
    }
    public boolean onCreateDay(){
        return repository.onCreateDay();
    }
public ArrayList<Event> getDaysGoals(){
        return repository.getDaysGoals();
}





    }





