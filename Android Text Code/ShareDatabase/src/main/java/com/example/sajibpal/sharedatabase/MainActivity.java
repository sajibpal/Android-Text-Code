package com.example.sajibpal.sharedatabase;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn,btn1;
    EditText txt,txt1;
    TextView vtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn= (Button) findViewById(R.id.button);
        btn1= (Button) findViewById(R.id.button1);
        txt= (EditText) findViewById(R.id.text);
        txt1= (EditText) findViewById(R.id.text1);
        vtext=(TextView)findViewById(R.id.text3);
    }

    public  void show(View o){



       if(o.getId()==R.id.button){

           String name=txt.getText().toString();
           String password=txt1.getText().toString();

           if(name.equals("") | password.equals("")){

            txt.setError("Enter name");
            txt1.setError("Enter password");
           }
           else{

               SharedPreferences share=getSharedPreferences("data", Context.MODE_PRIVATE);
               SharedPreferences.Editor editor=share.edit();
               editor.putString("username",name);
               editor.putString("password",password);
               editor.commit();

               txt.setText("");
               txt1.setText("");
               Toast.makeText(this, "Save Successfully", Toast.LENGTH_SHORT).show();
           }
       }
       if (o.getId()==R.id.button1){

           SharedPreferences share=getSharedPreferences("data", Context.MODE_PRIVATE);
           if(share.contains("username") && share.contains("password")){

               String name=share.getString("username","No Data found");
               String password=share.getString("password","No Data found");
               vtext.setText(name+"\n"+password);
           }
       }
    }
}
