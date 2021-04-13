package com.example.sajibpal.feedbackmenuitem;

import android.content.Intent;
import android.database.StaleDataException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Mail extends AppCompatActivity {

    Button btn,btn1;
    EditText txt,txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);

        btn=(Button) findViewById(R.id.button);
        btn1=(Button) findViewById(R.id.button1);
        txt=(EditText) findViewById(R.id.text);
        txt1=(EditText) findViewById(R.id.text1);
    }
    public  void show(View v){
       try{
           String name=txt.getText().toString();
           String message=txt1.getText().toString();

           if(v.getId()==R.id.button){

               Intent intent=new Intent(Intent.ACTION_SEND);
               intent.setType("text/mail");

               intent.putExtra(Intent.EXTRA_EMAIL,new String[] {"sajibpal20@gmail.com"});
               intent.putExtra(Intent.EXTRA_SUBJECT,"Feedback from app");
               intent.putExtra(Intent.EXTRA_TEXT,"name : "+name +"\nMessage : "+message);
               startActivity(intent.createChooser(intent,"Feedback with"));
           }
           if(v.getId()==R.id.button1){

               txt.setText("");
               txt1.setText("");
           }
       }
       catch (Exception e){

           Toast.makeText(this, "Exception : "+e, Toast.LENGTH_SHORT).show();
       }

    }

}
