package com.example.alasif.tourmate.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.alasif.tourmate.Model.EventModel;

import java.util.ArrayList;

/**
 * Created by asif on 9/18/16.
 */
public class EventDatabaseSource {
    DbHelper dbHelper;
    EventModel eventModel;
    SQLiteDatabase sqLiteDatabase;

    public EventDatabaseSource(Context context) {
        dbHelper = new DbHelper(context);
    }
    public void open(){
        sqLiteDatabase=dbHelper.getWritableDatabase();
    }
    public void close(){
        sqLiteDatabase.close();
    }

    public void addEvent(EventModel eventModel){
        this.open();

        ContentValues contentValues=new ContentValues();
        contentValues.put(DbHelper.COLUMN_EVENT_NAME,eventModel.getEventName());
        contentValues.put(DbHelper.COLUMN_EVENT_START_DATE,eventModel.getEventStartDate());
        contentValues.put(DbHelper.COLUMN_EVENT_END_DATE,eventModel.getEventEndDate());

        long inserted=sqLiteDatabase.insert(DbHelper.EVENT_TABLE,null,contentValues);

        this.close();

    }

    public ArrayList<EventModel> getAllEvents(){

        ArrayList<EventModel> eventModels = new ArrayList<>();
        this.open();

        Cursor cursor=sqLiteDatabase.rawQuery("select * from "+DbHelper.EVENT_TABLE,null);

        if(cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            for(int i=0;i<cursor.getCount();i++){

                int id = cursor.getInt(cursor.getColumnIndex(DbHelper.COLUMN_EVENT_ID));
                String eventName = cursor.getString(cursor.getColumnIndex(DbHelper.COLUMN_EVENT_NAME));
                String eventStartDate = cursor.getString(cursor.getColumnIndex(DbHelper.COLUMN_EVENT_START_DATE));
                String eventEndDate = cursor.getString(cursor.getColumnIndex(DbHelper.COLUMN_EVENT_END_DATE));
                eventModel = new EventModel(eventName, eventStartDate, eventEndDate);
                cursor.moveToNext();
                eventModels.add(eventModel);
            }
        }
        cursor.close();
        this.close();
        return eventModels;
    }
}
