package com.example.uber;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    HorizontalScrollView horscr;
    ImageButton searchToaster;
    private static final String TAG = "Dashboard";

    ScrollView entireScroll;

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toast.makeText(this, "onCreate Dashboard", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreate Dashboard");

        horscr = (HorizontalScrollView) findViewById(R.id.imgscroll);
        entireScroll = (ScrollView) findViewById(R.id.entireScroll);
        searchToaster = (ImageButton) findViewById(R.id.searchToaster);
        LayoutInflater li = getLayoutInflater();
        View layout = li.inflate(R.layout.customtoast,(ViewGroup) findViewById(R.id.custom_toast_layout));

        // scroll effects for both scroll view and horizontal scroll view
        horscr.setSmoothScrollingEnabled(true);
        horscr.setEdgeEffectColor(Color.BLACK);

        entireScroll.setSmoothScrollingEnabled(true);
        entireScroll.setEdgeEffectColor(Color.YELLOW);


        searchToaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, -650);
                toast.setView(layout);//setting the view of custom toast layout
                toast.show();
            }
        });


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
        //Toast.makeText(this, "onRestart Dashboard", Toast.LENGTH_SHORT).show();
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