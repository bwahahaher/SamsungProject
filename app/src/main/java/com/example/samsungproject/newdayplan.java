package com.example.samsungproject;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.IntentService;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputLayout;

import java.sql.Date;
import java.sql.Time;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class newdayplan extends AppCompatActivity {
    int id = 21;
    TextView textName;
    Button timeBt;
    Button dateBt;
    TextView timeText;
    TextView dateText;
    Button writeMeetingBt;
    Time t;
    int d;
    Date dateTimer;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newdayplan);
        timeText = (TextView) findViewById(R.id.timeText);
        timeBt = (Button) findViewById(R.id.TimeBt);
        final TextInputLayout nameEdit; nameEdit = (TextInputLayout) findViewById(R.id.nameLayout);
        final String name =String.valueOf(nameEdit.getEditText().getText());
        DBHelper dbHelper;
        dbHelper = new DBHelper(this);
        final SQLiteDatabase database = dbHelper.getWritableDatabase();
        final ContentValues contentValues = new ContentValues();
        Button check = findViewById(R.id.button);
        check.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            public void onClick(View v) {
                String name =String.valueOf(nameEdit.getEditText().getText());
                contentValues.put("name", name);
                contentValues.put("stat", 0);
                contentValues.put("time", timeText.getText().toString());
                database.insert("MyDay", null, contentValues);
            }});

            TimePickerDialog.OnTimeSetListener myCallBack = new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    t = new Time(hourOfDay, minute, 0);
                    String dt = t.toString().substring(0, t.toString().length() - 3);
                    timeText.setText(dt);
                    timeBt.setText("Выбрано");
                }
            };

            final TimePickerDialog tpd = new TimePickerDialog(this, myCallBack, 12, 0, true);

            timeBt.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            tpd.show();
                        }
                    }
            );



    }


}