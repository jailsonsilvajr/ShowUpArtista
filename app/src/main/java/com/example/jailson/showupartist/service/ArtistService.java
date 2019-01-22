package com.example.jailson.showupartist.service;

import android.content.Context;

import com.example.jailson.showupartist.data.DataBaseAdapter;
import com.example.jailson.showupartist.entity.Artist;

public class ArtistService {

    private DataBaseAdapter dataBaseAdapter;

    private Artist artist;

    public ArtistService(Context context){

        this.dataBaseAdapter = new DataBaseAdapter(context);
    }

    public Artist loginArtist(String email, String password){

        if(email.equals("jailsonjosejr@gmail.com") && password.equals("1234")){

            return this.artist;
        }else{

            return null;
        }
    }
}
