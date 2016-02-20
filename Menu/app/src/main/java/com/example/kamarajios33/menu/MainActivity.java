package com.example.kamarajios33.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu pm = new PopupMenu(MainActivity.this,b1);
                pm.getMenuInflater().inflate(R.menu.menu,pm.getMenu());
                pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.one:
                                Intent o = new Intent(getApplicationContext(), second.class);
                                startActivity(o);
                                System.exit(0);
                                break;
                            case R.id.two:
                                Intent in = new Intent(getApplicationContext(),third.class);
                                startActivity(in);
                                System.exit(0);
                                break;
                        }

                        return false;
                    }
                });

                pm.show();
            }
        });
    }
}
