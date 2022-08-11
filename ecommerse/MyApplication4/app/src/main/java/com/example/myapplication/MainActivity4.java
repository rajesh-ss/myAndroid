package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    LinearLayout linearLayout;
    private static final String TAG = "Activity2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Toast.makeText(this, "onCreate Dashboard", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreate Dashboard");

 /*       linearLayout = findViewById(R.id.linear_layout);        //Adding 2 TextViews
        for (int i = 1; i <= 100; i++) {
            TextView textView = new TextView(this);
            textView.setTextSize(60);
            textView.setText("component " + String.valueOf(i));
            linearLayout.addView(textView);
        }*/
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
        Toast.makeText(this, "onStart Dashboard", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStart Dashboard");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart Dashboard", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onRestart Dashboard");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume Dashboard", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onResume Dashboard");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause Dashboard", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onPause Dashboard");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop Dashboard", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStop Dashboard");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy Dashboard", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroy Dashboard");
    }


}