package com.example.kamarajios34.guicomponents;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
TextView text;
    Button bu1,bu2,bu3;
    ImageView image1;
    ImageButton image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bu1=(Button) findViewById(R.id.b1);
        bu2=(Button) findViewById(R.id.b2);
        bu3=(Button) findViewById(R.id.b3);
        text=(TextView) findViewById(R.id.t1);
        image1=(ImageView)findViewById(R.id.img1);
        image2=(ImageButton)findViewById(R.id.imgb1);
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image1.setImageResource(R.drawable.corel);

            }
        });


        bu1.setOnClickListener(    new View.OnClickListener() {
            @Override
            public void onClick(View v) {

 
                    bu1.setBackgroundColor(Color.GREEN);
                    text.setTextColor(Color.GREEN);
                    bu2.setBackgroundColor(Color.LTGRAY);
                    bu3.setBackgroundColor(Color. LTGRAY);



            }
        });
        bu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bu2.setBackgroundColor(Color.RED);
                bu3.setBackgroundColor(Color.LTGRAY);
                bu1.setBackgroundColor(Color.LTGRAY);
                text.setTextColor(Color.RED);
            }
        });
        bu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bu3.setBackgroundColor(Color.BLUE);
                text.setTextColor(Color.BLUE);
                bu2.setBackgroundColor(Color.LTGRAY);
                bu1.setBackgroundColor(Color.LTGRAY);

            }
        });


        }

        }

