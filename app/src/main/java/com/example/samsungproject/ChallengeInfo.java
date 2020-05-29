package com.example.samsungproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ChallengeInfo extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Intent getIntent = getIntent();
        String name = getIntent.getStringExtra("name");
        String description = getIntent.getStringExtra("descr");
        String day = getIntent.getStringExtra("day");
        int hard = getIntent.getIntExtra("hard", R.drawable.three);
        int id = getIntent.getIntExtra("id", 3);
        int progress = getIntent.getIntExtra("progress", 1);
        TextView nameView = findViewById(R.id.nameLayout);
        nameView.setText(name);
        TextView descr = findViewById(R.id.descr);
        descr.setText("Описание: "+description);
        ImageView imgHard = findViewById(R.id.imgHard);
        imgHard.setImageResource(hard);
        TextView days = findViewById(R.id.deadline);
        days.setText(day);
        TextView prog = findViewById(R.id.progress);
        prog.setText("Прогресс: "+progress);


    }
    public void backButton(View view){
        super.onBackPressed();  // optional depending on your needs


    }

}
