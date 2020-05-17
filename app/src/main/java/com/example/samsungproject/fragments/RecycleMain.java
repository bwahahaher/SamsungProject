package com.example.samsungproject.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.samsungproject.Challenge;
import com.example.samsungproject.Challenge;
import com.example.samsungproject.ChallengeInfo;
import com.example.samsungproject.Event;
import com.example.samsungproject.MainActivity;
import com.example.samsungproject.R;

import java.util.ArrayList;

public class RecycleMain extends RecyclerView.Adapter<EventVH> {
    final ArrayList<MainFragment.EventView> eventList;

    public RecycleMain(ArrayList<MainFragment.EventView> userList) {
        this.eventList = userList;
    }


    @NonNull
    @Override
    public EventVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View contactView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_view, parent, false);
        return new EventVH(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull EventVH holder, int position) {
        MainFragment.EventView event = eventList.get(position);
        holder.bind(event);
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
}
class EventVH extends RecyclerView.ViewHolder {
    CheckBox check;
    TextView eventName;
    ImageView image;

    public EventVH(@NonNull View itemView) {
        super(itemView);
        check = itemView.findViewById(R.id.checkBox);
        eventName = itemView.findViewById(R.id.eventName);
        image = itemView.findViewById(R.id.ImageStat);


    }

    public void bind(final MainFragment.EventView event) {
        eventName.setText(event.name);
        check.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            public void onClick(View v) {
                //смена статуса в бд
                eventName.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                check.setChecked(true);
                eventName.setTextColor(R.color.colorAccent);
                image.setColorFilter(ContextCompat.getColor(v.getContext(), R.color.black), android.graphics.PorterDuff.Mode.MULTIPLY);  }
        });

        if (event.stat == "challenge") {
            image.setImageResource(R.drawable.fire);
        } else if (event.stat == "event") {
            image.setImageResource(R.drawable.goals);
        }
    }
}

