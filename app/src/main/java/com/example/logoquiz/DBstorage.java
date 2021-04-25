package com.example.logoquiz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class DBstorage extends SQLiteOpenHelper {
    public static final String tableName = "que_table";

    public DBstorage(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db = this.getWritableDatabase();
        db.execSQL("create table if not exists "+ tableName +"(id primary key autoincrement,Image BLOB,option1 text,option2 text,option3 text,option4 text,answer text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void insertData(byte[] img, String col2, String col3, String col4, String col5, String col6) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "insert into " + tableName + " values(NULL,?,?,?,?,?,?)";

        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();

        statement.bindBlob(1, img);
        statement.bindString(2, col2);
        statement.bindString(3, col3);
        statement.bindString(4, col4);
        statement.bindString(5, col5);
        statement.bindString(6, col6);

        statement.executeInsert();
    }

}
