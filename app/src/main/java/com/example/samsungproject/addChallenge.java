package com.example.samsungproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.MultiAutoCompleteTextView;

public class addChallenge extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_challenge);


    }
    public void backButton(View view){
        super.onBackPressed();  // optional depending on your needs


    }
    public void add(View view){
        MultiAutoCompleteTextView descr = findViewById(R.id.descr);
        EditText name, day, hard;
        name =findViewById(R.id.name);
        day = findViewById(R.id.day);
        hard = findViewById(R.id.hard);

//        UsersInteractor usersInteractor;
//        usersInteractor = new UsersInteractor(this);
//        usersInteractor.insertChallenge(new Challenge(1,7,3,name.getText().toString(), descr.getText().toString()));

    }
}
