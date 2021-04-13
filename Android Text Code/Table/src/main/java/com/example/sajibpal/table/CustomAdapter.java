package com.example.sajibpal.table;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sajib pal on 9/18/2018.
 */

public class CustomAdapter extends BaseAdapter {
    String[] nam2;
    String[] id2;
    String[] depart2;
    Context context1;
    LayoutInflater  inflater;

    public CustomAdapter(Context context,String[] nam, String[] id, String[] depart) {
        this.nam2 = nam;
        this.id2 = id;
        this.depart2 = depart;
        this.context1 = context;
    }

    @Override
    public int getCount() {

        return nam2.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if(convertView==null){

            inflater=(LayoutInflater) context1.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.tableview,parent,false);
        }

        TextView tt1= (TextView) convertView.findViewById(R.id.txt1);
        tt1.setText(nam2[position]);
        TextView tt2= (TextView) convertView.findViewById(R.id.txt2);
        tt2.setText(id2[position]);
        TextView tt3= (TextView) convertView.findViewById(R.id.txt3);
        tt3.setText(depart2[position]);

        return convertView;

    }
}
