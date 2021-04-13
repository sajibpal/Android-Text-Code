package com.example.sajibpal.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView vlist;
    SearchView searchView;
    String[] coun;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vlist=(ListView) findViewById(R.id.list);
        searchView=(SearchView) findViewById(R.id.ser);

         coun=getResources().getStringArray(R.array.country);
         adapter=new ArrayAdapter<String>(MainActivity.this,R.layout.good,R.id.txt,coun);
         vlist.setAdapter(adapter);

         searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        vlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String name=adapter.getItem(position);
                Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
