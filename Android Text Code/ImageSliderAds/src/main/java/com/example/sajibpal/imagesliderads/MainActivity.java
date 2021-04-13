package com.example.sajibpal.imagesliderads;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {


    InterstitialAd minterstialad;
    ViewPager pager;
    String[] name;
    int[] images={R.drawable.sajib_duet,R.drawable.rajibpal,R.drawable.maingait};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");//app id

        pager=(ViewPager) findViewById(R.id.page);
        name=getResources().getStringArray(R.array.nam);
        CustomAdapter adapter=new CustomAdapter(this,name,images);
        pager.setAdapter(adapter);

        minterstialad = new InterstitialAd(this);
        minterstialad.setAdUnitId("ca-app-pub-3940256099942544/1033173712");// InterstitialAdd id
        minterstialad.loadAd(new AdRequest.Builder().build());

//Image slider properity all
  pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

      }

      @Override
      public void onPageSelected(int position) {

          if(position%2==0){ //slider Image je number index %2 ==0 ex: 2,4,6,8.... position image ids show

              minterstialad.show();
          }
      }

      @Override
      public void onPageScrollStateChanged(int state) {

      }
  });

        //for ads close new ads load hobe
        minterstialad.setAdListener(new AdListener(){

            @Override
            public void onAdClosed() {

                minterstialad.loadAd(new AdRequest.Builder().build());
            }
        });

    }
}
