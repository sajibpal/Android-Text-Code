package com.example.sajibpal.country;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=(Button) findViewById(R.id.button1);
        btn2=(Button) findViewById(R.id.button1);
        btn3=(Button) findViewById(R.id.button1);

    }
    public  void show(View h) {

        if (h.getId() == R.id.button1) {

            Intent intent = new Intent(MainActivity.this, Bangladesh.class);
            intent.putExtra("name", "Bangladesh");
            startActivity(intent);
        }

        if (h.getId() == R.id.button2) {

            Intent intent = new Intent(MainActivity.this, Bangladesh.class);
            intent.putExtra("name", "India");
            startActivity(intent);
        }

    }
}
