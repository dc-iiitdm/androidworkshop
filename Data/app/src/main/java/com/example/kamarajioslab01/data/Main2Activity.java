package com.example.kamarajioslab01.data;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {
    Button pre,next,home;
    TextView f1,l1,e1;
    SQLiteDatabase db;
    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        pre = (Button)findViewById(R.id.prv);
        next = (Button)findViewById(R.id.next);
        home = (Button)findViewById(R.id.exit);
        f1=(TextView)findViewById(R.id.fn);
        l1=(TextView)findViewById(R.id.ln);
        e1=(TextView)findViewById(R.id.em);
        db=openOrCreateDatabase("Mydb",MODE_PRIVATE,null);
         c = db.rawQuery("select * from student",null);
        c.moveToFirst();
             display();
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                System.exit(0);
            }

        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    c.moveToNext();
                    display();
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Last Record",Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });

        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    c.moveToPrevious();
                    display();
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"First Record",Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });

    }
    public void display()
    {
        f1.setText(c.getString(c.getColumnIndex("fname")));
        l1.setText(c.getString(c.getColumnIndex("lname")));
        e1.setText(c.getString(c.getColumnIndex("email")));

    }

}
