package com.example.sajibpal.alermmanager;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText houres,minute;
    String value,value1;
    int time,time1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn= (Button) findViewById(R.id.alerm);
        houres= (EditText) findViewById(R.id.houre);
        minute= (EditText) findViewById(R.id.minute);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                value=houres.getText().toString();
                time=Integer.parseInt(value);

                value1=minute.getText().toString();
                time1=Integer.parseInt(value1);

                Intent intent=new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_HOUR,time);
                intent.putExtra(AlarmClock.EXTRA_MINUTES,time1);
                startActivity(intent);
            }
        });
    }
}
