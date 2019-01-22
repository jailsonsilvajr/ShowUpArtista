package com.example.jailson.showupartist.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Artist implements Parcelable {

    private String email;
    private String password;

    public Artist(){}

    private Artist(Parcel in){

        email = in.readString();
        password = in.readString();
    }

    public static final Parcelable.Creator<Artist>
            CREATOR = new Parcelable.Creator<Artist>() {

        public Artist createFromParcel(Parcel in) {
            return new Artist(in);
        }

        public Artist[] newArray(int size) {
            return new Artist[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(email);
        dest.writeString(password);
    }

    public String getEmail() {

        return email;
    }

    public String getPassword() {

        return password;
    }

    public void setEmail(String login) {

        this.email = login;
    }

    public void setPassword(String password) {

        this.password = password;
    }
}
