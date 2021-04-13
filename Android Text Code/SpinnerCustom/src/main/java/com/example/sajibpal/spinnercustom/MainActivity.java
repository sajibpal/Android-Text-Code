package com.example.sajibpal.spinnercustom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    String[] name;
    String[] population;
    int[] flag={R.drawable.bd,R.drawable.nepal,R.drawable.india,R.drawable.pakistan,
            R.drawable.butanflag,R.drawable.srilankaflag,R.drawable.auatrila};
    
    boolean selected=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner=(Spinner) findViewById(R.id.spiner);
        name=getResources().getStringArray(R.array.data);
        population=getResources().getStringArray(R.array.pop);

        CustomAdapter adapter=new CustomAdapter(this,flag,name,population);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 
                if(selected==true){
                    
                    selected=false;
                }
                else {

                    Toast.makeText(getApplicationContext(),name[position]+ " is selected", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
