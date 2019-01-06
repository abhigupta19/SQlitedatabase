package com.sar.user.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class Sqlite extends SQLiteOpenHelper
{
    public static final String databasename="student.db";
public static final String table_name="student table";
    public static final String col1="ID";
    public static final String col2="NAME";
    public static final String col3="SIRNAME";
    public static final String col4="MARKS";
    public Sqlite( @Nullable Context context) {
        super(context,databasename,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + "studenttable" + " (  ID INTEGER primary key AUTOINCREMENT ,NAME TEX ,SIRNAME TEXT,MARKS INTEGER )" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     db.execSQL(" DROP TABLE IF EXISTS "+"studenttable");
     onCreate(db);
    }
    public boolean insert(String a,String b,String c)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col2,a);
        contentValues.put(col3,b);
        contentValues.put(col4,c);
        long ab=db.insert("studenttable",null,contentValues);
        if (ab!=-1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public Cursor showall()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from studenttable",null);
        return cursor;
    }
}


