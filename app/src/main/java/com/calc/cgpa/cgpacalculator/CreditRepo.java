package com.calc.cgpa.cgpacalculator;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Zakir on 9/18/2014.
 */
public class CreditRepo extends BaseRepo {

    public CreditRepo(Context context) {
        super(context);
    }

    public ArrayList<Credit> getAll(){
        ArrayList<Credit> credits;// = new ArrayList<Credit>();

        openReadableDb();
        credits = gpaDbHelper.getCreditEntries(dbReadable);
        closeReadableDb();

        return credits;
    }

    public void AddCredit(Credit credit){
        openWritableDb();
        gpaDbHelper.insertCredit(credit,dbWritable);
        closeWritableDb();
    }
}
