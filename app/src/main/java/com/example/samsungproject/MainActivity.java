package com.example.samsungproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
        int fire1 = R.drawable.fire;
        int fire2 = R.drawable.fire2;
        int goals1 = R.drawable.goals;
        int add2 = R.drawable.add2;
        int add1 = R.drawable.add1;
        int goals2 = R.drawable.goals2;
        int profile1 = R.drawable.profileimg1;
        int profile2 = R.drawable.profileimg2;
        int home1 = R.drawable.home1;
        int home2 = R.drawable.home2;
        ImageButton calendar = findViewById(R.id.calendar);
        ImageButton mainButton = findViewById(R.id.mainButton);
        ImageButton profile = findViewById(R.id.profile);
        ImageButton challenge = findViewById(R.id.challenge);
        ImageButton new_act = findViewById(R.id.new_act);


        switch (view.getId()){
            case R.id.calendar:
                fragment1=new CalendarFragment();
                t.setText("Будущие цели");
                setImg(calendar, goals1);
                break;
            case R.id.mainButton:
                fragment1=new MainFragment();
                t.setText("Главная");
                setImg(mainButton, home1);
                break;
            case R.id.profile:
                fragment1 = new ProfileFragment();
                t.setText("Профиль");
                setImg(profile, profile1);
                break;
            case R.id.challenge:
                fragment1 = new ChallengeFragment();
                t.setText("Челленджи");
                setImg(challenge, fire1);
                break;
            case R.id.new_act:
                fragment1 = new AddGoalsFragment();
                t.setText("Добавить");
                setImg(new_act, add1);
                break;

        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment, fragment1);
        ft.commit();


    }
    public void setImg(ImageButton btn, int dr){
        int fire1 = R.drawable.fire;
        int fire2 = R.drawable.fire2;
        int goals1 = R.drawable.goals;
        int add2 = R.drawable.add2;
        int goals2 = R.drawable.goals2;
        int profile1 = R.drawable.profileimg1;
        int profile2 = R.drawable.profileimg2;
        int home1 = R.drawable.home1;
        int home2 = R.drawable.home2;
        ImageButton calendar = findViewById(R.id.calendar);
        ImageButton mainButton = findViewById(R.id.mainButton);
        ImageButton profile = findViewById(R.id.profile);
        ImageButton challenge = findViewById(R.id.challenge);
        ImageButton new_act = findViewById(R.id.new_act);
        calendar.setImageResource(goals2);
        mainButton.setImageResource(home2);
        profile.setImageResource(profile2);
        challenge.setImageResource(fire2);
        new_act.setImageResource(add2);
        btn.setImageResource(dr);
    }
}
