package com.example.mymusique;

import android.Manifest;
import android.content.Intent;

import android.content.pm.PermissionInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;


import android.provider.Settings;
import android.widget.Button;
import android.widget.LinearLayout;


import androidx.core.app.ActivityCompat;

import com.google.android.youtube.player.YouTubeBaseActivity;



import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.security.Permission;
import java.security.Permissions;


public class MainActivity extends YouTubeBaseActivity {


    Button button;


      static YouTubePlayerView youTubePlayerView;

      static YouTubePlayer.OnInitializedListener listener;
       static LinearLayout layout;


  /* public MainActivity(YouTubePlayer.OnInitializedListener listener){
        this.listener=listener;
    }*/






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);

        youTubePlayerView=findViewById(R.id.player_view);
        layout = findViewById(R.id.lin);

        Intent intent = new Intent(this,MyService.class);


        if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(this)) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.SYSTEM_ALERT_WINDOW},
                    1);
            /*Intent i = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:" + getPackageName()));
            startActivityForResult(i, Integer.parseInt(Manifest.permission.SYSTEM_ALERT_WINDOW));*/
        }

         startService(new Intent(this,WalkingIconService.class));






    }



}
