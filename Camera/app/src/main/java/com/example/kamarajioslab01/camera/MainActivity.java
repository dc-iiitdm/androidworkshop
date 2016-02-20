package com.example.kamarajioslab01.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.util.BitSet;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4;
    ImageView i;
    final int CAMERA_REQUEST = 1888;
    Bitmap photo;
    MediaPlayer m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);
        i = (ImageView)findViewById(R.id.i);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);
        m = MediaPlayer.create(MainActivity.this,R.raw.sam);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(in,CAMERA_REQUEST);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    getApplicationContext().setWallpaper(photo);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(), "Wallpaper set", Toast.LENGTH_LONG).show();
            }

        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.start();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.pause();
            }
        });
    }

    protected void onActivityResult(int requestcode,int resultcode,Intent data)
    {
        if(requestcode==CAMERA_REQUEST)
        {
            photo=(Bitmap)data.getExtras().get("data");
            i.setImageBitmap(photo);
        }

    }
}
