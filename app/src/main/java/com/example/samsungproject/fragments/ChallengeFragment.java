package com.example.samsungproject.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.samsungproject.Challenge;

import com.example.samsungproject.R;


import java.util.ArrayList;


public class ChallengeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_challenge, null);
        ArrayList<Challenge> challengeList = new ArrayList();
        String descr1 = "Холодный душ не только бодрит, но и обладает удивительными полезными свойствами, которые положительно влияют на весь организм.\n" +
                "AdMe.ru собрал целых 10 причин, почему вам следует начать приниать холодный душ уже сегодня." +
         "Откладывать деньги каждый день очень важно влияют на весь организм.\n" +
                "Холодный душ не только бодрит, но и обладает удивительными полезными свойствами, которые положительно влияют на весь организм.\n" +
                "AdMe.ru собрал целых 10 причин, почему вам следует начать приниать холодный душ уже сегодня.";
        String descr2 = "Откладывать деньги каждый день очень важно влияют на весь организм.\n" +
                "AdMe.ru собрал целых 10 причин, почему вам следует начать принимать холодный душ уже сегодня.";
        challengeList.add(new Challenge(1,30,3,"Холодный душ", descr1));
        challengeList.add(new Challenge(2,7,3,"Копить деньги", descr2));
        challengeList.add(new Challenge(1,30,3,"Холодный душ", descr1));
        challengeList.add(new Challenge(2,7,3,"Копить деньги", descr2));
        challengeList.add(new Challenge(1,30,3,"Холодный душ", descr1));
        challengeList.add(new Challenge(2,7,3,"Копить деньги", descr2));
        challengeList.add(new Challenge(1,30,3,"Холодный душ", descr1));
        challengeList.add(new Challenge(2,7,3,"Копить деньги", descr2));
        challengeList.add(new Challenge(1,30,3,"Холодный душ", descr1));
        challengeList.add(new Challenge(2,7,3,"Копить деньги", descr2));
        challengeList.add(new Challenge(1,30,3,"Холодный душ", descr1));
        challengeList.add(new Challenge(2,7,3,"Копить деньги", descr2));
        challengeList.add(new Challenge(1,30,3,"Холодный душ", descr1));
        challengeList.add(new Challenge(2,7,3,"Копить деньги", descr2));
        challengeList.add(new Challenge(1,30,3,"Холодный душ", descr1));
        challengeList.add(new Challenge(2,7,3,"Копить деньги", descr2));
        challengeList.add(new Challenge(1,30,3,"Холодный душ", descr1));
        challengeList.add(new Challenge(2,7,3,"Копить деньги", descr2));

        RecycleAdapter adapter = new RecycleAdapter(challengeList);
        RecyclerView purposeList = v.findViewById(R.id.challengeRecycle);
        purposeList.setLayoutManager(new GridLayoutManager(v.getContext(), 1));
        purposeList.setAdapter(adapter);
        return v;
    }



}
