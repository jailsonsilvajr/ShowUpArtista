package com.example.jailson.showupartista.entidade;

import android.os.Parcel;
import android.os.Parcelable;

public class Artista implements Parcelable {

    private String email;
    private String senha;

    public Artista(){}

    private Artista(Parcel in){

        email = in.readString();
        senha = in.readString();
    }

    public static final Parcelable.Creator<Artista>
            CREATOR = new Parcelable.Creator<Artista>() {

        public Artista createFromParcel(Parcel in) {
            return new Artista(in);
        }

        public Artista[] newArray(int size) {
            return new Artista[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(email);
        dest.writeString(senha);
    }

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
