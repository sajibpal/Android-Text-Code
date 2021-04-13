package com.example.sajibpal.progressbar;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressbar;
    TextView txt;
    int value,l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressbar=(ProgressBar) findViewById(R.id.progess);
        txt=(TextView) findViewById(R.id.text);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {

              work();
            }
        });
        thread.start();
    }
    public  void work(){

        for(value=10;value<=120;value+=5) {

            try {

                progressbar.setProgress(value);
                Thread.sleep(1000);

            } catch (Exception e) {


            }
        }
    }

}
