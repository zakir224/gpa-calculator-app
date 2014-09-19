package com.calc.cgpa.cgpacalculator.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Zakir on 9/18/2014.
 */
public class BaseRepo {
    GpaDbHelper gpaDbHelper;
    SQLiteDatabase dbReadable;
    SQLiteDatabase dbWritable;
    Context context;
    protected BaseRepo(Context context){
        this.context = context;
        gpaDbHelper = new GpaDbHelper(context);
    }

    protected void openReadableDb(){
        dbReadable = gpaDbHelper.getReadableDatabase();
    }

    protected void openWritableDb(){
        dbWritable = gpaDbHelper.getWritableDatabase();
    }

    protected void closeReadableDb(){
        dbReadable.close();
    }

    protected void closeWritableDb(){
        dbWritable.close();
    }
}
