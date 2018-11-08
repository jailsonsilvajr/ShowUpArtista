package com.example.jailson.showupartista.service;

import com.example.jailson.showupartista.entidade.Artista;

public class ArtistaService {

    private Artista artista;

    public ArtistaService(){

        this.artista = new Artista();
        this.artista.setEmail("jailsonjosejr@gmail.com");
        this.artista.setSenha("1234");
    }

    public Artista loginArtista( String email, String senha){

        if(email.equals("jailsonjosejr@gmail.com") && senha.equals("1234")){

            return this.artista;
        }else{

            return null;
        }

    }
}
