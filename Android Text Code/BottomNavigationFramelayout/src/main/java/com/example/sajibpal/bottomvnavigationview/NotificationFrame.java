package com.example.sajibpal.bottomvnavigationview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by sajib pal on 11/14/2019.
 */

public class NotificationFrame extends Fragment {

    TextView txt;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View ok=  inflater.inflate(R.layout.notifaction, container, false);

               txt= (TextView) ok.findViewById(R.id.notifi);

             txt.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {

                     txt.setText("Sajib is Good");
                 }
             });
           return ok;
    }
}
