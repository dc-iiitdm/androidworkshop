package com.example.kamarajios33.alaram;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1;
    TextView t1;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.b1);
        t1=(TextView)findViewById(R.id.t1);
        e1=(EditText)findViewById(R.id.e1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startalert();

            }
        });
    }
    public void startalert()
    {
        int i = Integer.parseInt(e1.getText().toString());
        Intent in = new Intent(this,alaram.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),900000,in,0);
        AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+ (i*1000),pendingIntent);
        Toast.makeText(getApplicationContext(),"Alaram set in " + i + " Seconds",Toast.LENGTH_LONG).show();

    }
}
