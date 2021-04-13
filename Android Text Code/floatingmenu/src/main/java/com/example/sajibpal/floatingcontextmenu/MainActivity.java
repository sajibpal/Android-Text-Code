package com.example.sajibpal.floatingcontextmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ListView listView;
    String[] country_name;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= (ListView) findViewById(R.id.list);
        country_name=getResources().getStringArray(R.array.country);
        for(String item : country_name){

          arrayList.add(item);
        }
        adapter=new ArrayAdapter<String>(this,R.layout.row_text,R.id.text,arrayList);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.row_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
          switch (item.getItemId()){
              case R.id.delete:
                arrayList.remove(info.position);
                  adapter.notifyDataSetChanged();
                  return true;
              case R.id.share:
                  Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                  return true;
              case R.id.help:
                  Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show();
                  return true;
              default:
                  return super.onContextItemSelected(item);
          }

    }
}
