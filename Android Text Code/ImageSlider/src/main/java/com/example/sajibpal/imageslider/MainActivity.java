package com.example.sajibpal.imageslider;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;
    String[] name;
    int[] images={R.drawable.sajib_duet,R.drawable.rajibpal,R.drawable.maingait};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager=(ViewPager) findViewById(R.id.page);
        name=getResources().getStringArray(R.array.nam);
        CustomAdapter adapter=new CustomAdapter(this,name,images);
        pager.setAdapter(adapter);
    }
}
