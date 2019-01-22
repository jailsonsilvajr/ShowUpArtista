package com.example.jailson.showupartist.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

        SQLiteDatabase db = this.dataBaseAdapter.getWritableDatabase();

        boolean isCreate = db.insert("artist", null, values) > 0;
        db.close();
        return isCreate;
    }

    public Artist loginArtist(String email, String password){

        SQLiteDatabase db = this.dataBaseAdapter.getReadableDatabase();
        String sql = "SELECT * " +
                "FROM artist " +
                "WHERE email = \'" + email + "\'"+
                " AND password = " + password;

        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){

            Artist artist = new Artist();
            artist.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex("id"))));
            artist.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            artist.setPassword(cursor.getString(cursor.getColumnIndex("password")));
            return artist;
        }else{

            return null;
        }
    }
}
