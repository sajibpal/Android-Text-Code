package com.example.sajibpal.cardview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    CardView schoolview,hospitalview,airportview,restruentvew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        schoolview=(CardView) findViewById(R.id.school);
        hospitalview=(CardView) findViewById(R.id.hospital);


        schoolview.setOnClickListener(this);
        hospitalview.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

      if(v.getId()==R.id.school) {

          Intent intent=new Intent(MainActivity.this,School.class);
          startActivity(intent);
      }
        if(v.getId()==R.id.hospital) {

            Intent intent=new Intent(MainActivity.this,Hospitial.class);
            startActivity(intent);
        }

    }
}
