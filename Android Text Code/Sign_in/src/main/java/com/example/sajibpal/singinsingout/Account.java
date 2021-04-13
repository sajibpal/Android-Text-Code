package com.example.sajibpal.singinsingout;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Account extends AppCompatActivity {
    Connection connection;
    EditText txt,txt1,txt2,txt3;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        connection=new Connection(this);
        SQLiteDatabase database=connection.getWritableDatabase();

        txt= (EditText) findViewById(R.id.text);
        txt1= (EditText) findViewById(R.id.text1);
        txt2= (EditText) findViewById(R.id.text2);
        txt3= (EditText) findViewById(R.id.text3);
        btn= (Button) findViewById(R.id.button);
    }

    public  void save(View v){

        String name=txt.getText().toString();
        String email=txt1.getText().toString();
        String password=txt2.getText().toString();

        if(v.getId()==R.id.button){

            long rowid=connection.insetData(name,email,password);

            if(rowid==-1){

                Toast.makeText(this, "Data not add Successfully", Toast.LENGTH_SHORT).show();
            }
            else {

                Toast.makeText(this, "Data add Successfully", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
