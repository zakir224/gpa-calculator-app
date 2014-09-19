package com.calc.cgpa.cgpacalculator.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.calc.cgpa.cgpacalculator.model.Credit;
import com.calc.cgpa.cgpacalculator.model.Grade;
import com.calc.cgpa.cgpacalculator.db.CreditRepo;
import com.calc.cgpa.cgpacalculator.db.GpaDbHelper;
import com.calc.cgpa.cgpacalculator.db.GradeRepo;

import java.io.File;

/**
 * Created by Zakir on 9/18/2014.
 */
public class DefaultPreferences {

    private static GradeRepo gradeRepo;
    private CreditRepo creditRepo;
    Context context;
    private Double[] credits = {1.0, 1.5, 2.0, 3.0};
    private String[] grades = {"A","A-","B+","B","B-","C+","C","C-","D+","D"};
    private Double[] gradePoints = {4.0, 3.67, 3.33, 3.00, 2.67, 2.33, 2.00, 1.67, 1.33, 1.00};

    public DefaultPreferences(Context context){
        gradeRepo = new GradeRepo(context);
        creditRepo = new CreditRepo(context);
        this.context = context;
    }

    public void setDefaultGrades(){
        for(int i=0;i<grades.length;i++){
           gradeRepo.AddGrade(new Grade(grades[i],gradePoints[i]));
        }
    }

    public void setDefaultCredits(){
        for(int i=0;i<credits.length;i++){
            creditRepo.AddCredit(new Credit(credits[i]));
        }
    }

    public boolean doesDatabaseExist() {
        File dbFile = context.getDatabasePath(GpaDbHelper.DATABASE_NAME);
        return dbFile.exists();
    }


    public void resetApp(){
        gradeRepo.resetRepo();
        setDefaultCredits();
        setDefaultGrades();
    }
}
