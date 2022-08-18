package com.example.myapplication;

import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
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
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

public class MainActivity4 extends AppCompatActivity {

    LinearLayout linearLayout;
    private static final String TAG = "Activity2";
    HorizontalScrollView horscr;
    TextView nameDis;


    Button btn;
    LayoutInflater li;



    ScrollView layout;



    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setAnimation();
        setContentView(R.layout.activity_main4);
        nameDis = (TextView) findViewById(R.id.nameDis);


        Bundle extras = getIntent().getExtras();
        String hh = extras.getString("email");

        btn = (Button) findViewById(R.id.raters);


        //li = getLayoutInflater();
        //Getting the View object as defined in the customtoast.xml file
         //layout = li.inflate(R.layout.customtoast,(ViewGroup) findViewById(R.id.custom_toast_layout));

        //Toast.makeText(this, "Welcome user: "+hh, Toast.LENGTH_LONG).show();

        nameDis.setText(hh);
        //Toast.makeText(this, "onCreate Dashboard", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreate Dashboard");
        horscr = (HorizontalScrollView) findViewById(R.id.imgscroll);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Rating bar and it's associated functions
                RatingBar rrr = new RatingBar(MainActivity4.this);
                rrr.setNumStars(5);
                rrr.setStepSize((float) 0.5);
                rrr.setMax(5);
                rrr.setNumStars(5);

                layout = (ScrollView) findViewById(R.id.blahh);
                final LinearLayout customLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.get_ratings, null);
                customLayout.addView(rrr);



                // create alert bar
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity4.this);
                builder1.setMessage("Rate us");
                //set view to the alertbox, the alert box shows the layout
                builder1.setView(customLayout);
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // dialog.cancel();
                                Snackbar snackbar
                                        = Snackbar
                                        .make(
                                                layout,
                                                "Ratings: "+String.valueOf(rrr.getRating()+"\nNumber of stars: "+rrr.getNumStars()),
                                                Snackbar.LENGTH_LONG);
                                snackbar.show();

                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Snackbar snackbar
                                        = Snackbar
                                        .make(
                                                layout,
                                                "You haven't rated :(",
                                                Snackbar.LENGTH_LONG);
                                snackbar.show();

                                dialog.cancel();
                            }


                            });

                AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });

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
    public void disCustomToast(View v){

//        Toast toast = new Toast(getApplicationContext());
//        toast.setDuration(Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.CENTER, 5, 2);
//        toast.setView(layout);//setting the view of custom toast layout
//        toast.show();


    }

    public void weber(View v) {

        Intent in = new Intent(MainActivity4.this, MainActivity6.class);
        in.putExtra("weburl", "https://gadgets360.com/moto-e20-price-in-india-103971");
        startActivity(in);

    }
    public void weberapp(View v) {

        Intent in = new Intent(MainActivity4.this, MainActivity6.class);
        in.putExtra("weburl", "https://gadgets360.com/apple/reviews");
        startActivity(in);

    }


    public void editprofile(View v) {

        Intent in = new Intent(MainActivity4.this, MainActivity5.class);
        //in.putExtra("weburl", "https://gadgets360.com/apple/reviews");
        startActivity(in);

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
            getWindow().setExitTransition(slide);
            getWindow().setEnterTransition(slide1);
        }
    }

    public void phoneSend(View v){

        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:"+"8870078094"));
        startActivity(callIntent);

    }
    public void ratings(View v){

//        Intent callIntent = new Intent(Intent.ACTION_DIAL);
//        callIntent.setData(Uri.parse("tel:"+"8870078094"));
//        startActivity(callIntent);

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