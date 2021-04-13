package com.example.sajibpal.wifi;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    WifiManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       manager= (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
    }

    public  void wifion(View n){

        manager.setWifiEnabled(true);

    }

    public  void wifioff(View n){

     manager.setWifiEnabled(false);
    }

}
