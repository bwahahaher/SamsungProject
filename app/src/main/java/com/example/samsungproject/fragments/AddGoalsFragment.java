package com.example.samsungproject.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.samsungproject.ChallengeInfo;
import com.example.samsungproject.R;
import com.example.samsungproject.longread;
import com.example.samsungproject.twodaysrule;
import com.example.samsungproject.usachevlongread;

public class AddGoalsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_blank, null);
        Button btn1 = v.findViewById(R.id.button);
        Button btn2 = v.findViewById(R.id.button2);
        Button btn3 = v.findViewById(R.id.button3);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent addActIntent = new Intent(getContext(), twodaysrule.class);
                getContext().startActivity(addActIntent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent addActIntent = new Intent(getContext(), longread.class);
                getContext().startActivity(addActIntent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent addActIntent = new Intent(getContext(), usachevlongread.class);
                getContext().startActivity(addActIntent);
            }
        });
        return v;
    }

}
