package com.example.jailson.showupartist.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.jailson.showupartist.data.DataBaseAdapter;
import com.example.jailson.showupartist.entity.Artist;

public class ArtistService {

    private DataBaseAdapter dataBaseAdapter;

    public ArtistService(Context context){

        this.dataBaseAdapter = new DataBaseAdapter(context);
    }

    public boolean registerArtist(Artist artist){

        ContentValues values = new ContentValues();

        values.put("email", artist.getEmail());
        values.put("password", artist.getPassword());

        SQLiteDatabase db = dataBaseAdapter.getWritableDatabase();

        boolean isCreate = db.insert("artist", null, values) > 0;
        return isCreate;
    }

    public Artist loginArtist(String email, String password){

        Artist artist = new Artist();
        artist.setEmail(email);
        artist.setPassword(password);

        if(registerArtist(artist)){

            return artist;
        }else{

            return null;
        }
    }
}
