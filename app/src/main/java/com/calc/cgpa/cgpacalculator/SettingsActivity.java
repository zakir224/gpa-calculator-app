package com.calc.cgpa.cgpacalculator;

import android.app.Activity;
import android.os.Bundle;



public class SettingsActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Tracer.info("Settings Activity onCreate");

        // Display the fragment as the main content.
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();

    }
}