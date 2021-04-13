package com.example.sajibpal.spnas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class Screen extends AppCompatActivity {
    ProgressBar bar;
    int val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN );

        setContentView(R.layout.activity_screen);
        bar=(ProgressBar) findViewById(R.id.proge);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                work();
                next();
            }
        });
        thread.start();

    }
   public  void  work(){

       for(val=5;val<=100;val+=5) {

           try{

               bar.setProgress(val);
               Thread.sleep(500);

           }catch (Exception j){


           }
       }

   }
   public  void next(){

       Intent intent=new Intent(Screen.this,MainActivity.class);
       startActivity(intent);
       finish();
   }
}
