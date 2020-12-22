package com.example.a341sinh;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Picture {
    private URL address=null;
    private Bitmap pic=null;
    Picture(URL url) throws IOException{
            this.address = url;
            pic= BitmapFactory.decodeStream((InputStream) this.address.getContent());
    }

    public Bitmap getPic(){
        return pic;
    }

}
