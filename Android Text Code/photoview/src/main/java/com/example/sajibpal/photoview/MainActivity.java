package com.example.sajibpal.photoview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class MainActivity extends AppCompatActivity {
   ImageView img;
   PhotoViewAttacher attacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img= (ImageView) findViewById(R.id.image);
        attacher=new PhotoViewAttacher(img);
    }
}
