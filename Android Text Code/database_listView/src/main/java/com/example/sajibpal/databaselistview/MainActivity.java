package com.example.sajibpal.databaselistview;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    Connection connection;
    EditText txt,txt1;
    Button btn,btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connection= new Connection(this);
        SQLiteDatabase sqLiteDatabase=connection.getWritableDatabase();

        txt= (EditText) findViewById(R.id.text);
        txt1= (EditText) findViewById(R.id.text1);
        btn= (Button) findViewById(R.id.button);
        btn1= (Button) findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
    }

    public  void save(View v){

        String name=txt.getText().toString();

        if(v.getId()==R.id.button){

            long rowid=connection.insetData(name);

            if(rowid==-1){

                Toast.makeText(this, "Data not add Successfully", Toast.LENGTH_SHORT).show();
            }
            else {

                Toast.makeText(this, "Data add Successfully", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //database display data

    public  void see(View v){

        if(v.getId()==R.id.button1){

            Intent intent=new Intent(MainActivity.this,ListActivity.class);
            startActivity(intent);
        }
    }


    //database update data

    public  void update(View v){
        String name=txt.getText().toString();
        String id=txt1.getText().toString();


        if(v.getId()==R.id.button2){

            boolean isupdate=connection.updatedata(id,name);

            if(isupdate==true){

                Toast.makeText(this, "Update  Successfully", Toast.LENGTH_SHORT).show();
            }
            else {

                Toast.makeText(this, "Update not Successfully", Toast.LENGTH_SHORT).show();
            }
        }
    }

//database delete data

    public  void delete(View j){

        String id=txt1.getText().toString();

        if(j.getId()==R.id.button3){

            int val=connection.deletedata(id);
            if (val > 0) {

                Toast.makeText(this, "data delete Successfully", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "data delete not Successfully", Toast.LENGTH_SHORT).show();
        }
    }
}
