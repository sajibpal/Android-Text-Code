package com.example.sajibpal.table;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView vlist;
    String[] nam;
    String[] id1;
    String[] depart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vlist=(ListView) findViewById(R.id.list);
        nam=getResources().getStringArray(R.array.name);
        id1=getResources().getStringArray(R.array.id);
        depart=getResources().getStringArray(R.array.dep);

        CustomAdapter adapter=new CustomAdapter(this,nam,id1,depart);
        vlist.setAdapter(adapter);

    }
}
