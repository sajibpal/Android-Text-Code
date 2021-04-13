package com.example.sajibpal.imageslider;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by sajib pal on 9/19/2018.
 */

public class CustomAdapter extends PagerAdapter {
    String[] name1;
    int[] images1;
    Context context1;
    LayoutInflater inflater;


    public CustomAdapter(Context context,String[] nam, int[] image) {

        this.context1=context;
        this.name1=nam;
        this.images1=image;
    }

    @Override
    public int getCount() {

        return name1.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        inflater = (LayoutInflater) context1.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       View ok = inflater.inflate(R.layout.imagepage, container, false);
       TextView txt=(TextView) ok.findViewById(R.id.text);
        txt.setText(name1[position]);
        ImageView ima =(ImageView)ok.findViewById(R.id.imag);
        ima.setImageResource(images1[position]);

        container.addView(ok);
        return ok;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((LinearLayout)object);
    }
}
