package com.example.kamarajios34.fontlistview;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    TextView txt;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          txt=(TextView)findViewById(R.id.textView);
          e1=(EditText)findViewById(R.id.edit1);
                listview=(ListView)findViewById(R.id.list);
        String[] values = new String[] {

                "Angilla Tattoo",
                "Xacto Blade",
                "Cantate Beveled",
                "Krinkes Decor PERSONAL",
                "Krinkes Regular PERSONAL",
                "Silent Reaction",
                "Sweetly Broken",
                "Xerox Sans Serif Narrow Bold",
                //"Xacto Blade"
        };


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,values);



        listview.setAdapter(adapter);


       listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {

                String itemValue = (String) listview.getItemAtPosition(position);

                if(itemValue.equals("Angilla Tattoo"))
                {
                    txt.setText(e1.getText().toString());
                    String fontPath="fonts/AngillaTattoo_PERSONAL_USE_ONLY.ttf";
                   Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
                   txt.setTypeface(tf);
                }

               if(itemValue.equals("Cantate Beveled"))
                {
                    txt.setText(e1.getText());
                    String fontPath="fonts/Cantate Beveled.ttf";
                    Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
                    txt.setTypeface(tf);
                }

                if(itemValue.equals("Krinkes Decor PERSONAL"))
                {
                    txt.setText(e1.getText());
                    String fontPath="fonts/KrinkesDecorPERSONAL.ttf";
                    Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
                    txt.setTypeface(tf);
                }

                if(itemValue.equals("Krinkes Regular PERSONAL"))
                {
                    txt.setText(e1.getText());
                    String fontPath="fonts/KrinkesRegularPERSONAL.ttf";
                    Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
                    txt.setTypeface(tf);
                }

                if(itemValue.equals("Silent Reaction"))
                {
                    txt.setText(e1.getText());
                    String fontPath="fonts/Silent Reaction.ttf";
                    Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
                    txt.setTypeface(tf);
                }

                if(itemValue.equals("Sweetly Broken"))

                {
                    txt.setText(e1.getText());
                    String fontPath="fonts/Sweetly Broken.ttf";
                    Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
                    txt.setTypeface(tf);
                }

                if(itemValue.equals("Xerox Sans Serif Narrow Bold"))
                {
                    txt.setText(e1.getText());
                    String fontPath="fonts/Xerox Sans Serif Narrow Bold.ttf";
                    Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
                    txt.setTypeface(tf);
                }

                if(itemValue.equals("Xacto Blade"))
                {
                    txt.setText(e1.getText());
                    String fontPath="fonts/Xacto Blade.ttf";
                    Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
                    txt.setTypeface(tf);
                }
            }
        });
    }
}

