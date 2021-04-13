package com.example.sajibpal.zoominout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ZoomButtonsController;
import android.widget.ZoomControls;

public class MainActivity extends AppCompatActivity {

    ZoomControls zoom1;
    ImageView image1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image1=(ImageView)findViewById(R.id.image);
        zoom1=(ZoomControls) findViewById(R.id.zoom);

        zoom1.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float x=image1.getScaleX();
                float y=image1.getScaleY();

                image1.setScaleX((float)x+1);
                image1.setScaleY((float)y+1);
            }
        });
        zoom1.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float x=image1.getScaleX();
                float y=image1.getScaleY();
              if(x>1 && y>1){
                image1.setScaleX((float)x-1);
                image1.setScaleY((float)y-1);
              }
            }
        });
    }
}
