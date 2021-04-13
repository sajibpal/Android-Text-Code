package com.example.sajibpal.pdfview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class MainActivity extends AppCompatActivity {

    PDFView pdfview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pdfview= (PDFView) findViewById(R.id.pdf);
        pdfview.fromAsset("visa_policy.pdf").load();

    }
}
