package com.example.myapplication;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);



        Toast.makeText(this, "____onCreate____", Toast.LENGTH_LONG).show();
        Log.d(TAG, "-->> onCreate <<--");
    }

    @Override
    protected void onStart() {

        Toast.makeText(this, "____onStart____", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "-->> onStart <<--");

        super.onStart();
    }

    @Override
    protected void onResume() {

        Toast.makeText(this, "____onResume____", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "-->> onResume <<--");
        super.onResume();

    }

    @Override
    protected void onPause() {

        Toast.makeText(this, "____onPause____", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "-->> onPause <<--");

        super.onPause();
    }

    @Override
    protected void onStop() {

        Toast.makeText(this, " ____onStop____ ", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "-->> onStop <<--" );

        super.onStop();
    }

    @Override
    protected void onRestart() {

        Toast.makeText(this, "____onRestart____", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "-->> onRestart <<--");

        super.onRestart();
    }

    @Override
    protected void onDestroy() {

        Toast.makeText(this, "____onDestroy____", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "-->> onDestroy <<--");

        super.onDestroy();
    }

    public void gotoActivity2(View view) {
        Intent intent = new Intent(this, lifecycle.class);
        startActivity(intent);

    }
}