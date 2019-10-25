package com.jatin.sqlitecrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteOpenHelperMy extends SQLiteOpenHelper
{
    SQLiteDatabase db;
    String q = "create table IF NOT EXISTS student (rollno INTEGER, name TEXT, course TEXT)";
    SQLiteOpenHelperMy(Context context, String dbName, SQLiteDatabase.CursorFactory factory, int dbVersion)
    {
        super(context, dbName, factory, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        this.db = db;
        db.execSQL(q);
        Log.e("dbJv","Database Created...");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("drop table if exists student");
        onCreate(db);
    }


    public void insertData()
    {
        db = getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("rollno",1004);
        contentValues.put("name","Geeta");
        contentValues.put("course","MCA");
        db.insert("student",null,contentValues);
    }

    public String viewData()
    {
        db = getReadableDatabase();
        StringBuilder s = new StringBuilder("");
        Cursor cursor= db.rawQuery("select * from student",null);
        while (cursor.moveToNext())
        {
            s.append(cursor.getString(0)+"\t");
            s.append(cursor.getString(1)+"\t");
            s.append(cursor.getString(2)+"\n");
        }
        return s.toString();
    }

    public void deleteData()
    {
        db = getWritableDatabase();
        db.delete("student","rollno = ?",new String[]{"1004"});
    }
    public void updateData()
    {
        db = getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("rollno",1004);
        contentValues.put("name","Geetu");
        contentValues.put("course","MCA");
        db.update("student",contentValues,"rollno = ?",new String[]{"1004"});
    }
}
