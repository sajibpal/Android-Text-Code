package com.example.sajibpal.bottomvnavigationview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sajib pal on 11/14/2019.
 */

public class HomeFrame extends Fragment {

     public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home, container, false);
    }
}
