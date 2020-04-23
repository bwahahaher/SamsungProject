package com.example.samsungproject.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.samsungproject.Challenge;
import com.example.samsungproject.Purpose;
import com.example.samsungproject.R;


import java.util.ArrayList;


public class ChallengeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_challenge, null);
//        ArrayList<Challenge> challengeList = new ArrayList();
//        challengeList.add(new Challenge(1,2,3,"str"));
//        challengeList.add(new Challenge(2,22,32,"stdddr"));
//        RecycleAdapter adapter = new RecycleAdapter(challengeList);
//        RecyclerView purposeList = v.findViewById(R.id.challengeRecycle);
//        purposeList.setLayoutManager(new GridLayoutManager(v.getContext(), 1));
//        purposeList.setAdapter(adapter);
        ArrayList<Purpose> purpose = new ArrayList();
        purpose.add(new Purpose(1,"12 apr", "Карантин", "wait"));
        purpose.add(new Purpose(2,"12 apr", "Карантин", "wait"));
        purpose.add(new Purpose(3,"12 apr", "Карантин", "wait"));
        purpose.add(new Purpose(4,"12 apr", "Карантин", "wait"));
        purpose.add(new Purpose(5, "12 apr", "Карантин", "wait"));

        RecycleAdapter adapter = new RecycleAdapter(purpose);
        RecyclerView purposeList = v.findViewById(R.id.challengeRecycle);
        purposeList.setLayoutManager(new GridLayoutManager(v.getContext(), 1));
        return inflater.inflate(R.layout.fragment_challenge, container, false);
    }

}
