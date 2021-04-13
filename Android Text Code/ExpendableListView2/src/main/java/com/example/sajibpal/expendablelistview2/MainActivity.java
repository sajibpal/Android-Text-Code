package com.example.sajibpal.expendablelistview2;

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

        listheader=new ArrayList<>();
        childheader=new HashMap<>();

        listheader.add("1. Cricket teams");
        listheader.add("2. Football teams");
        listheader.add("3. basketball teams");
        listheader.add("4. Hokey teams");
        listheader.add("5. Baseball teams");
        listheader.add("6. Golob teams");

      List<String> cricket=new ArrayList<>();
        cricket.add("India");
        cricket.add("Pakistan");
        cricket.add("Australia");
        cricket.add("England");
        cricket.add("South Africa");

        List<String> football = new ArrayList<>();
        football.add("Brazil");
        football.add("Spain");
        football.add("Germany");
        football.add("Netherlands");
        football.add("Italy");

        List<String> basketball = new ArrayList<>();
        basketball.add("United States");
        basketball.add("Spain");
        basketball.add("Argentina");
        basketball.add("France");
        basketball.add("Russia");

        childheader.put(listheader.get(0),cricket);
        childheader.put(listheader.get(1),football);
        childheader.put(listheader.get(2),basketball);
    }
}
