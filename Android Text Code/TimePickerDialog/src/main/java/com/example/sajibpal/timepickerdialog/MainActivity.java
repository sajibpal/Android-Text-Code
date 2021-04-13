package com.example.sajibpal.timepickerdialog;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView txt;
    TimePickerDialog picker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=(Button) findViewById(R.id.button);
        txt=(TextView) findViewById(R.id.text);

    }
    public  void click(View l){

        TimePicker time=new TimePicker(this);
        time.is24HourView();
       int currenthoure= time.getCurrentHour();
       int currentmimite=time.getCurrentMinute();

       picker=new TimePickerDialog(MainActivity.this,
               new TimePickerDialog.OnTimeSetListener() {
                   @Override
                   public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                    txt.setText("Time :"+hourOfDay+": "+minute);
                   }
               },currenthoure,currentmimite,true);

        picker.show();
    }

}
