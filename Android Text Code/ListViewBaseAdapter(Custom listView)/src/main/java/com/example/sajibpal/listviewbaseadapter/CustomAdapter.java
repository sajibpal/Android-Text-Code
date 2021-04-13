package com.example.sajibpal.listviewbaseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sajib pal on 9/7/2018.
 */

public class CustomAdapter extends BaseAdapter {

    int[] flag1;
    String[] countryname;
    Context contex1;
    LayoutInflater inflater;

    CustomAdapter(Context contex,String[] cname, int[] flag){

        this.contex1=contex;
        this.countryname=cname;
        this.flag1=flag;

    }
    @Override
    public int getCount() {
        return countryname.length;
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

            inflater=(LayoutInflater) contex1.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.country,parent,false);
        }
       ImageView image1= (ImageView)convertView.findViewById(R.id.image);
        TextView text1= (TextView) convertView.findViewById(R.id.text);

        image1.setImageResource(flag1[position]);
        text1.setText(countryname[position]);
        return convertView;
    }
}
