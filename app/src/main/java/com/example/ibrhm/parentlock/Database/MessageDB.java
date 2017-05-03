package com.example.ibrhm.parentlock.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ibrhm on 15.03.2017.
 */

public class MessageDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME   = "message15";
    // Contacts table name
    private static final String TABLE_COUNTRIES = "command";
    public MessageDB(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE command (id INTEGER PRIMARY KEY AUTOINCREMENT,message TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE If EXIST command");
        onCreate(db);


    }
}

