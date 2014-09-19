package com.calc.cgpa.cgpacalculator.db;

import android.content.Context;
import android.widget.Toast;

import com.calc.cgpa.cgpacalculator.model.Credit;

import java.util.ArrayList;

/**
 * Created by Zakir on 9/18/2014.
 */
public class CreditRepo extends BaseRepo {

    public CreditRepo(Context context) {
        super(context);
    }

    public ArrayList<Credit> getAll(){
        ArrayList<Credit> credits;

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

    public void createOrUpdateCreditPreference(Credit credit){
        openReadableDb();
          if(((Credit)gpaDbHelper.getCredit(credit.getCreditId(),dbReadable)).getCreditValue()!=0.0){
              gpaDbHelper.updateCredit(credit, dbReadable);
          } else
              gpaDbHelper.insertCredit(credit,dbReadable);

        closeReadableDb();
    }

    public void deleteCreditPreference(Credit credit) {
        openWritableDb();
        gpaDbHelper.deleteCredit(credit,dbWritable);
        closeWritableDb();
    }
}
