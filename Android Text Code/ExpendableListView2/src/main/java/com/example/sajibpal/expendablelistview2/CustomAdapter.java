package com.example.sajibpal.expendablelistview2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by sajib pal on 9/14/2018.
 */

public class CustomAdapter extends BaseExpandableListAdapter {

    List<String> listheader1;
    HashMap<String,List<String>> childheader1;
    Context context1;

    public CustomAdapter( Context context,List<String> listheader, HashMap<String, List<String>> childheader) {
        this.listheader1 = listheader;
        this.childheader1 = childheader;
        this.context1 = context;
    }

    @Override
    public int getGroupCount() {
        return listheader1.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childheader1.get(listheader1.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listheader1.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childheader1.get(listheader1.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String headertext=(String) getGroup(groupPosition);
        if(convertView==null){

            LayoutInflater inflater=(LayoutInflater) context1.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.group_layout,null);
        }
        TextView textView=(TextView) convertView.findViewById(R.id.view);
        textView.setText(headertext);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        String headertext=(String) getChild(groupPosition,childPosition);
        if(convertView==null){

            LayoutInflater inflater=(LayoutInflater) context1.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.child_layout,null);
        }
        TextView textView=(TextView) convertView.findViewById(R.id.cview);
        textView.setText(headertext);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
