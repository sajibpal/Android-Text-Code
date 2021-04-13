package com.example.sajibpal.framlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

   ImageView imageView, imageView1,imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=(ImageView) findViewById(R.id.image);
        imageView1=(ImageView) findViewById(R.id.image1);
        imageView2=(ImageView) findViewById(R.id.image2);

    }
    public  void show(View v){

       if(v.getId()==R.id.image) {

        imageView.setVisibility(v.GONE);
        imageView1.setVisibility(v.VISIBLE);
       }
       if(v.getId()==R.id.image1) {

           imageView1.setVisibility(v.GONE);
           imageView2.setVisibility(v.VISIBLE);
       }
       else {

           imageView2.setVisibility(v.GONE);
           imageView.setVisibility(v.VISIBLE);
       }
    }

}

