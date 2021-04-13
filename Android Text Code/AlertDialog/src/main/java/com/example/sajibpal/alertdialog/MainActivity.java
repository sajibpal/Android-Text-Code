package com.example.sajibpal.alertdialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder bilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void ok(View v){

        bilder=new AlertDialog.Builder(MainActivity.this);

        bilder.setTitle("Alert Title");
        bilder.setMessage("Do you Want to exit ?");
        bilder.setIcon(R.mipmap.ic);

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
