package com.example.crudone;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.security.PublicKey;

public class dbhandler extends SQLiteOpenHelper {

    private static final String name = "crudone";
    private static final int version = 1;

    public dbhandler(@Nullable Context context) {
        super(context, name,null, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS students(id INTEGER primary key AUTOINCREMENT,name string not null,roll integer not null) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String name,String roll)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("roll",Integer.parseInt(roll));
        sqLiteDatabase.insert("students",null,values);
    }
}









