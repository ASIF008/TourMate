package com.example.alasif.tourmate.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.alasif.tourmate.Model.EventModel;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "tourmate.db";
    public static final int DB_VERSION = 5;

    public static final String USER_TABLE = "users";
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_USER_NAME = "name";
    public static final String COLUMN_USER_EMAIL = "email";
    public static final String COLUMN_USER_PASSWORD = "password";

    public static final String CREATE_USER_TABLE ="create table "+USER_TABLE+"( "+COLUMN_USER_ID+" integer primary key, "+COLUMN_USER_NAME+" text, "+COLUMN_USER_EMAIL+" TEXT, "+COLUMN_USER_PASSWORD+" text);";

    public static final String EVENT_TABLE = "events";
    public static final String COLUMN_EVENT_ID = "id";
    public static final String COLUMN_EVENT_NAME = "event_name";
    public static final String COLUMN_EVENT_START_DATE = "start_date";
    public static final String COLUMN_EVENT_END_DATE = "end_date";
    public static final String COLUMN_USER_ID_FOREIGNKEY = "user_id_foreign_key";

    public static final String CREATE_EVENT_TABLE = "CREATE TABLE "
            + EVENT_TABLE + "("
            + COLUMN_EVENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_EVENT_NAME + " TEXT,"
            + COLUMN_EVENT_START_DATE + " TEXT,"
            + COLUMN_EVENT_END_DATE + " TEXT,"
            + COLUMN_USER_ID_FOREIGNKEY + " TEXT,"
            + " FOREIGN KEY ("+COLUMN_USER_ID_FOREIGNKEY+") REFERENCES "+USER_TABLE+"("+COLUMN_USER_ID+"));";


    public static final String BUDGET_TABLE = "budget";
    public static final String COLUMN_BUDGET_ID = "id";
    public static final String COLUMN_BUDGET_DETAILS = "budget_details";
    public static final String COLUMN_BUDGET_AMOUNT = "budget_amount";
    public static final String COLUMN_EVENT_ID_FOREIGNKEY = "user_id_foreign_key_for_budget";

    public static final String CREATE_BUDGET_TABLE ="create table "+BUDGET_TABLE+"( "+COLUMN_BUDGET_ID+" integer primary key, "+COLUMN_BUDGET_DETAILS+" text, "+COLUMN_BUDGET_AMOUNT+" text, "+COLUMN_EVENT_ID_FOREIGNKEY+" text, "+" foreign key ("+COLUMN_EVENT_ID_FOREIGNKEY+") references "+EVENT_TABLE+"("+COLUMN_EVENT_ID+"));";
    public static final String MOMENT_TABLE = "moments";
    public static final String COLUMN_MOMENT_ID = "id";
    public static final String COLUMN_MOMENT_PHOTO = "photoes";
    public static final String COLUMN_MOMENT_CAPTION = "captions";
    public static final String COLUMN_MOMENT_DATE = "date";
    public static final String COLUMN_MOMENT_TIME = "time";
    public static final String COLUMN_EVENT_ID_FOREIGNKEY_TWO = "user_id_foreign_key_for_moment";

    public static final String CREATE_MOMENT_TABLE = "CREATE TABLE "
            + MOMENT_TABLE + "("
            + COLUMN_MOMENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_MOMENT_PHOTO + " TEXT,"
            + COLUMN_MOMENT_CAPTION + " TEXT,"
            + COLUMN_MOMENT_DATE + " TEXT,"
            + COLUMN_MOMENT_TIME + " TEXT,"
            + COLUMN_EVENT_ID_FOREIGNKEY_TWO + " TEXT,"
            + " FOREIGN KEY ("+COLUMN_EVENT_ID_FOREIGNKEY_TWO+") REFERENCES "+EVENT_TABLE+"("+COLUMN_EVENT_ID+"));";

    public static final String EXPENSE_TABLE = "expense";
    public static final String COLUMN_EXPENSE_ID = "id";
    public static final String COLUMN_EXPENSE_DETAILS = "expense_details";
    public static final String COLUMN_EXPENSE_AMOUNT = "expense_amount";
    public static final String COLUMN_EVENT_ID_FOREIGNKEY_THREE = "user_id_foreign_key_for_expense";

    public static final String CREATE_EXPENSE_TABLE ="create table "+EXPENSE_TABLE+"( "+COLUMN_EXPENSE_ID+" integer primary key, "+COLUMN_EXPENSE_DETAILS+" TEXT, " +COLUMN_EXPENSE_AMOUNT+ " TEXT, "+COLUMN_EVENT_ID_FOREIGNKEY_THREE+" TEXT, "+" FOREIGN KEY ("+COLUMN_EVENT_ID_FOREIGNKEY_THREE+") REFERENCES "+EVENT_TABLE+"("+COLUMN_EVENT_ID+"));";

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
        sqLiteDatabase.execSQL(CREATE_EVENT_TABLE);
        sqLiteDatabase.execSQL(CREATE_BUDGET_TABLE);
        sqLiteDatabase.execSQL(CREATE_MOMENT_TABLE);
        sqLiteDatabase.execSQL(CREATE_EXPENSE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS "+ USER_TABLE);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS "+ EVENT_TABLE);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS "+ BUDGET_TABLE);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS "+ MOMENT_TABLE);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS "+ EXPENSE_TABLE);
        onCreate(sqLiteDatabase);
    }

    /*public ArrayList<EventModel> getAllEvents(String loggedUserId){

        ArrayList<EventModel> eventModels = new ArrayList<>();
        this.open();

        //Cursor cursor=sqLiteDatabase.query(dbHelper.EVENT_TABLE,null,dbHelper.COLUMN_USER_ID_FOREIGNKEY+" = "+loggedUserId,null,null,null,null);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.execSQL("select" + DbHelper.COLUMN_EVENT_NAME + "," + DbHelper.COLUMN_EVENT_START_DATE + "," + DbHelper.COLUMN_EVENT_END_DATE + "from "+DbHelper.USER_TABLE + "," + DbHelper.EVENT_TABLE +" where "+DbHelper.COLUMN_USER_ID+"='"+DbHelper.COLUMN_USER_ID_FOREIGNKEY+"'");


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
    }*/

}
