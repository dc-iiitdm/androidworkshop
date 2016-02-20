package com.example.kamarajioslab01.data;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3;
    SQLiteDatabase db;
    EditText f,l,e;
    String fname,lname,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=openOrCreateDatabase("Mydb",MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS STUDENT(fname VARCHAR,lname VARCHAR,email VARCHAR);");
        Toast.makeText(getApplicationContext(),"Database Creatd",Toast.LENGTH_LONG).show();
    }

    public void AddData(View view)
    {
        f = (EditText)findViewById(R.id.fname);
        l = (EditText)findViewById(R.id.lname);
        e = (EditText)findViewById(R.id.email);
        fname = f.getText().toString();
        lname=l.getText().toString();
        email=e.getText().toString();
        String check ="INSERT INTO STUDENT VALUES('"+fname+"','"+lname+"','"+email+"');";
        //Toast.makeText(getApplicationContext(),check,Toast.LENGTH_LONG).show();
        db.execSQL("INSERT INTO STUDENT VALUES('"+fname+"','"+lname+"','"+email+"');");
        Toast.makeText(getApplicationContext(),"Row Inserted",Toast.LENGTH_LONG).show();
        clear();
    }
    public void showdata(View view)
    {
        Intent i = new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(i);
        System.exit(0);
    }
    public void close(View view)
    {
        System.exit(0);
    }
    public void clear()
    {
        f.setText("");
        l.setText("");
        e.setText("");

    }

}
