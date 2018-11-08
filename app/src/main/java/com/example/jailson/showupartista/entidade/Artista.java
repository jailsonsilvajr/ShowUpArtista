package com.example.jailson.showupartista.entidade;

public class Artista {

    private String email;
    private String senha;

    public Artista(){}

    public String getEmail() {

        return email;
    }

    public String getSenha() {

        return senha;
    }

    public void setEmail(String login) {

        this.email = login;
    }

    public void setSenha(String senha) {

        this.senha = senha;
    }
}
