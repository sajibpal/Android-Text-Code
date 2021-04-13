package com.example.sajibpal.datepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DatePicker picker;
    TextView txt;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        picker=(DatePicker) findViewById(R.id.date);
        txt=(TextView) findViewById(R.id.text);
        btn=(Button)findViewById(R.id.button);

        txt.setText("Current Date: "+currentdate());
    }
    public  String currentdate(){

        StringBuffer buffer=new StringBuffer();
        buffer.append(picker.getDayOfMonth()+"/");
        buffer.append((picker.getMonth()+1)+"/");
        buffer.append(picker.getYear());
        return buffer.toString();
    }

    public  void dateshow(View g){

    txt.setText("Current Date: "+currentdate());
    }
}
