package com.example.jailson.showupartista.service;

import com.example.jailson.showupartista.entidade.Artist;

public class ArtistService {

    private Artist artist;

    public ArtistService(){

        this.artist = new Artist();
        this.artist.setEmail("jailsonjosejr@gmail.com");
        this.artist.setPassword("1234");
    }

    public Artist loginArtist(String email, String password){

        if(email.equals("jailsonjosejr@gmail.com") && password.equals("1234")){

            return this.artist;
        }else{

            return null;
        }
    }
}
