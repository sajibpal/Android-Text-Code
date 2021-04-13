package com.example.sajibpal.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView vlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vlist=(ListView) findViewById(R.id.list);

        final String[] coun=getResources().getStringArray(R.array.country);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,R.layout.datastring,R.id.txt,coun);
        vlist.setAdapter(adapter);

        vlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String name=coun[position];
                Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
