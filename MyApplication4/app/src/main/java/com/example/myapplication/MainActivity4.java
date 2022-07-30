package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


 /*       linearLayout = findViewById(R.id.linear_layout);        //Adding 2 TextViews
        for (int i = 1; i <= 100; i++) {
            TextView textView = new TextView(this);
            textView.setTextSize(60);
            textView.setText("component " + String.valueOf(i));
            linearLayout.addView(textView);
        }*/
    }
}