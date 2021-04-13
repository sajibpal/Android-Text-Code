package com.example.sajibpal.databaselistview;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListView listView;
    Connection connection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        connection= new Connection(this);
        SQLiteDatabase sqLiteDatabase=connection.getWritableDatabase();

        listView= (ListView) findViewById(R.id.list);
        loaddata();
    }
   public  void loaddata(){

       final ArrayList<String> listdata=new ArrayList<>();
        Cursor cursor=connection.displaydata();

            if(cursor.getCount()==0){

                Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
            }

            while (cursor.moveToNext()) {

            listdata.add(cursor.getString(0)+"\t"+cursor.getString(1));
            }
       ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.list,R.id.txt,listdata);
       listView.setAdapter(adapter);

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               String  loc=parent.getItemAtPosition(position).toString();
               Toast.makeText(ListActivity.this, "Selected value"+loc, Toast.LENGTH_SHORT).show();
           }
       });
   }
}
