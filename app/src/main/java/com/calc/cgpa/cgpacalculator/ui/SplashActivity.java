package com.calc.cgpa.cgpacalculator.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
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
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getActionBar().hide();
        setContentView(R.layout.splash);
        defaultPreferences = new DefaultPreferences(getBaseContext());
        if(!defaultPreferences.doesDatabaseExist()){
            defaultPreferences.setDefaultCredits();
            defaultPreferences.setDefaultGrades();
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
            }
        },3000);

    }

}
