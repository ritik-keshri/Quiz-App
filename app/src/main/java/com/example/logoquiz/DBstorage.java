package com.example.logoquiz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBstorage extends SQLiteOpenHelper {

    public DBstorage(@Nullable Context context) {
        super(context, "quiz.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table queDetails(Image BLOB private key,option1 text,option2 text,option3 text,option4 text,answer text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exist");
    }

}
