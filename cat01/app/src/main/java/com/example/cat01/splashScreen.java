package com.example.cat01;

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

public class splashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN_TIME_OUT = 3000;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().hide();
        //getSupportActionBar().setBackgroundDrawable(Color.BLACK);
        setAnimation();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_splash);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //This method is used so that your splash activity
        //can cover the entire screen.

        setContentView(R.layout.screen_splash);
        tv = (TextView) findViewById(R.id.textView3);
        //this will bind your MainActivity.class file with activity_main.

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(splashScreen.this,
                        login.class);

                // Bundle bd = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle();
                startActivity(i, ActivityOptions.makeSceneTransitionAnimation(splashScreen.this).toBundle());

                //startActivity(i);
                finish();
            }
        }, SPLASH_SCREEN_TIME_OUT);

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