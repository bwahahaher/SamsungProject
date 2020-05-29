package com.example.samsungproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.samsungproject.fragments.AddGoalsFragment;
import com.example.samsungproject.fragments.CalendarFragment;
import com.example.samsungproject.fragments.ChallengeFragment;
import com.example.samsungproject.fragments.MainFragment;
import com.example.samsungproject.fragments.ProfileFragment;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton mainButton = findViewById(R.id.mainButton);
        setImg(mainButton);
        Fragment fragment1=new MainFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment, fragment1);
//        ft.commit();
//        DBHelper dbHelper;
//        dbHelper = new DBHelper(this);
//        SQLiteDatabase database = dbHelper.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        dbHelper.onUpgrade(database, 2,3);
    }


    public void fragment (View view){
        Fragment fragment1 = null;
        TextView t;
        t=findViewById(R.id.header);
        ImageButton calendar = findViewById(R.id.calendar);
        ImageButton mainButton = findViewById(R.id.mainButton);
        ImageButton challenge = findViewById(R.id.challenge);
        ImageButton add = findViewById(R.id.createChallenge);
        switch (view.getId()){
            case R.id.calendar:
                fragment1=new CalendarFragment();
                t.setText("Календарь");
                setImg(calendar);
                add.setVisibility(View.GONE);
                break;
            case R.id.mainButton:
                fragment1=new MainFragment();
                t.setText("Мой день");
                setImg(mainButton);
                add.setVisibility(View.GONE);
                break;
            case R.id.challenge:
                fragment1 = new ChallengeFragment();
                t.setText("Мои челленджи");
                setImg(challenge);
                add.setVisibility(View.VISIBLE);
                challenge.setImageResource(R.drawable.fire);
                break;
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment, fragment1);
        ft.commit();


    }
    public void newChallenge (View view){
        Intent newChallenge = new Intent(this, addChallenge.class);
        startActivity(newChallenge);

    }
    public void setImg(ImageButton btn){
        ImageButton calendar = findViewById(R.id.calendar);
        ImageButton mainButton = findViewById(R.id.mainButton);
        ImageButton challenge = findViewById(R.id.challenge);
        calendar.setColorFilter(ContextCompat.getColor(this, R.color.black), android.graphics.PorterDuff.Mode.MULTIPLY);
        mainButton.setColorFilter(ContextCompat.getColor(this, R.color.black), android.graphics.PorterDuff.Mode.MULTIPLY);
        btn.setColorFilter(ContextCompat.getColor(this, R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
        challenge.setImageResource(R.drawable.fire2);
    }
}
