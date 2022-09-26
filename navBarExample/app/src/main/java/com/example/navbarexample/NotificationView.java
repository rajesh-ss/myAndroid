package com.example.navbarexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationView extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_view);
        textView = findViewById(R.id.textView);
        //getting the notification message
        //String message=getIntent().getStringExtra("message");
        //textView.setText(message);
        // Retrieving the value using its keys the file name
// must be same in both saving and retrieving the data
        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

// The value will be default as empty string because for
// the very first time when the app is opened, there is nothing to show
        String s1 = "Address: "+sh.getString("Address", "");
        s1+="\n "+"DOB"+sh.getString("DOB", "");
        s1+="\n "+"Gender"+sh.getString("Gender", "");
        s1+="\n "+"prime"+sh.getInt("prime", 0);

        //int a = sh.getInt("age", 0);

// We can then use the data
        textView.setText(s1);
        //age.setText(String.valueOf(a));

    }
}