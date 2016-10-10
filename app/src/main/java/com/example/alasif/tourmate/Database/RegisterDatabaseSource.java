package com.example.alasif.tourmate.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.alasif.tourmate.Model.RegisterModel;


public class RegisterDatabaseSource {
    DbHelper dbHelper;
    SQLiteDatabase database;
//    RegisterModel registerModel;

    public RegisterDatabaseSource(Context context) {
       dbHelper = new DbHelper(context);
    }

    public void open(){
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public void addUser(RegisterModel registerModel){
        this.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.COLUMN_USER_FIRST_NAME,registerModel.getFirstName());
        contentValues.put(dbHelper.COLUMN_USER_LAST_NAME,registerModel.getLastName());
        contentValues.put(dbHelper.COLUMN_USER_EMAIL,registerModel.getEmail());
        contentValues.put(dbHelper.COLUMN_USER_PASSWORD,registerModel.getPassword());

        long inserted = database.insert(dbHelper.USER_TABLE, null, contentValues);
        this.close();

    }

    public boolean getUser(String email, String password){

        String selectQuery =  "select * from " + DbHelper.USER_TABLE + " where " +
                DbHelper.COLUMN_USER_EMAIL + " = " + "'"+email+"'" + " and " + DbHelper.COLUMN_USER_PASSWORD + " = " + "'"+password+"'";
        this.open();
        database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery,null);
        cursor.moveToFirst();
        if(cursor.getCount() > 0){
            return true;
        }
        cursor.close();
        this.close();
        return false;
    }

    public int getUserID(String email){
        this.open();
        Cursor cursor = database.query(dbHelper.USER_TABLE,null, dbHelper.COLUMN_USER_EMAIL + " = '"+ email+"' " ,null,null,null,null);
        cursor.moveToFirst();
        int uID = cursor.getInt(cursor.getColumnIndex(dbHelper.COLUMN_USER_ID));
        this.close();
        return uID;
    }

    public String getUserLastName(int userId){
        this.open();
        Cursor cursor = database.query(dbHelper.USER_TABLE,null, dbHelper.COLUMN_USER_ID + " = '"+ userId+"' " ,null,null,null,null);
        cursor.moveToFirst();
        String userLastName = cursor.getString(cursor.getColumnIndex(dbHelper.COLUMN_USER_LAST_NAME));
        this.close();
        return userLastName;
    }
}
