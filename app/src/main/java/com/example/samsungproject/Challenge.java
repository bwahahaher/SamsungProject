package com.example.samsungproject;

public class Challenge {
    public int day, hard, id;
    public String name, description;
    public Challenge(int id, int day, int hard,  String name, String description) {
        this.day = day;
        this.hard = hard;
        this.id = id;
        this.name = name;
        this.description=description;
    }
}
