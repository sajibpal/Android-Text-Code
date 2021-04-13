package com.example.sajibpal.spinnercustom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sajib pal on 9/8/2018.
 */

public class CustomAdapter extends BaseAdapter {
    String[] country;
    String[] popula;
    int[] flag1;
    Context context1;
    LayoutInflater inflater;

    public  CustomAdapter(Context context,int[] flag, String[] name,String[] populate){

        this.context1=context;
        this.flag1=flag;
        this.country=name;
        this.popula=populate;
    }
    @Override
    public int getCount() {
        return country.length;
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

            inflater=(LayoutInflater)context1.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.hoom,null,false);
        }
        ImageView iview= (ImageView) convertView.findViewById(R.id.view);
        iview.setImageResource(flag1[position]);

        TextView tex= (TextView) convertView.findViewById(R.id.text);
        tex.setText(country[position]);

        TextView tex1= (TextView) convertView.findViewById(R.id.text1);
        tex1.setText(popula[position]);

        return convertView;
    }
}
