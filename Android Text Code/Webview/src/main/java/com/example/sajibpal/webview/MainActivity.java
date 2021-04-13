package com.example.sajibpal.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view=(WebView) findViewById(R.id.web);
        WebSettings seeting =view.getSettings();
        seeting.setJavaScriptEnabled(true);

        view.setWebViewClient(new WebViewClient());
        view.loadUrl("https://www.w3schools.com");
    }

    public void onBackPressed(){

    if(view.canGoBack()){

        view.goBack();
    }
    else{
       super.onBackPressed();
     }

    }

}
