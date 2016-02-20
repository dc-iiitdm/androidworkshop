package com.example.kamarajios33.webviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView web;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = (WebView)findViewById(R.id.w);
        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        web.loadUrl("http://www.google.co.in");
        web.setWebViewClient(new WebViewClient());

    }
    public void onBackPressed()
    {
        if(web.canGoBack())
        {
            web.goBack();

        }
        else
        {
            super.onBackPressed();
        }
    }
}
