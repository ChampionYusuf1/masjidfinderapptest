package com.example.manualmasjidfinderjava;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper{
    private static final String DB_NAME = "db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "locations";
    private static final String LAT_COL = "lat";
    private static final String LONG_COL = "long";


    public DBHandler(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate (SQLiteDatabase db){
        String query = "CREATE TABLE " + TABLE_NAME + "(" +
                LAT_COL + "int, "
                + LONG_COL + "int)";
        db.execSQL(query);
        db.execSQL("INSERT INTO " + TABLE_NAME + "(" + LAT_COL + ", " + LONG_COL + ")" + " VALUES (0,0);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public String returnData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String result = "";
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        while(cursor.moveToNext()){
            result = cursor.getString(0);
        }
        return result;
    }
}