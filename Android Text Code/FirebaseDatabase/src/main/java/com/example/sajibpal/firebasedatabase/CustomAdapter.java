package com.example.sajibpal.firebasedatabase;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

/**
 * Created by sajib pal on 4/12/2019.
 */

public class CustomAdapter extends ArrayAdapter<Student> {

    Activity context;
    List<Student> studentList;

    public CustomAdapter(Activity context, List<Student> studentList) {
        super(context,R.layout.list_item,studentList);

        this.context = context;
        this.studentList = studentList;
    }



    public View getView(int position,View convertView,ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();
        View view=inflater.inflate(R.layout.list_item,null,true);
        Student student=studentList.get(position);



        TextView t1= (TextView) view.findViewById(R.id.txt);
        TextView t2= (TextView) view.findViewById(R.id.txt1);

        t1.setText("Name : "+student.getName());
        t2.setText("Age : "+student.getAge());

        return view;
    }
}
