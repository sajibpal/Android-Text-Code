package com.example.sajibpal.profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText txt,txt1;
    TextView textView;
    int count=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt=(EditText) findViewById(R.id.text);
        txt1=(EditText)findViewById(R.id.text1);
        textView=(TextView)findViewById(R.id.tview);
        btn=(Button)findViewById(R.id.button);
    }

    public  void show(View v){

        String name=txt.getText().toString();
        String password=txt1.getText().toString();

        if(name.equals("sajib pal") && password.equals("154045")){

            Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
        }
        else{

           count--;
           textView.setText("Number of attempt remaining: " +count );
            if(count==0){

              btn.setEnabled(false);

            }
        }
    }
}
