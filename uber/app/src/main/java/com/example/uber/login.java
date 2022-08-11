package com.example.uber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    private static final String TAG = "Login";
    EditText email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toast.makeText(this, "onCreate Login", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreate Login");


        email = (EditText) findViewById(R.id.email);


    }

    public void GotoHis(View v){
        String em = email.getText().toString();
        Intent in = new Intent(login.this, MainActivity2.class);
        startActivity(in);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart Login", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStart Login");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart Login", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onRestart Login");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume Login", Toast.LENGTH_SHORT).show();

        Log.d(TAG, "onResume Login");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause Login", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onPause Login");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop Login", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStop Login");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy Login", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroy Login");
    }
}