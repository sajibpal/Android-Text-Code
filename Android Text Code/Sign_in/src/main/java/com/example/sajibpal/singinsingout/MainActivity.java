package com.example.sajibpal.singinsingout;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Connection connection;
    EditText txt,txt1;
    Button btn,btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connection=new Connection(this);
        SQLiteDatabase database=connection.getWritableDatabase();

        txt= (EditText) findViewById(R.id.nam);
        txt1= (EditText) findViewById(R.id.pass);
        btn= (Button) findViewById(R.id.butt);
        btn1= (Button) findViewById(R.id.butt1);
    }

   public void signin(View n){

   String name=txt.getText().toString();
   String password=txt1.getText().toString();

      boolean result =connection.findpassword(name,password);

       if (result==true){

          Intent intent=new Intent(MainActivity.this,SignIn.class);
           startActivity(intent);
       }
       else {
           Toast.makeText(this, "username and password not match", Toast.LENGTH_SHORT).show();
       }
   }

   public  void account(View h){

       Intent intent=new Intent(MainActivity.this,Account.class);
       startActivity(intent);
   }
}
