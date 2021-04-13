package com.example.sajibpal.grideview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by sajib pal on 9/8/2018.
 */

public class CustomAdapter extends BaseAdapter {

    int[] flag1;
    String[] name1;
    Context contex1;
    LayoutInflater inflater;


    CustomAdapter(Context contex,String[] cname, int[] flag){

        this.contex1=contex;
        this.name1=cname;
        this.flag1=flag;


    }
    @Override
    public int getCount() {
        return name1.length ;
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
            convertView=inflater.inflate(R.layout.data,parent,false);
        }
          ImageView image1=(ImageView) convertView.findViewById(R.id.image);
          TextView text1 =(TextView) convertView.findViewById(R.id.text);

        image1.setImageResource(flag1[position]);
        text1.setText(name1[position]);
        return convertView;
    }
}
