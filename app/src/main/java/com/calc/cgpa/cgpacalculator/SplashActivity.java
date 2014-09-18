package com.calc.cgpa.cgpacalculator;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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
            Toast.makeText(getBaseContext(),"Application loading for the first time",Toast.LENGTH_SHORT).show();
        }
        startActivity(new Intent(SplashActivity.this,MainActivity.class));
        Toast.makeText(getBaseContext(),"Done",Toast.LENGTH_SHORT).show();
    }

    private void initializeApp() {

    }




}
