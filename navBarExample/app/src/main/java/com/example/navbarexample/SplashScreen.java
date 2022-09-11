package com.example.navbarexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Explode;
import android.transition.Slide;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN_TIME_OUT = 3000;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        //getSupportActionBar().setBackgroundDrawable(Color.BLACK);
        setAnimation();
        setContentView(R.layout.activity_main);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //This method is used so that your splash activity
        //can cover the entire screen.

        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView3);
        //this will bind your MainActivity.class file with activity_main.

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this,
                        Login.class);

                // Bundle bd = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle();
                startActivity(i, ActivityOptions.makeSceneTransitionAnimation(SplashScreen.this).toBundle());

                //startActivity(i);
                finish();
            }
        }, SPLASH_SCREEN_TIME_OUT);

//        Thread background = new Thread() {
//            public void run() {
//                try {
//                    // Thread will sleep for 5 seconds
//                    sleep(1000);
//
//                    // After 5 seconds redirect to another intent
//                    //Intent i=new Intent(getBaseContext(),MainActivity2.class);
//                    //startActivity(i);
//
//                    //Remove activity
//                    finish();
//                } catch (Exception e) {
//                }
//            }
//        };
        // start thread
//        background.start();

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomer);
        tv.startAnimation(animation);
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
            //getWindow().setExitTransition(slide);
            getWindow().setEnterTransition(explode);
        }
    }
}