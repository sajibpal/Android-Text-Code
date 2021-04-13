package com.example.sajibpal.grideview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class ImageGallary extends AppCompatActivity {


    ImageView imageView;
    TextView txt;
    PhotoViewAttacher attacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_gallary);

        imageView= (ImageView) findViewById(R.id.img);
        txt= (TextView) findViewById(R.id.text);

        String title = getIntent().getStringExtra("text");
        txt.setText(title);

       int link =getIntent().getIntExtra("image",0);
         imageView.setImageResource(link);
         attacher=new PhotoViewAttacher(imageView);

    }
}
