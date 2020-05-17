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
import com.example.samsungproject.UsersInteractor;


import java.util.ArrayList;


public class ChallengeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_challenge, null);
        ArrayList<Challenge> challengeList = new ArrayList();
        challengeList.add(new Challenge(1,2,3,"name", "descr"));
        challengeList.add(new Challenge(1,2,3,"name", "descr"));
        challengeList.add(new Challenge(1,2,3,"name", "descr"));



        RecycleAdapter adapter = new RecycleAdapter(challengeList);
        RecyclerView purposeList = v.findViewById(R.id.challengeRecycle);
        purposeList.setLayoutManager(new GridLayoutManager(v.getContext(), 1));
        purposeList.setAdapter(adapter);
        return v;
    }



}
