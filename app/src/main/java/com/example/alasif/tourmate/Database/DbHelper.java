package com.example.alasif.tourmate.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "tourmate.db";
    public static final int DB_VERSION = 1;

    public static final String USER_TABLE = "users";
    public static final String BUDGET_TABLE = "budget";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASS = "password";

    public static final String BUDGET_COLUMN_ID = "_id";
    public static final String COLUMN_COST_DETAILS = "cost";
    public static final String COLUMN_AMOUNT = "amount";


    public static final String CREATE_TABLE_USER = "CREATE TABLE "
            + USER_TABLE + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_EMAIL + " TEXT,"
            + COLUMN_PASS + " TEXT);";

    public static final String CREATE_BUDGET_TABLE= "CREATE TABLE "
            + BUDGET_TABLE + "("
            + BUDGET_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_COST_DETAILS + " TEXT,"
            + COLUMN_AMOUNT + " TEXT);";

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_USER);
        sqLiteDatabase.execSQL(CREATE_BUDGET_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS "+ USER_TABLE);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS "+ BUDGET_TABLE);
        onCreate(sqLiteDatabase);
    }

}
