package com.example.mymusique;

import android.content.Intent;

import android.os.Bundle;


import android.widget.Button;
import android.widget.LinearLayout;


import com.google.android.youtube.player.YouTubeBaseActivity;



import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;



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


         startService(new Intent(this,WalkingIconService.class));






    }



}
