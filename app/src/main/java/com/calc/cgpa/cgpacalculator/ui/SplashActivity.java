package com.calc.cgpa.cgpacalculator.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.calc.cgpa.cgpacalculator.preference.DefaultPreferences;
import com.calc.cgpa.cgpacalculator.R;

public class SplashActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private static final String IS_FIRST_TIME = "isFirstTime";
    DefaultPreferences defaultPreferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().hide();
        setContentView(R.layout.splash);
        defaultPreferences = new DefaultPreferences(getBaseContext());
        if(!defaultPreferences.doesDatabaseExist()){
            defaultPreferences.setDefaultCredits();
            defaultPreferences.setDefaultGrades();
        }
        startActivity(new Intent(SplashActivity.this,MainActivity.class));
    }

    private void initializeApp() {

    }




}
