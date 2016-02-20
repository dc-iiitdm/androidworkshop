package com.example.kamarajios33.videourl;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3;
    VideoView v1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        v1=(VideoView)findViewById(R.id.vw);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1.start();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1.pause();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String path = "android.resource://"+ getPackageName() +"/"+R.raw.v;
                v1.setVideoURI(Uri.parse(path));
            }
        });

    }
}
