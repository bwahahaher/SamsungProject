package com.example.samsungproject;

public class Challenge {
    public int  hard, id;
    public String name, description,day;
    public int progress;

    public Challenge(int id, String day, int hard, String name, String description, int progress) {
        this.day = day;
        this.hard = hard;
        this.id = id;
        this.name = name;
        this.progress = progress;
        this.description=description;
    }
}
