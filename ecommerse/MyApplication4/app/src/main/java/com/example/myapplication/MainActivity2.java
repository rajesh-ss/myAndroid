package com.example.myapplication;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity2 extends AppCompatActivity {

    TextView notUser;
    Button sinin;
    EditText email, psw;
    private static final String TAG = "Login Activity";


    
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^(.+)@(.+)$",   Pattern.CASE_INSENSITIVE);

    public static final Pattern VALID_PSW_REGEX =
            Pattern.compile( "^(?=.*[0-9])"
                    + "(?=.*[a-z])(?=.*[A-Z])"
                    + "(?=.*[@#$%^&+=])"
                    + "(?=\\S+$).{8,20}$", Pattern.CASE_INSENSITIVE);


    public static boolean valEm(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
    public static boolean valPsw(String psw) {
        Matcher matcher = VALID_PSW_REGEX.matcher(psw);
        return matcher.find();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        notUser = (TextView) findViewById(R.id.notUser);
        sinin = (Button) findViewById(R.id.sinin);
        email = (EditText) findViewById(R.id.email);
        psw = (EditText) findViewById(R.id.psw);

        LayoutInflater li = getLayoutInflater();
        //Getting the View object as defined in the customtoast.xml file
        View layout = li.inflate(R.layout.customtoast,(ViewGroup) findViewById(R.id.custom_toast_layout));

        Toast.makeText(this, "____onCreate____", Toast.LENGTH_LONG).show();
        Log.d(TAG, "-->> onCreate <<--");

        notUser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity2.this, "going register", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getBaseContext(),MainActivity3.class);
                startActivity(i);
            }
        });

        sinin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // Toast.makeText(MainActivity2.this, valEm( email.getText().toString())+"_-_"+valPsw(psw.getText().toString()), Toast.LENGTH_SHORT).show();


                if(valEm(email.getText().toString()) && valPsw(psw.getText().toString())){
                    Toast toast = new Toast(getApplicationContext());
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, -650);
                    toast.setView(layout);//setting the view of custom toast layout
                    toast.show();
                    Intent in = new Intent(MainActivity2.this, MainActivity4.class);
                    startActivity(in);
                }
                else if(valEm(email.getText().toString()) && !valPsw(psw.getText().toString())){
                    //Toast.makeText(this, "", 2000);
                    Toast.makeText(MainActivity2.this, "password format is not valid", Toast.LENGTH_SHORT).show();
                }

                else if(!valEm(email.getText().toString()) && valPsw(psw.getText().toString())){
                    //Toast.makeText(this, "", 2000);
                    Toast.makeText(MainActivity2.this, "Email format is not valid", Toast.LENGTH_SHORT).show();
                }

                else if(!valEm(email.getText().toString()) && !valPsw(psw.getText().toString())){
                    //Toast.makeText(this, "", 2000);

                    Toast.makeText(MainActivity2.this, "Email and password format is not valid"+valEm(email.getText().toString())+valPsw(psw.getText().toString()), Toast.LENGTH_SHORT).show();
                }


            }
        });
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