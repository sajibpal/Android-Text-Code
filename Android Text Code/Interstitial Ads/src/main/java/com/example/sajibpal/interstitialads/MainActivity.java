package com.example.sajibpal.interstitialads;


import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    AdView mAdView;
    InterstitialAd minterstialad;
    long backpresstime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");//app id

       // for show banner app
         mAdView = (AdView) findViewById(R.id.adView);
         AdRequest adRequest = new AdRequest.Builder().build();
         mAdView.loadAd(adRequest);


     //for what time after Interstitial add show

        interstitialAdshow();//Ads function  call

       ScheduledExecutorService schedulerExecutorService = Executors.newSingleThreadScheduledExecutor();
        schedulerExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                        if (minterstialad.isLoaded()) { //if add loaded hoy
                            minterstialad.show();//add show
                        } else {
                            Log.d("TAG", "The interstitial wasn't loaded yet.");
                        }

                        minterstialad.setAdListener(new AdListener(){ //add close after next add load for show

                            @Override
                            public void onAdClosed() {

                             //for timer delay next add load
                                Handler handler=new Handler();

                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        interstitialAdshow();

                                    }
                                },40000); //after 40 second next add load hobe

                            }
                        });

                    }
                });
            }
        },10,10,TimeUnit.SECONDS); //after 20 second add show and every 1 second add show if add load



    }

    private void interstitialAdshow() {

        minterstialad = new InterstitialAd(this);
        minterstialad.setAdUnitId("ca-app-pub-3940256099942544/1033173712");// InterstitialAdd id
        minterstialad.loadAd(new AdRequest.Builder().build());
    }


 // if back button presses then show interstitial Add
  /*  public void  onBackPressed(){

        if (minterstialad.isLoaded()) {

            minterstialad.show();
             minterstialad.setAdListener(new AdListener(){

                @Override
                public void onAdClosed() {

                    super.onAdClosed();
                    finish();
                }
            });

        } else {
            super.onBackPressed();
        }
    }  */

  //FOr Activity to Other Activity go ads Show
 /* public  void ActivityAdsshow(View view){

      if (minterstialad.isLoaded()) {

          minterstialad.show();

          minterstialad.setAdListener(new AdListener(){
              @Override
              public void onAdClosed() {

                  startActivity(new Intent(MainActivity.this,Main2Activity.class));
                  minterstialad.loadAd(new AdRequest.Builder().build());
              }
          });

      } else {  //Ads show na Loaded hole new Activity chole jabe

        startActivity(new Intent(MainActivity.this,Main2Activity.class));

      }
  }  */

}
