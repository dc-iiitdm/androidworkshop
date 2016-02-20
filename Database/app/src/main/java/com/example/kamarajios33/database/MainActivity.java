package com.example.kamarajios33.database;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    String f,l,e;
    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = openOrCreateDatabase("Mydb",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(fname VARCHAR,lname VARCHAR,email VARCHAR);");

    }

    public void Adddata(View view)
    {
        EditText e1 = (EditText)findViewById(R.id.e1);
        EditText e2 = (EditText)findViewById(R.id.e2);
        EditText e3 = (EditText)findViewById(R.id.e3);
        f = e1.getText().toString();
        l=e2.getText().toString();
        e=e3.getText().toString();
        db.execSQL("INSERT INTO student VALUES('"+f+"','"+l+"','"+e+"');");
        Toast.makeText(getApplicationContext(),"Row Inserted",Toast.LENGTH_SHORT).show();
    }
    public void close(View view)
    {
        System.exit(0);
    }
    public void showdata(View view)
    {
        //Toast.makeText(getApplicationContext(),"Show Data",Toast.LENGTH_LONG).show();
        Intent i = new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(i);
    }

}

