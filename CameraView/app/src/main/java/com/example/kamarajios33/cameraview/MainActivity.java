package com.example.kamarajios33.cameraview;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {
    private static final int CAMERA_REQUEST= 1888;
    String p;
    ImageView i;
    Button bu,wall,b3;
    Bitmap photo;
    ToggleButton t;
    MediaPlayer m;
    int flag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i=(ImageView)findViewById(R.id.img);
        bu=(Button)findViewById(R.id.b1);
        wall=(Button)findViewById(R.id.wall);
        b3=(Button)findViewById(R.id.b3);
        t=(ToggleButton)findViewById(R.id.tb);
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(in,CAMERA_REQUEST);
            }
        });

        m = MediaPlayer.create(MainActivity.this,R.raw.sam);

        wall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (flag == 1) {
                        getApplicationContext().setWallpaper(BitmapFactory.decodeFile(p));
                        Toast.makeText(getApplicationContext(), "Wallpaper Changed from Gallery", Toast.LENGTH_SHORT).show();
                    } else if (flag == 2) {
                        getApplicationContext().setWallpaper(photo);
                        Toast.makeText(getApplicationContext(), "Wallpaper Changed from Camera", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Wallpaper Not Set", Toast.LENGTH_SHORT).show();
                    }
                }
              catch (Exception e)
              {
                  e.printStackTrace();
              }
            }

        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in1 = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(in1,2);

            }
        });
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((ToggleButton) v).isChecked();
                if(checked)

                {
                    m.start();
                    t.setText("Media Player On");
                }
                else
                {
                    m.pause();
                    t.setText("Media Player Pause");
                }
            }
        });

    }

protected void  onActivityResult(int requestcode,int resultcode,Intent data)
{
    if(requestcode==CAMERA_REQUEST)
    {
        photo    = (Bitmap)data.getExtras().get("data");
        i.setImageBitmap(photo);
        flag =2;
    }
    if(requestcode==2 && resultcode == RESULT_OK)
    {
        Uri sel = data.getData();
        String[] file ={MediaStore.Images.Media.DATA};
        Cursor c = getContentResolver().query(sel, file, null, null, null);
        c.moveToFirst();

        int co = c.getColumnIndex(file[0]);
        p = c.getString(co);
        c.close();
        i.setImageBitmap(BitmapFactory.decodeFile(p));
        flag = 1;
    }

}
}


