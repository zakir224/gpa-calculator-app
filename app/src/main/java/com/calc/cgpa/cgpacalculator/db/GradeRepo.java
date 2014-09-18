package com.calc.cgpa.cgpacalculator.db;

import android.content.Context;

import com.calc.cgpa.cgpacalculator.model.Grade;

import java.util.ArrayList;

/**
 * Created by Zakir on 9/18/2014.
 */
public class GradeRepo extends BaseRepo {

    public GradeRepo(Context context) {
        super(context);
    }

    public ArrayList<Grade> getAll(){
        ArrayList<Grade> grades;// = new ArrayList<Credit>();

        openReadableDb();
        grades = gpaDbHelper.getGradeEntries(dbReadable);
        closeReadableDb();

        return grades;
    }

    public void AddGrade(Grade grade){
        openWritableDb();
        gpaDbHelper.insertGrade(grade,dbWritable);
        closeWritableDb();
    }
}
