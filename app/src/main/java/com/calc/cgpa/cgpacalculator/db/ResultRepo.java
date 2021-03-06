package com.calc.cgpa.cgpacalculator.db;

import android.content.Context;

import com.calc.cgpa.cgpacalculator.model.SemesterResult;

import java.util.ArrayList;

/**
 * Created by Zakir on 9/18/2014.
 */
public class ResultRepo extends BaseRepo{

    public ResultRepo(Context context) {
        super(context);
    }

    public ArrayList<SemesterResult> getAll(){
        ArrayList<SemesterResult> semesterResults;// = new ArrayList<Credit>();

        openReadableDb();
        semesterResults = gpaDbHelper.getSemesterResultEntries(dbReadable);
        closeReadableDb();

        return semesterResults;
    }

    public void addGrade(SemesterResult semesterResult){
        openWritableDb();
        gpaDbHelper.insertSemesterResult(semesterResult,dbWritable);
        closeWritableDb();
    }
}
