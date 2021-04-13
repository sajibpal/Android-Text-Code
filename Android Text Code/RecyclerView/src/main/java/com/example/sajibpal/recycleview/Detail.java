package com.example.sajibpal.recycleview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Detail extends AppCompatActivity {

    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        img= (ImageView) findViewById(R.id.vimage);
        Intent intent=getIntent();
        int image1=intent.getExtras().getInt("Image");

        img.setImageResource(image1);
    }
}
