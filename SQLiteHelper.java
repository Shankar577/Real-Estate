package com.example.hp.realestateapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    static String DATABASE_NAME="examDataBase";

    public static final String KEY_ID="id";

    public static final String TABLE_NAME="login";

    public static final String KEY_lnm="lnm";

    public static final String KEY_fnm="fnm";

    public static final String KEY_unm="unm";

    public static final String KEY_pwd="pwd";

    public SQLiteHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ("+KEY_ID+" INTEGER PRIMARY KEY, "+KEY_lnm+" VARCHAR, "+KEY_fnm+" VARCHAR, "+KEY_unm+" VARCHAR, "+KEY_pwd+" VARCHAR)";
        //database.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }


}