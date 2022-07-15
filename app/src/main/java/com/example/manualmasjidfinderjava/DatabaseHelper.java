package com.example.manualmasjidfinderjava;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    static final String dbName = "demoDB";
    static final String employeeTable = "Employees";
    static final String colID = "EmployeeID";
    static final String colName = "EmployeeName";
    static final String colAge = "Age";
    static final String colDept = "Dept";

    static final String deptTable = "Dept";
    static final String colDeptID = "DeptID";
    static final String colDeptName = "DeptName";

    static final String viewEmps = "ViewEmps";

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public DatabaseHelper(Context context) {
        super(context, dbName, null,33);
    }
}
