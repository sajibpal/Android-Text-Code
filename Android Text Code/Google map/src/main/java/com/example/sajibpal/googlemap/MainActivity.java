package com.example.sajibpal.googlemap;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class MainActivity extends AppCompatActivity {

    private static  final String tag="MainActivity";
    private static  final int dilog_request=9001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(isService()){

            intrap();
        }
    }

    private void  intrap(){

        Button mapbutton= (Button) findViewById(R.id.map);

        mapbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,MapActivity.class);
                startActivity(intent);
            }
        });
    }
    public  boolean isService(){

        Log.d(tag,"isservice :Checking google service version");
        int available= GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);

         if(available== ConnectionResult.SUCCESS){

             Log.d(tag,"isserviceok : Google service is working");
             return  true;
         }
         else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){

             Log.d(tag,"isserviceok : Google service is not working");
             Dialog dialog =GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this,available,dilog_request);
             dialog.show();
         }
         else{

             Toast.makeText(this, "You can not map request", Toast.LENGTH_SHORT).show();
         }
         return false;
    }
}
