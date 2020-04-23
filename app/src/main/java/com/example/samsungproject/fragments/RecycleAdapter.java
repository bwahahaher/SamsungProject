package com.example.samsungproject.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.samsungproject.Challenge;
import com.example.samsungproject.Challenge;
import com.example.samsungproject.R;

import java.util.ArrayList;

class RecycleAdapter extends RecyclerView.Adapter<ContactVH> {
    final ArrayList<Challenge> challengeList;

    public RecycleAdapter(ArrayList<Challenge> challenges) {
        this.challengeList = challenges;
    }


    @NonNull
    @Override
    public ContactVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View contactView = LayoutInflater.from(parent.getContext()).inflate(R.layout.challenge_view, parent, false);
        return new ContactVH(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactVH holder, int position) {
        Challenge challenge = challengeList.get(position);
        holder.bind(challenge);
    }

    @Override
    public int getItemCount() {
        return challengeList.size();
    }
}

class ContactVH extends RecyclerView.ViewHolder {
    TextView name, duration, hard;

    public ContactVH(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        duration = itemView.findViewById(R.id.duration);
        hard = itemView.findViewById(R.id.hard);

    }

    public void bind(Challenge challenge) {
        name.setText("test");
        duration.setText("ksnd");
        hard.setText("dasdasdas");
    }
}