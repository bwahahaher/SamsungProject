package com.example.samsungproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.samsungproject.DBHelper;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class addChallenge extends AppCompatActivity implements View.OnClickListener{
    DBHelper dbHelper;
    CheckBox btn, b1,b2,b3,b4,b5;
    int hard = 1;        TextView d,n;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_challenge);
        ImageButton back = findViewById(R.id.backButton);
        ImageButton min = findViewById(R.id.imageView11);
        b1=findViewById(R.id.c1);
        b2=findViewById(R.id.c2);
        b3=findViewById(R.id.c3);
        b4=findViewById(R.id.c4);
        b5=findViewById(R.id.c5);
        ImageButton plus = findViewById(R.id.imageView12);
        Button add = findViewById(R.id.addBtn);
        back.setOnClickListener(this);
        min.setOnClickListener(this);
        plus.setOnClickListener(this);
        add.setOnClickListener(this);
        dbHelper = new DBHelper(this);
    }
    @Override
    public void onClick(View v) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        switch (v.getId()) {
            case R.id.addBtn:
                TextInputLayout nameEdit; nameEdit = (TextInputLayout) findViewById(R.id.nameLayout);
                String name =String.valueOf(nameEdit.getEditText().getText());
                TextInputLayout descrEdit; descrEdit = (TextInputLayout) findViewById(R.id.descr);
                String descr =String.valueOf(descrEdit.getEditText().getText());
                int imgId = R.drawable.three;;
                if (b1.isChecked()){imgId=R.drawable.one;}
                if (b2.isChecked()){imgId=R.drawable.two;}
                if (b3.isChecked()){imgId=R.drawable.three;}
                if (b4.isChecked()){imgId=R.drawable.four;}
                if (b5.isChecked()){imgId=R.drawable.five;}
                contentValues.put("name", name);
                contentValues.put("hard", imgId);
                contentValues.put("long", n.getText().toString()+" "+d.getText().toString());
                contentValues.put("descr", descr);
                contentValues.put("progress", 0);
                database.insert("Challenges", null, contentValues);
                super.onBackPressed();  // optional depending on your needs

                break;
            case R.id.imageView11:
                day("-");
                break;
            case R.id.imageView12:
                day("+");
                break;
            case R.id.backButton:
                super.onBackPressed();  // optional depending on your needs
                break;
        }
        dbHelper.close();}

    public void setF(View view){
        int a = view.getId();
        b1.setChecked(false);
        b2.setChecked(false);
        b3.setChecked(false);
        b4.setChecked(false);
        b5.setChecked(false);
        btn = findViewById(a);
        btn.setChecked(true);
        hard = a;
    }
    public void day(String s){
        int nu = 0;
        String day=null;
        d=findViewById(R.id.day);
        n=findViewById(R.id.number);
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
