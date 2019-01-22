package com.example.jailson.showupartist.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseAdapter extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    protected static final String DATABASE_NAME = "ShowUpArtist.DB";

    public DataBaseAdapter(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE artist " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "email TEXT, " +
                "password NUMBER)";

        db.execSQL(sql);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Falta criar método para backup!!
        String sql = "DROP TABLE IF EXISTS artist";
        db.execSQL(sql);
        onCreate(db);
    }
}
