package com.example.kamarajios33.kcet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class third extends AppCompatActivity {
    Button b3;
    Intent in3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);
        b3 = (Button) findViewById(R.id.h1);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                in3 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in3);
            }
        });

    }
}
