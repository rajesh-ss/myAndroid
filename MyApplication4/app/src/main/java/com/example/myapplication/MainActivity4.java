package com.example.myapplication;

import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity4 extends AppCompatActivity {

    LinearLayout linearLayout;
    private static final String TAG = "Activity2";
    HorizontalScrollView horscr;
    TextView nameDis;

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        nameDis = (TextView) findViewById(R.id.nameDis);

        Bundle extras = getIntent().getExtras();
        String hh = extras.getString("email");

        //Toast.makeText(this, "Welcome user: "+hh, Toast.LENGTH_LONG).show();

        nameDis.setText(hh);
        //Toast.makeText(this, "onCreate Dashboard", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreate Dashboard");
        horscr = (HorizontalScrollView) findViewById(R.id.imgscroll);

 /*       linearLayout = findViewById(R.id.linear_layout);        //Adding 2 TextViews
        for (int i = 1; i <= 100; i++) {
            TextView textView = new TextView(this);
            textView.setTextSize(60);
            textView.setText("component " + String.valueOf(i));
            linearLayout.addView(textView);
        }*/

        //horscr.setSmoothScrollingEnabled(true);
        //horscr.setEdgeEffectColor(Color.GREEN);

    }

    public void emialerSend(View v){

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ "rajesh.s@mca.christuniversity.in"});
        email.putExtra(Intent.EXTRA_SUBJECT, "product delivery");
        email.putExtra(Intent.EXTRA_TEXT, "i am sharing one of the delivery histories");

        //need this to prompts email client only
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choose an Email client :"));
    }
    public void phoneSend(View v){

        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:"+"8870078094"));
        startActivity(callIntent);

    }
    public void msgSend(View v){

        Intent callIntent = new Intent(Intent.ACTION_SENDTO);
        callIntent.setData(Uri.parse("sms:"+"8870078094"));
        startActivity(callIntent);

    }
    public void whatsupSend(View v){


        Intent intent
                = new Intent(Intent.ACTION_SEND);

        intent.setType("text/plain");
        intent.setPackage("com.whatsapp");

        // Give your message here
        intent.putExtra(
                Intent.EXTRA_TEXT,
                "hi there ");

        // Checking whether Whatsapp
        // is installed or not
        if (intent
                .resolveActivity(
                        getPackageManager())
                == null) {
            Toast.makeText(
                            this,
                            "Please install whatsapp first.",
                            Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        // Starting Whatsapp
        startActivity(intent);
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
        //Toast.makeText(this, "onStart Dashboard", Toast.LENGTH_SHORT).show();
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
        //Toast.makeText(this, "onResume Dashboard", Toast.LENGTH_SHORT).show();

        Log.d(TAG, "onResume Dashboard");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Toast.makeText(this, "onPause Dashboard", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onPause Dashboard");
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Toast.makeText(this, "onStop Dashboard", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStop Dashboard");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Toast.makeText(this, "onDestroy Dashboard", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroy Dashboard");
    }


}