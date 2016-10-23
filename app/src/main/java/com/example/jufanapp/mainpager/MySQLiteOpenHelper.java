package com.example.jufanapp.mainpager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.app.FragmentActivity;

/**
 * Created by w8888 on 2016/10/14.
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper{
    public MySQLiteOpenHelper(Context context) {
        super(context,"1409K",null,1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("create table video(id integer primary key autoincrement,midheadimg varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
