package com.example.myapplication;

import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity4 extends AppCompatActivity {

    LinearLayout linearLayout;
    private static final String TAG = "Activity2";
    HorizontalScrollView horscr;
    TextView nameDis;

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        nameDis = (TextView) findViewById(R.id.nameDis);
        String em;
        Intent intent=getIntent();
        em= intent.getStringExtra("email");

        nameDis.setText(em);
        //Toast.makeText(this, "onCreate Dashboard", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreate Dashboard");
        horscr = (HorizontalScrollView) findViewById(R.id.imgscroll);

 /*       linearLayout = findViewById(R.id.linear_layout);        //Adding 2 TextViews
        for (int i = 1; i <= 100; i++) {
            TextView textView = new TextView(this);
            textView.setTextSize(60);
            textView.setText("component " + String.valueOf(i));
            linearLayout.addView(textView);
        }*/

        horscr.setSmoothScrollingEnabled(true);
        horscr.setEdgeEffectColor(Color.GREEN);

    }

    public void goToLifecycle(View v){
        /*Intent in = new Intent(MainActivity4.this, MainActivity5.class);
        startActivity(in);*/
        Intent in = new Intent(Intent.ACTION_VIEW);
        in.setData(Uri.parse("https://gadgets360.com/moto-e20-price-in-india-103971"));
        startActivity(in);
    }




    @Override
    protected void onStart() {
        super.onStart();
        //Toast.makeText(this, "onStart Dashboard", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStart Dashboard");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //Toast.makeText(this, "onRestart Dashboard", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onRestart Dashboard");
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Toast.makeText(this, "onResume Dashboard", Toast.LENGTH_SHORT).show();

        Log.d(TAG, "onResume Dashboard");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Toast.makeText(this, "onPause Dashboard", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onPause Dashboard");
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Toast.makeText(this, "onStop Dashboard", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStop Dashboard");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Toast.makeText(this, "onDestroy Dashboard", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroy Dashboard");
    }


}