package com.example.sajibpal.barcodescaner;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button= (Button) findViewById(R.id.btn);
        txt= (TextView) findViewById(R.id.text);

        final Activity activity=this;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IntentIntegrator integrator=new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult intentResult=IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(intentResult!=null){

           if(intentResult.getContents()==null){

               Toast.makeText(this, "you canceled the scanner", Toast.LENGTH_SHORT).show();
           }
           else{

              String text=intentResult.getContents();
               txt.setText(text);
           }
        }
        else {

            super.onActivityResult(requestCode, resultCode, data);

        }
    }
}
