package com.example.manualmasjidfinderjava;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "LocationHandler";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "MasjidLocations";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our latitude column
    private static final String LATITUDE_COL = "lat";

    // below variable is for our longitude column
    private static final String LONGITUDE_COL = "long";


    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + LATITUDE_COL + " TEXT,"
                + LONGITUDE_COL + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);

        String initializer = "INSERT INTO " + TABLE_NAME + "(idCol, latCol, longCol) VALUES " +
                "(1, 41.944271719952326, -88.1840428154465)," + //icws
                "(2, 42.01908492194405, -88.2404171354376)," + //iie
                "(3, 41.903242194423456, -88.0452914577771);";//darussalaam
        db.execSQL(initializer);
        db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


}