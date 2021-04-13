package com.example.sajibpal.clock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.DigitalClock;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void show(View k){

        if(k.getId()==R.id.analog){

            Toast.makeText(MainActivity.this, "Analog clock", Toast.LENGTH_SHORT).show();
        }

    }
}
