package com.example.sajibpal.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by sajib pal on 9/23/2018.
 */

public class MessageFragmeni extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

         View view=inflater.inflate(R.layout.message,container,false);

            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("text/plane");

            String subject="Text Message";
            String body="Hi this my first app \n Test is now ok ";

            intent.putExtra(Intent.EXTRA_SUBJECT,subject);
            intent.putExtra(Intent.EXTRA_TEXT,body);
            startActivity(intent.createChooser(intent,"Share with"));

        return view;
    }


}
