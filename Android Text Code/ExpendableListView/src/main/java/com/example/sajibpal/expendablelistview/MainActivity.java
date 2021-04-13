package com.example.sajibpal.expendablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListView listView;
    List<String> listheader;
    HashMap<String,List<String>> childheader;
    int lastexpendable=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareListData();
        listView=(ExpandableListView) findViewById(R.id.list);
        CustomAdapter adapter=new CustomAdapter(this,listheader,childheader);
        listView.setAdapter(adapter);

        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                String gname=listheader.get(groupPosition);
                Toast.makeText(MainActivity.this, "group name:"+gname, Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

               String childtext=childheader.get(listheader.get(groupPosition)).get(childPosition);
                Toast.makeText(MainActivity.this, childtext, Toast.LENGTH_SHORT).show();

                return false;
            }
        });
     listView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
         @Override
         public void onGroupExpand(int groupPosition) {

             if(lastexpendable!=-1 && lastexpendable!=groupPosition){

                 listView.collapseGroup(lastexpendable);

             }
             lastexpendable=groupPosition;
         }
      });

    }

    public  void prepareListData(){

       String[] parentdata=getResources().getStringArray(R.array.team);
       String[] childdata=getResources().getStringArray(R.array.coun);

        listheader=new ArrayList<>();
        childheader=new HashMap<>();

        for(int i=0; i<parentdata.length;i++){

         listheader.add(parentdata[i]);

         List<String> child=new ArrayList<>();
         child.add(childdata[i]);

         childheader.put(listheader.get(i),child);
        }
    }
}
