package com.example.samsungproject.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.samsungproject.R;

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, null);
        String name = "Vladislav";
        String surname = "Shemarin";
        TextView nameV = v.findViewById(R.id.userName);
        TextView surnameV = v.findViewById(R.id.Surname);
        nameV.setText(name);
        surnameV.setText(surname);
        return v;
    }
}
