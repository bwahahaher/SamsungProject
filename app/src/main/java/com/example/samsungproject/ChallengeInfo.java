package com.example.samsungproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.example.samsungproject.fragments.ChallengeFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ChallengeInfo extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Intent getIntent = getIntent();
        String name = getIntent.getStringExtra("name");
        String description = getIntent.getStringExtra("descr");
        int hard = getIntent.getIntExtra("hard", 3);
        int id = getIntent.getIntExtra("id", 3);
        int day = getIntent.getIntExtra("day", 3);
        Challenge challenge  = new Challenge(id,day,hard, name, description);
        TextView nameView = findViewById(R.id.name);
        nameView.setText(challenge.name);
        TextView hardView = findViewById(R.id.hard);
        hardView.setText(hardView.getText() + "" + challenge.hard);
        TextView days = findViewById(R.id.deadline);
        days.setText(days.getText() + "" + challenge.day + "дней");


    }
    public void backButton(View view){
        super.onBackPressed();  // optional depending on your needs


    }

}
