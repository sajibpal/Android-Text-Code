package com.example.sajibpal.alertbilder;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean ok=true;
    AlertDialog.Builder bilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void ok(View v){

        bilder=new AlertDialog.Builder(MainActivity.this);

        bilder.setTitle("Alert Title");


        bilder.setMultiChoiceItems(R.array.day, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
               if(ok==true){

                   Toast.makeText(MainActivity.this,"Selected Positiion"+which, Toast.LENGTH_SHORT).show();
                   ok=false;
               }
               else {

                   Toast.makeText(MainActivity.this,"Selected One day", Toast.LENGTH_SHORT).show();

               }

            }
        });

      /*  bilder.setItems(R.array.day, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Selected Position"+which, Toast.LENGTH_SHORT).show();
            }
         });*/
        bilder.setIcon(R.drawable.ic);

        bilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });

        bilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();
            }
        });
        bilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(MainActivity.this, "Cancel Alert", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alert=bilder.create();
        alert.show();
    }
}
