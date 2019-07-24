package com.example.mymusique;




import android.app.Notification;

import android.app.Service;
import android.content.Intent;

import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;


import androidx.core.app.NotificationCompat;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;


import static com.example.mymusique.App.CHANNELL_ID;


public class MyService extends Service    {


    Notification notification;



    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(MyService.this,"rani fi on Bind",Toast.LENGTH_LONG).show();



        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(MyService.this,"rani fe onCreate",Toast.LENGTH_LONG).show();


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(MyService.this,"rani fi start Command",Toast.LENGTH_LONG).show();

        MainActivity.listener=new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if(!b)
                    youTubePlayer.loadVideo("FbpD5RZtbCc");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d("error",youTubeInitializationResult.toString());

            }
        };
        MainActivity.youTubePlayerView.initialize("AIzaSyCBErj1JmwzTqidcUo16QsqUfpDSPfONzQ",MainActivity.listener);

       RemoteViews views=new RemoteViews(getPackageName(),R.layout.custom_notification);
        RemoteViews views2=new RemoteViews(getPackageName(),R.layout.small_notification);
        notification=new NotificationCompat.Builder(this,CHANNELL_ID)
                .setContentTitle("Youtube")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setCustomContentView(views2)
                .setCustomBigContentView(views)
                .build();


        startForeground(1,notification);





         return START_STICKY;
    }


}
