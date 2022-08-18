package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity6 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        Bundle extras = getIntent().getExtras();
        String hh = extras.getString("weburl");

        WebView myWebView = (WebView) findViewById(R.id.webview);

        myWebView.loadUrl(hh);
    }
}