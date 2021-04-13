package com.example.sajibpal.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner pinner;
    Button btn;
    TextView txt;
    String[] name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pinner=(Spinner) findViewById(R.id.spiner);
        btn=(Button) findViewById(R.id.button);
        txt=(TextView) findViewById(R.id.text);
        name=getResources().getStringArray(R.array.data);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,R.layout.information,R.id.view,name);
        pinner.setAdapter(adapter);
    }
    public  void  show(View g){

        String value=pinner.getSelectedItem().toString();
        txt.setText(value);
    }
}
