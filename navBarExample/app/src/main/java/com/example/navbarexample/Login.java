package com.example.navbarexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity {


    TextView notUser;
    Button sinin;
    EditText email, psw;
    private static final String TAG = "Login Activity";
   private FirebaseAuth mAuth;
    LayoutInflater li;
    View layout;






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
        setAnimation();
        setContentView(R.layout.activity_login);

        notUser = (TextView) findViewById(R.id.notUser);
        sinin = (Button) findViewById(R.id.sinin);
        email = (EditText) findViewById(R.id.email);
        psw = (EditText) findViewById(R.id.psw);
        mAuth = FirebaseAuth.getInstance();



        li = getLayoutInflater();
        //Getting the View object as defined in the customtoast.xml file
        layout = li.inflate(R.layout.customtoast,(ViewGroup) findViewById(R.id.custom_toast_layout));

        //Toast.makeText(this, "____onCreate____", Toast.LENGTH_LONG).show();
        Log.d(TAG, "-->> onCreate <<--");

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


                Intent in = new Intent(Login.this, MainActivity.class);
//                in.putExtra("email", email.getText().toString());
                startActivity(in);
                //YoYo.with(Techniques.Swing).duration(1000).repeat(1).playOn(psw);

                // Toast.makeText(MainActivity2.this, valEm( email.getText().toString())+"_-_"+valPsw(psw.getText().toString()), Toast.LENGTH_SHORT).show();


                if(valEm(email.getText().toString()) && valPsw(psw.getText().toString())){
                   //Intent in = new Intent(Login.this, MainActivity.class);




                    mAuth.signInWithEmailAndPassword(email.getText().toString(), psw.getText().toString()).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "signInWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "signInWithEmail:failure", task.getException());

                                updateUI(null);
                            }
                        }
                    });

                    //in.putExtra("email", email.getText().toString());
                    //startActivity(in);
                }
                else if(valEm(email.getText().toString()) && !valPsw(psw.getText().toString())){
                    //Toast.makeText(Login.this, "password forat is not correct", 2000);
                    Toast.makeText(Login.this, "password format is not valid", Toast.LENGTH_SHORT).show();
                }

                else if(!valEm(email.getText().toString()) && valPsw(psw.getText().toString())){
                    //Toast.makeText(this, "", 2000);
                    Toast.makeText(Login.this, "Email format is not valid", Toast.LENGTH_SHORT).show();
                }

                else if(!valEm(email.getText().toString()) && !valPsw(psw.getText().toString())){
                    //Toast.makeText(this, "", 2000);

                    Toast.makeText(Login.this, "Email and password format is not valid"+valEm(email.getText().toString())+valPsw(psw.getText().toString()), Toast.LENGTH_SHORT).show();
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

    public void disCustomToast(){

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, -650);
        toast.setView(layout);//setting the view of custom toast layout
        toast.show();
    }
    public void updateUI(FirebaseUser account){

        if(account != null){
            // Toast.makeText(this,"You Signed In successfully",Toast.LENGTH_LONG).show();
            Intent in = new Intent(Login.this, MainActivity.class);
            //in.putExtra("email", email.getText().toString());
            startActivity(in);

        }else {
            Toast.makeText(this,"You Didnt signed in: invalid email or psw",Toast.LENGTH_LONG).show();

        }

    }
    @Override
    public void onStart() {

        // Check if user is signed in (non-null) and update UI accordingly.
        //FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
        //Toast.makeText(this, "____onStart____", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "-->> onStart <<--");

        super.onStart();
    }



    @Override
    protected void onResume() {

        //Toast.makeText(this, "____onResume____", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "-->> onResume <<--");
        super.onResume();

    }

    @Override
    protected void onPause() {

        //Toast.makeText(this, "____onPause____", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "-->> onPause <<--");

        super.onPause();
    }

    @Override
    protected void onStop() {

        //Toast.makeText(this, " ____onStop____ ", Toast.LENGTH_SHORT).show();
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

        //Toast.makeText(this, "____onDestroy____", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "-->> onDestroy <<s");

        super.onDestroy();
    }



}
