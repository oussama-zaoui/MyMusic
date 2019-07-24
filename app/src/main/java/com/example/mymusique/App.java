package com.example.mymusique;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;




public class App extends Application  {

    public static final String CHANNELL_ID="service";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannel();
    }


    public void createNotificationChannel(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel serviceChanell=new NotificationChannel(
                    CHANNELL_ID,
                    "essayeService",
                    NotificationManager.IMPORTANCE_HIGH
            );

            NotificationManager manager=getSystemService(NotificationManager.class);

            manager.createNotificationChannel(serviceChanell);

        }

    }
}
