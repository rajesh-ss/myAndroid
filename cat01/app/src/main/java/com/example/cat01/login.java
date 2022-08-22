package com.example.cat01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Slide;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class login extends AppCompatActivity {

    TextView notUser;
    Button sinin;
    EditText email, psw;
    private static final String TAG = "Login Activity";


    /********************************************************
     *********** Functions for email validation  *************
     *********************************************************/


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

        setAnimation();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        notUser = (TextView) findViewById(R.id.notUser);
        sinin = (Button) findViewById(R.id.sinin);
        email = (EditText) findViewById(R.id.email);
        psw = (EditText) findViewById(R.id.psw);


        notUser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity2.this, "going register", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getBaseContext(),signup.class);
                startActivity(i);
            }
        });

        sinin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //YoYo.with(Techniques.Swing).duration(1000).repeat(1).playOn(psw);

                // Toast.makeText(MainActivity2.this, valEm( email.getText().toString())+"_-_"+valPsw(psw.getText().toString()), Toast.LENGTH_SHORT).show();


                if(valEm(email.getText().toString()) && valPsw(psw.getText().toString())) {
                    Toast.makeText(login.this, "Logiing in", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(login.this, dashboard.class);
                    in.putExtra("email", email.getText().toString());
                    startActivity(in);

                }

                else if(valEm(email.getText().toString()) && !valPsw(psw.getText().toString())){
                    Toast.makeText(login.this, "password format is not valid", Toast.LENGTH_SHORT).show();
                }

                else if(!valEm(email.getText().toString()) && valPsw(psw.getText().toString())){
                    Toast.makeText(login.this, "Email format is not valid", Toast.LENGTH_SHORT).show();
                }

                else if(!valEm(email.getText().toString()) && !valPsw(psw.getText().toString())){

                    Toast.makeText(login.this, "Email and password format is not valid"+valEm(email.getText().toString())+valPsw(psw.getText().toString()), Toast.LENGTH_SHORT).show();
                }


            }
        });
    }


    public void setAnimation() {

        if (Build.VERSION.SDK_INT > 20) {
            Explode explode = new Explode();
            Slide slide = new Slide();
            Slide slide1 = new Slide();
            //slide.setSlideEdge(Gravity.LEFT);
            explode.setDuration(3000);
            explode.setInterpolator(new AccelerateInterpolator());
            slide1.setDuration(3000);
            //slide.setInterpolator(new );
            slide1.setInterpolator(new AccelerateInterpolator());
            slide.setDuration(3000);
            //slide.setInterpolator(new );
            slide.setInterpolator(new DecelerateInterpolator());
            //getWindow().setExitTransition(slide1);
            getWindow().setEnterTransition(slide);
        }
    }
}