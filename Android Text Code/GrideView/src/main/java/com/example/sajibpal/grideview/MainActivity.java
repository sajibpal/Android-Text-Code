package com.example.sajibpal.grideview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;



public class MainActivity extends AppCompatActivity {
    GridView view;
    String[] name;

    int[] flag_image={R.drawable.bd,R.drawable.nepal,R.drawable.india,R.drawable.pakistan,
            R.drawable.butanflag,R.drawable.srilankaflag,R.drawable.auatrila};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view=(GridView) findViewById(R.id.ok);
        name=getResources().getStringArray(R.array.typ);
        CustomAdapter adapter=new CustomAdapter(this,name,flag_image);
        view.setAdapter(adapter);

        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

              /*  String value=name[position];
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();*/

                Intent intent = new Intent(MainActivity.this, ImageGallary.class);


                  intent.putExtra("image",flag_image[position]);
                 intent.putExtra("text",name[position]);
                 startActivity(intent);

            }
        });
    }
}
