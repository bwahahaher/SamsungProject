package com.example.samsungproject.fragments;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.samsungproject.Challenge;
import com.example.samsungproject.ChallengeInfo;
import com.example.samsungproject.R;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<ContactVH> {
    final ArrayList<Challenge> challengeList;

    public RecycleAdapter(ArrayList<Challenge> userList) {
        this.challengeList = userList;
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
    TextView name, duration;
    ImageView hard;
    Button btn;

    public ContactVH(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.nameLayout);
        duration = itemView.findViewById(R.id.duration);
        hard = itemView.findViewById(R.id.hard);
        btn=itemView.findViewById(R.id.challBut);

    }

    public void bind(final Challenge challenge) {
        name.setText(challenge.name);
        duration.setText(challenge.day);
        hard.setImageResource(challenge.hard);


        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent addActIntent = new Intent(v.getContext(), ChallengeInfo.class);
                addActIntent.putExtra( "id", challenge.id);
                addActIntent.putExtra( "day", challenge.day);
                addActIntent.putExtra( "hard", challenge.hard);
                addActIntent.putExtra( "name", challenge.name);
                addActIntent.putExtra( "descr", challenge.description);
                addActIntent.putExtra( "progress", challenge.progress);
                v.getContext().startActivity(addActIntent);
            }
        });
    }
}
