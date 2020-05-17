package com.example.samsungproject;

public  class SQLScripts {
    public static String insertChallenge(Challenge challenge) {
        int day, hard, id;
        String name, description;
        day = challenge.day;
        hard = challenge.hard;
        name = "\"" + challenge.name + "\"";
        description = "\"" + challenge.description + "\"";
        return "insert into cha llenges" +
                "( hard, day, name, description )" +
                "values" +
                "(" + hard +","+  day +","+  name+","+  description +
                ");";
//        return "delete from challenges";

    }

    public static String getChallenges() {
        return "select * from challenges;";
    }
    public static String getAllEvents() {
        return "select * from event;";
    }


}