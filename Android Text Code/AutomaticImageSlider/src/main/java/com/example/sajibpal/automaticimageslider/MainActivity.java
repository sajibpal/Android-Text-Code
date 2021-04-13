package com.example.sajibpal.automaticimageslider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    ViewFlipper flipper;
    int[] image={R.drawable.bd,R.drawable.india,R.drawable.auatrila,R.drawable.srilankaflag,R.drawable.nepal};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flipper=(ViewFlipper) findViewById(R.id.fliper);

        for(int i=0; i<image.length;i++){

            flipperImage(image[i]);
        }
    }
    public  void flipperImage(int image){

        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(image);

        flipper.addView(imageView);
        flipper.setFlipInterval(3000);
        flipper.setAutoStart(true);

        flipper.setInAnimation(this, android.R.anim.slide_in_left );
        flipper.setOutAnimation(this,android.R.anim.slide_out_right );
    }
}
