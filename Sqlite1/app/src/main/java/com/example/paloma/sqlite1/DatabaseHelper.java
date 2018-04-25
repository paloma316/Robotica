package com.example.paloma.sqlite1;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String Database_Name="students.db";
    public static final String table_Name = "studen";
    public static final String colun_Id="ID";
    public static final String colun_Name="Name";
    public static  final String colun_surname="Surname";

    public DatabaseHelper(Context context) {
        super(context, Database_Name, null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
sqLiteDatabase.execSQL("create  table  " + table_Name + " (ID INTEGER PRIMARY key autoincrement ,Name text,Surname text);" );


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL("drop table if exists "+ table_Name);
    onCreate(sqLiteDatabase);
    }
    public boolean insertData(String name,String surname){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(colun_Name,name);
        contentValues.put(colun_surname,surname);

        //sqliteDatabase.insert(table_name,null,contentValue)

       long result = sqLiteDatabase.insert(table_Name,null,contentValues);
        if(result==-1){
            return true;
        }else{
            return false;
        }
    }
}
