package com.example.sajibpal.videoads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class MainActivity extends AppCompatActivity implements RewardedVideoAdListener{

    RewardedVideoAd mVideoAds;
    TextView txtreward;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtreward= (TextView) findViewById(R.id.reward);
        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");//app-id hare

        mVideoAds=MobileAds.getRewardedVideoAdInstance(this);
        mVideoAds.setRewardedVideoAdListener(this);
        loadReawardAds(); //VideoAds function call

    }

    private void loadReawardAds() {

      if(!mVideoAds.isLoaded()){

          mVideoAds.loadAd("ca-app-pub-3940256099942544/5224354917",
                  new AdRequest.Builder().build()); //Rewarded video ads id

      }


    }

    public void VideoAdsShow(View v){

       if(mVideoAds.isLoaded()){

           mVideoAds.show(); //add show
       }
    }

    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {

        loadReawardAds();
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {

        txtreward.setText("Available Coin :10");
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

    @Override
    protected void onPause() {

        mVideoAds.pause(this);
        super.onPause();
    }

    @Override
    protected void onResume() {

        mVideoAds.resume(this);
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        mVideoAds.destroy(this);
        super.onDestroy();
    }
}
