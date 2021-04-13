package com.example.sajibpal.firebasenotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by sajib pal on 4/17/2019.
 */

public class Channel extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        showNotification(remoteMessage.getNotification().getBody());
    }

    public  void showNotification(String message){

       PendingIntent pi=PendingIntent.getActivity(this,0,new Intent(this,MainActivity.class),0);
        Notification notification=new NotificationCompat.Builder(this)
                .setSmallIcon(android.R.drawable.ic_dialog_alert)
                .setContentTitle("spal")
                .setContentText(message)
                .setContentIntent(pi)
                .setAutoCancel(true)
                .build();

        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0,notification);
    }
}
