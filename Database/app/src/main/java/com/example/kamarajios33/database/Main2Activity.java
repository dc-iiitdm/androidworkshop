package com.example.kamarajios33.database;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText fn,ln,em;
    Button next,back,prev;
    SQLiteDatabase db;
    Integer j =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        fn=(EditText)findViewById(R.id.fn);
        ln=(EditText)findViewById(R.id.ln);
        em=(EditText)findViewById(R.id.em);
        back =(Button)findViewById(R.id.button2);
        next=(Button)findViewById(R.id.button);
        prev=(Button)findViewById(R.id.b3);

        db = openOrCreateDatabase("Mydb",MODE_PRIVATE,null);


        final Cursor c = db.rawQuery("select * from student",null);
        c.moveToFirst();
        fn.setText(c.getString(c.getColumnIndex("fname")));
        ln.setText(c.getString(c.getColumnIndex("lname")));
        em.setText(c.getString(c.getColumnIndex("email")));



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent il = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(il);
                System.exit(0);

            }

        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    c.moveToNext();
                    fn.setText(c.getString(c.getColumnIndex("fname")));
                    ln.setText(c.getString(c.getColumnIndex("lname")));
                    em.setText(c.getString(c.getColumnIndex("email")));
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Last Record",Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    c.moveToPrevious();
                    fn.setText(c.getString(c.getColumnIndex("fname")));
                    ln.setText(c.getString(c.getColumnIndex("lname")));
                    em.setText(c.getString(c.getColumnIndex("email")));
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"First Record",Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });

    }



}
