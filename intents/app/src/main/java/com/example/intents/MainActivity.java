package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.implcitBTN);
        btn1 = (Button) findViewById(R.id.explcitBTN);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, pg2.class);
                startActivity(in);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Intent.ACTION_VIEW);
                in.setData(Uri.parse("https://www.christuniversity.in"));
                startActivity(in);
            }
        });

    }
}