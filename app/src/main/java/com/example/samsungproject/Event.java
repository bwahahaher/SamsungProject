package com.example.samsungproject;

import java.util.ArrayList;

public class Event {
    public String name, descr;
    public int imp, hard, deadline, id, frequency;
    public Event(int id, String name, String descr, int imp, int hard, int deadline, int frequency) {
        this.name = name;
        this.id=id;
        this.descr = descr;
        this.imp = imp;
        this.hard = hard;
        this.deadline = deadline;
        this.frequency = frequency;
    }

    public Event(int parseInt, int parseInt1, int parseInt2, String string, String string1) {
    }
}
