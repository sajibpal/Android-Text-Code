package com.example.sajibpal.actionbarsearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView vlist;
    String[] coun;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vlist=(ListView) findViewById(R.id.list);

        coun=getResources().getStringArray(R.array.country);
        adapter=new ArrayAdapter<String>(MainActivity.this,R.layout.actionbar,R.id.txt,coun);
        vlist.setAdapter(adapter);

        vlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String name=adapter.getItem(position);
                Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
            }
        });


    }

    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_layout,menu);

        MenuItem menuItem=menu.findItem(R.id.name);
        SearchView show=(SearchView) menuItem.getActionView();
        show.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
        return super.onCreateOptionsMenu(menu);
    }
}
