package com.example.uber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.ScrollView;

import com.google.android.material.snackbar.Snackbar;

public class rateDriver extends AppCompatActivity {

    RatingBar rt;
    LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_driver);

        rt = (RatingBar) findViewById(R.id.rater);

        layout = (LinearLayout) findViewById(R.id.llp);

        rt.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Snackbar snackbar
                        = Snackbar
                        .make(
                                layout,
                                "Ratings: "+String.valueOf(rt.getRating()+"\nNumber of stars: "+rt.getNumStars()),
                                Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

    }

    public void submitted(View v){
        Snackbar snackbar
                = Snackbar
                .make(
                        layout,
                        "Ratings: "+String.valueOf(rt.getRating()+"\nNumber of stars: "+rt.getNumStars()),
                        Snackbar.LENGTH_LONG);
        snackbar.show();

        Intent in = new Intent(rateDriver.this, MainActivity2.class);
        startActivity(in);
    }
}