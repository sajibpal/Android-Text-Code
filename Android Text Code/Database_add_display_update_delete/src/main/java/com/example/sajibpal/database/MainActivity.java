package com.example.sajibpal.database;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Connection connection;
    EditText txt,txt1,txt2,txt3;
    Button btn,btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     /*database connection code start*/
        connection= new Connection(this);
        SQLiteDatabase sqLiteDatabase=connection.getWritableDatabase();

      /*database connection code end*/

        txt= (EditText) findViewById(R.id.text);
        txt1= (EditText) findViewById(R.id.text1);
        txt2= (EditText) findViewById(R.id.text2);
        txt3= (EditText) findViewById(R.id.text3);
        btn= (Button) findViewById(R.id.button);
        btn1= (Button) findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);

    }
  //database add/save data
    public  void save(View v){

       String name=txt.getText().toString();
       String age=txt1.getText().toString();
       String gender=txt2.getText().toString();

        if(v.getId()==R.id.button){

            long rowid=connection.insetData(name,age,gender);

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

         Cursor cursor=connection.displaydata();
           if(cursor.getCount()==0){

               showdata("Error","No data");
               return;
           }
         StringBuffer buffer=new StringBuffer();

         while (cursor.moveToNext()) {
             buffer.append("Id : " + cursor.getString(0) + "\n");
             buffer.append("Name : " + cursor.getString(1) + "\n");
             buffer.append("Age : " + cursor.getString(2) + "\n");
             buffer.append("Gender : " + cursor.getString(3) + "\n\n");
         }
        showdata("ResultSet",buffer.toString());
       }
    }
   public  void showdata(String title,String data){

       AlertDialog.Builder dialog=new AlertDialog.Builder(this);
       dialog.setTitle(title);
       dialog.setMessage(data);
       dialog.setCancelable(true);
       dialog.show();
   }
  //database update data
  public  void update(View v){
      String name=txt.getText().toString();
      String age=txt1.getText().toString();
      String gender=txt2.getText().toString();
      String id=txt3.getText().toString();

     if(v.getId()==R.id.button2){

        boolean isupdate=connection.updatedata(id,name,age,gender);

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

      String id=txt3.getText().toString();

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
