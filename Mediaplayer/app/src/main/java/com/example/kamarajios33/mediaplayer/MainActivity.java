package com.example.kamarajios33.mediaplayer;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    Button b3,b4,b5,b6;
    SeekBar seekbar;
    TextView txt1,txt2;
    double finaltime =0;
    double starttime=0;
    int forw = 5000;
    int bacw = 5000;
    int one =0;
    Handler h = new Handler();
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.play);
        b2=(Button)findViewById(R.id.pause);
        b3=(Button)findViewById(R.id.button);
        b4=(Button)findViewById(R.id.button2);
        b5=(Button)findViewById(R.id.button3);
        b6=(Button)findViewById(R.id.button4);

        txt1=(TextView)findViewById(R.id.txt1);
        txt2=(TextView)findViewById(R.id.txt2);
        seekbar =(SeekBar)findViewById(R.id.seekBar);
       mediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.sam);
        txt1.setText("Sam.mp3");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                finaltime = mediaPlayer.getDuration();
                starttime = mediaPlayer.getCurrentPosition();
                if (one == 0) {
                    seekbar.setMax((int) finaltime);
                    one = 1;
                }
                seekbar.setProgress((int) starttime);
               h.postDelayed(UpdateSongTime, 100);

            }
        });

        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.seekTo(0);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.seekTo((int)mediaPlayer.getDuration());

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int)starttime;

                if((temp+forw)<=finaltime){
                    starttime = starttime + forw;
                    mediaPlayer.seekTo((int) starttime);
                    Toast.makeText(getApplicationContext(), "You have Jumped forward 5 seconds", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Cannot jump forward 5 seconds",Toast.LENGTH_SHORT).show();
                }
            }


        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int)starttime;

                if((temp-bacw)>0){
                    starttime = starttime - bacw;
                    mediaPlayer.seekTo((int) starttime);
                    Toast.makeText(getApplicationContext(),"You have Jumped backward 5 seconds",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Cannot jump backward 5 seconds",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
    protected Runnable UpdateSongTime;

    {
        UpdateSongTime = new Runnable() {
            public void run() {
                starttime = mediaPlayer.getCurrentPosition();
                seekbar.setProgress((int) starttime);
                h.postDelayed(this, 100);
                int tmps,tmpm,tmpr;
                tmps = (int) (starttime/1000);
                tmpm = tmps/60;
                tmpr = tmps%60;
                txt2.setText(String.valueOf(tmpm) + " Mins " +String.valueOf(tmpr) + " Seconds");

            }
        };
    }
}
