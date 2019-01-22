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

    public boolean registerArtist(String email, String password){

        Cursor cursor = searchArtist(email);

        if(!cursor.moveToFirst()){

            ContentValues values = new ContentValues();
            values.put("email", email);
            values.put("password", password);

            SQLiteDatabase db = dataBaseAdapter.getWritableDatabase();
            boolean isCreate = db.insert("artist", null, values) > 0;
            db.close();
            return isCreate;
        }else{

            return false;
        }
    }

    public Artist loginArtist(String email, String password){

        Cursor cursor = searchArtist(email);

        if(cursor.moveToFirst()){

            if(cursor.getString(cursor.getColumnIndex("password")).equals(password)){

                Artist artist = new Artist();
                artist.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex("id"))));
                artist.setEmail(cursor.getString(cursor.getColumnIndex("email")));
                artist.setPassword(cursor.getString(cursor.getColumnIndex("password")));
                return artist;
            }else{

                return null;
            }
        }else{

            return null;
        }
    }

    public Cursor searchArtist(String email){

        SQLiteDatabase db = this.dataBaseAdapter.getReadableDatabase();
        String sql = "SELECT * " +
                "FROM artist " +
                "WHERE email = \'" + email + "\'";

        return db.rawQuery(sql, null);
    }
}
