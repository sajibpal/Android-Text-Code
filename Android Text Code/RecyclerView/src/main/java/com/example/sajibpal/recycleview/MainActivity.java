package com.example.sajibpal.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Album> arrayList=new ArrayList<>();
    int[] img_id={R.drawable.bd,R.drawable.auatrila,R.drawable.india,R.drawable.oh,
            R.drawable.ok,R.drawable.sajib_duet};
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView= (RecyclerView) findViewById(R.id.recycle);
        layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        toolbar=(Toolbar) findViewById(R.id.tool);
        toolbar.setTitle("sajib pal");

        for(int id : img_id){

            arrayList.add(new Album(id));
        }

        adapter=new RecyclerShow(this,arrayList);
        recyclerView.setAdapter(adapter);
    }
}
