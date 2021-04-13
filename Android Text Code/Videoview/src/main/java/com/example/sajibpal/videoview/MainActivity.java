package com.example.sajibpal.videoview;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView video;
    MediaController controller;
    int position=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        video=(VideoView) findViewById(R.id.view);

        Uri uri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.dilber_hindi);
       // Uri uri=Uri.parse("https://www.youtube.com/watch?v=aRpoO3wBHfg");
        video.setVideoURI(uri);
        controller=new MediaController(this);
        controller.setAnchorView(video);
        video.setMediaController(controller);
        video.requestFocus();
        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                video.seekTo(position);
                 if(position==0){

                     video.start();
                 }
            }
        });
    }
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        // Store current position.
        savedInstanceState.putInt("CurrentPosition", video.getCurrentPosition());
        video.pause();
     }
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Get saved position.
        position = savedInstanceState.getInt("CurrentPosition");
        video.seekTo(position);
    }
}
