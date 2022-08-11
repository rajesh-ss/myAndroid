package com.example.myapplication;

import static android.content.ContentValues.TAG;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {


    ScrollView par;
    LinearLayout chOne;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        par = (ScrollView) findViewById(R.id.par);



        chOne = new LinearLayout(this);
        chOne.setOrientation(LinearLayout.VERTICAL);
        CardView cd = new CardView(this);



        for(int i=0; i<60; i++) {


            TextView tv = new TextView(this);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_PX,60);
            tv.setWidth(1200);
            tv.setGravity(Gravity.CENTER_HORIZONTAL);
            tv.setHeight(150);
            tv.setText("testView");
            tv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            chOne.addView(tv);

        }


        cd.addView(chOne);
        //par.addView(cd);

    }


}