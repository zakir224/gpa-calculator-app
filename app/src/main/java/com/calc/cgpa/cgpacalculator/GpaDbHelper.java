package com.calc.cgpa.cgpacalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zakir on 9/18/2014.
 */
public class GpaDbHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String LOG="GPA Calculator";
    public static final String DATABASE_NAME = "gpacalc.db";
    private static final String KEY_ID = "id";

    private static final String CREATE_TABLE_GRADE = "CREATE TABLE IF NOT EXISTS "
            + GPAContract.GradeEntry.TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY," + GPAContract.GradeEntry.COLUMN_NAME_GRADE_NAME
            + " TEXT,"+ GPAContract.GradeEntry.COLUMN_NAME_GRADE_POINT+" REAL)";

    private static final String CREATE_TABLE_CREDIT = "CREATE TABLE IF NOT EXISTS "
            + GPAContract.CreditEntry.TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY," + GPAContract.CreditEntry.COLUMN_NAME_CREDIT_VALUE
            + " REAL)";

    private static final String CREATE_TABLE_SEMESTER_RESULT = "CREATE TABLE IF NOT EXISTS "
            + GPAContract.SemesterResultEntry.TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY," + GPAContract.SemesterResultEntry.COLUMN_NAME_SEMESTER_NAME
            + " TEXT,"+ GPAContract.SemesterResultEntry.COLUMN_NAME_SEMESTER_GPA+" REAL,"+ GPAContract.SemesterResultEntry.COLUMN_NAME_SEMESTER_TOTAL_CREDITS+" REAL)";

    public GpaDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CREDIT);
        db.execSQL(CREATE_TABLE_GRADE);
        db.execSQL(CREATE_TABLE_SEMESTER_RESULT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_CREDIT);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_GRADE);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_SEMESTER_RESULT);
        onCreate(db);
    }

    public ArrayList<Grade> getGradeEntries(SQLiteDatabase db){
        ArrayList<Grade> grades = new ArrayList<Grade>();
        String selectQuery = "SELECT  * FROM " + GPAContract.GradeEntry.TABLE_NAME;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Grade grade = new Grade();
                grade.setGradeId(c.getInt((c.getColumnIndex(KEY_ID))));
                grade.setGradeName((c.getString(c.getColumnIndex(GPAContract.GradeEntry.COLUMN_NAME_GRADE_NAME))));
                grade.setGradePoint((c.getDouble(c.getColumnIndex(GPAContract.GradeEntry.COLUMN_NAME_GRADE_POINT))));
                grades.add(grade);
            } while (c.moveToNext());
        }

        return grades;
    }

    public ArrayList<Credit> getCreditEntries(SQLiteDatabase db){
        ArrayList<Credit> credits = new ArrayList<Credit>();
        String selectQuery = "SELECT  * FROM " + GPAContract.CreditEntry.TABLE_NAME;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Credit grade = new Credit();
                grade.setCreditId(c.getInt((c.getColumnIndex(KEY_ID))));
                grade.setCreditValue((c.getDouble(c.getColumnIndex(GPAContract.CreditEntry.COLUMN_NAME_CREDIT_VALUE))));
                credits.add(grade);
            } while (c.moveToNext());
        }

        return credits;
    }

    public ArrayList<SemesterResult> getSemesterResultEntries(SQLiteDatabase db){
        ArrayList<SemesterResult> semesterResults = new ArrayList<SemesterResult>();
        String selectQuery = "SELECT  * FROM " + GPAContract.GradeEntry.TABLE_NAME;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                SemesterResult semesterResult = new SemesterResult();
                semesterResult.setSemesterId(c.getInt((c.getColumnIndex(KEY_ID))));
                semesterResult.setSemesterName((c.getString(c.getColumnIndex(GPAContract.SemesterResultEntry.COLUMN_NAME_SEMESTER_NAME))));
                semesterResult.setSemesterGpa((c.getDouble(c.getColumnIndex(GPAContract.SemesterResultEntry.COLUMN_NAME_SEMESTER_GPA))));
                semesterResult.setSemesterTotalCredits((c.getDouble(c.getColumnIndex(GPAContract.SemesterResultEntry.COLUMN_NAME_SEMESTER_TOTAL_CREDITS))));
                semesterResults.add(semesterResult);
            } while (c.moveToNext());
        }

        return semesterResults;
    }

    public void insertCredit(Credit con,SQLiteDatabase db) {

        try {
            ContentValues values = new ContentValues();
            values.put(GPAContract.CreditEntry.COLUMN_NAME_CREDIT_VALUE, con.getCreditValue());
            long value = db.insert(GPAContract.CreditEntry.TABLE_NAME, null, values);
            Log.d("value",String.valueOf(value));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertGrade(Grade grade,SQLiteDatabase db) {

        try {
            ContentValues values = new ContentValues();
            values.put(GPAContract.GradeEntry.COLUMN_NAME_GRADE_NAME, grade.getGradeName());
            values.put(GPAContract.GradeEntry.COLUMN_NAME_GRADE_POINT, grade.getGradePoint());
            long value = db.insert(GPAContract.GradeEntry.TABLE_NAME, null, values);
            Log.d("value",String.valueOf(value));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertSemesterResult(SemesterResult semesterResult,SQLiteDatabase db) {

        try {
            ContentValues values = new ContentValues();
            values.put(GPAContract.SemesterResultEntry.COLUMN_NAME_SEMESTER_NAME, semesterResult.getSemesterName());
            values.put(GPAContract.SemesterResultEntry.COLUMN_NAME_SEMESTER_GPA, semesterResult.getSemesterGpa());
            values.put(GPAContract.SemesterResultEntry.COLUMN_NAME_SEMESTER_TOTAL_CREDITS, semesterResult.getSemesterTotalCredits());
            long value = db.insert(GPAContract.SemesterResultEntry.TABLE_NAME, null, values);
            Log.d("value",String.valueOf(value));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
