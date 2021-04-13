package com.example.sajibpal.intentsendsms;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button= (Button) findViewById(R.id.btn);
    }

    public void send(View view){

        Intent smsintent=new Intent(Intent.ACTION_VIEW);
        smsintent.setData(Uri.parse("smsto:"));
        smsintent.setType("vnd.android-dir/mms-sms");
        smsintent.putExtra("address",new String("48948988;9848948"));
        smsintent.putExtra("sms_body","hello");

        try {
            startActivity(smsintent);
            finish();
            Log.i("Finished sending SMS...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "SMS faild, please try again later.", Toast.LENGTH_SHORT).show();
        }
    }
}


