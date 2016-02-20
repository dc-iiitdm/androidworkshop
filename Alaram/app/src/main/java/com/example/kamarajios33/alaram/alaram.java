package com.example.kamarajios33.alaram;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.*;


/**
 * Created by kamarajios33 on 13/11/15.
 */
public class alaram extends BroadcastReceiver {
    MediaPlayer m;
    public void onReceive(Context context,Intent intent)
    {
        m = MediaPlayer.create(context,R.raw.cine1);
        m.start();
        Toast.makeText(context, "Alarm....Get up", Toast.LENGTH_LONG).show();
    }
}
