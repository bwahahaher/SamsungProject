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
        int a;
        ImageButton btn;
        switch (view.getId()){
            case R.id.calendar:
                fragment1=new CalendarFragment();
                t.setText("Будущие цели");
                 a = Integer.parseInt("R.drawable.goals" + "1");
                btn = findViewById(R.id.calendar);
                setImg(btn, a);
                break;
            case R.id.mainButton:
                fragment1=new MainFragment();
                t.setText("Главная");
                a = Integer.parseInt("R.drawable.home" + "1");
                btn = findViewById(R.id.mainButton);
                setImg(btn, a);
                break;
            case R.id.profile:
                fragment1 = new ProfileFragment();
                t.setText("Профиль");
                a = Integer.parseInt("R.drawable.profileimg" + "1");
                btn = findViewById(R.id.profile);
                setImg(btn, a);
                break;
            case R.id.challenge:
                fragment1 = new ChallengeFragment();
                t.setText("Челленджи");
                a = R.drawable.fire;
                btn = findViewById(R.id.challenge);
                setImg(btn, a);
                break;
            case R.id.new_act:
                fragment1 = new AddGoalsFragment();
                t.setText("Добавить");
                a = R.drawable.home2;
                btn = findViewById(R.id.mainButton);
                setImg(btn, a);
                break;

        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment, fragment1);
        ft.commit();


    }
    public void setImg(ImageButton btn, int dr){
//        ImageButton calendar = findViewById(R.id.calendar);
//        ImageButton mainButton = findViewById(R.id.mainButton);
//        ImageButton profile = findViewById(R.id.profile);
//        ImageButton challenge = findViewById(R.id.challenge);
//
//        mainButton.setImageResource(R.drawable.home2);
//        profile.setImageResource(R.drawable.profileimg1);
//        challenge.setImageResource(R.drawable.fire2);
//        calendar.setImageResource(R.drawable.goals2);
//        btn.setImageResource(dr);
    }
}
