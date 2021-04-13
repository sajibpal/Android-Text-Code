package com.example.sajibpal.navigationdrawer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by sajib pal on 9/23/2018.
 */

public class MailFragmeni extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.mail,container,false);

        Button btn =(Button) view.findViewById(R.id.button);

         btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                if(v.getId()==R.id.button) {

                    Toast.makeText(getActivity(), "Hi sajib", Toast.LENGTH_SHORT).show();
                }
             }
         });
        return view;

    }
}
