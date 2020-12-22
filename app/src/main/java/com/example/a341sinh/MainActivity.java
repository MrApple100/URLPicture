package com.example.a341sinh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button but= (Button) findViewById(R.id.but);
        AnotherThread anotherThread=new AnotherThread();
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()){
                    case R.id.but:
                        Bitmap pic;
                        try {
                            System.out.println("1");
                            URL url = new URL("http://developer.alexanderklimov.ru/blocks/header-cat.png");
                            InputStream instr=(InputStream) url.getContent();
                            System.out.println("2");
                            pic = BitmapFactory.decodeStream(instr);
                            instr.close();

                            ImageView MainImage = (ImageView) findViewById(R.id.MainImage);
                            MainImage.setImageBitmap(pic);

                        }catch(IOException e){ }
                       // anotherThread.start();
                }
            }
        };
        but.setOnClickListener(listener);
       handler=new Handler(){
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

            }
        };
    }
    public class AnotherThread extends Thread{
        @Override
        public void run() {
            super.run();
            handler.sendEmptyMessage(1);
        }
    }

}