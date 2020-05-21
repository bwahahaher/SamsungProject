package com.example.samsungproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;

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
    public void setF(View view){
        int a = view.getId();
        CheckBox btn, b1,b2,b3,b4,b5;
        b1=findViewById(R.id.c1);
        b2=findViewById(R.id.c2);
        b3=findViewById(R.id.c3);
        b4=findViewById(R.id.c4);
        b5=findViewById(R.id.c5);
        b1.setChecked(false);
        b2.setChecked(false);
        b3.setChecked(false);
        b4.setChecked(false);
        b5.setChecked(false);
        btn = findViewById(a);
        btn.setChecked(true);
    }
    public void plus(View v){
        day("+");
    }
    public void minus(View v){
        day("-");
    }
    public void day(String s){
        TextView d,n;
        d=findViewById(R.id.day);
        n=findViewById(R.id.number);
        int nu = 0;
        String day=null;
        ArrayList<Integer> dnya = new ArrayList<>();
        dnya.add(2);dnya.add(3);dnya.add(4);dnya.add(2);dnya.add(22);dnya.add(23);dnya.add(24);dnya.add(32);dnya.add(33);dnya.add(34); dnya.add(42);dnya.add(43);dnya.add(44);dnya.add(52);dnya.add(52);dnya.add(53);dnya.add(54);dnya.add(62);dnya.add(63);dnya.add(64);
        ArrayList<Integer> den = new ArrayList<>();
        den.add(1);den.add(21);den.add(31);        den.add(41);den.add(51);den.add(61);
        if (s=="-") {
            nu = Integer.parseInt(n.getText().toString()) - 1;
        }
        else if (s=="+") {
            nu = Integer.parseInt(n.getText().toString()) + 1;
        }
        if(nu>=0) {
            n.setText(nu + "");
        }
        else{n.setText("0");}
        for (int a:dnya){
            if (nu==a){
                day="дня";
            }
        }
        for (int a:den) {
            if (nu == a) {
                day = "день";
            }
        }
        if (day==null){
            day="дней";
        }
        d.setText(day);
    }
}
