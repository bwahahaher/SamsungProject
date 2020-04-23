package com.example.samsungproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.samsungproject.fragments.AddGoalsFragment;
import com.example.samsungproject.fragments.CalendarFragment;
import com.example.samsungproject.fragments.ChallengeFragment;
import com.example.samsungproject.fragments.MainFragment;
import com.example.samsungproject.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fragment (View view){
        Fragment fragment1 = null;
        TextView t;
        t=findViewById(R.id.header);
        switch (view.getId()){
            case R.id.calendar:
                fragment1=new CalendarFragment();
                t.setText("Будущие цели");
                break;
            case R.id.main:
                fragment1=new MainFragment();
                t.setText("Главная");
                break;
            case R.id.profile:
                fragment1 = new ProfileFragment();
                t.setText("Профиль");
                break;
            case R.id.challenge:
                fragment1 = new ChallengeFragment();
                t.setText("Челленджи");
                break;
            case R.id.new_act:
                fragment1 = new AddGoalsFragment();
                t.setText("Добавить");
                break;

        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment, fragment1);
        ft.commit();


    }
}
