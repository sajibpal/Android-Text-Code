package com.example.sajibpal.listviewbaseadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView vlist;
    String[] cname;
    int[] flag={R.drawable.bd,R.drawable.nepal,R.drawable.india,R.drawable.pakistan,
            R.drawable.butanflag,R.drawable.srilankaflag,R.drawable.auatrila};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vlist=(ListView) findViewById(R.id.list);

        cname=getResources().getStringArray(R.array.country);

        CustomAdapter adapter=new CustomAdapter(this,cname,flag);
        vlist.setAdapter(adapter);

        vlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String value=cname[position];
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
