package com.example.ibrhm.parentlock.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ibrhm on 15.03.2017.
 */

public class DbOperations {


    public void register(String message, MessageDB childDB) {
        SQLiteDatabase db = childDB.getWritableDatabase();

        ContentValues veriler = new ContentValues();

        veriler.put("message", message);
        db.insertOrThrow("command", null, veriler);

    }

    public Cursor getRegister(MessageDB childDb) {
        SQLiteDatabase db = childDb.getReadableDatabase();
        Cursor cursor = null;
        cursor = db.query("command", new String[]{"id", "message"}, null, null, null, null, null);
        return cursor;

    }
}