package com.example.samsungproject.fragments;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.samsungproject.Challenge;
import com.example.samsungproject.Challenge;
import com.example.samsungproject.ChallengeInfo;
import com.example.samsungproject.Event;
import com.example.samsungproject.MainActivity;
import com.example.samsungproject.R;

import java.util.ArrayList;

public class CalendarAdapter extends RecyclerView.Adapter<EventHelp> {
    final ArrayList<Event> challengeList;

    public CalendarAdapter(ArrayList<Event> userList) {
        this.challengeList = userList;
    }


    @NonNull
    @Override
    public EventHelp onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View contactView = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_view, parent, false);
        return new EventHelp(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull EventHelp holder, int position) {
        Event challenge = challengeList.get(position);
        holder.bind(challenge);
    }

    @Override
    public int getItemCount() {
        return challengeList.size();
    }
}

class EventHelp extends RecyclerView.ViewHolder {
    TextView name, duration, hard;
    Button btn;

    public EventHelp(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.eventName);
        duration = itemView.findViewById(R.id.deadline);


    }
    public void bind(final Event challenge) {
        name.setText(challenge.name);
        duration.setText(challenge.descr);
        }
    }
