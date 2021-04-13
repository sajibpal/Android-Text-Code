package com.example.sajibpal.swipeslider;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by sajib pal on 9/22/2018.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

   private int tabnumber;

   public PagerAdapter(FragmentManager fm, int tabnum){

       super(fm);
       this.tabnumber=tabnum;

    }
    @Override
    public Fragment getItem(int position) {

        switch(position){
            case 0:
               return new Tab1();
            case 1:
                return new Tab2();
            case 2:
                return new Tab3();
        }
        return null;
    }

    @Override
    public int getCount() {

        return tabnumber;
    }
}
