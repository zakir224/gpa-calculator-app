package com.calc.cgpa.cgpacalculator.ui;

import android.app.Activity;
import android.os.Bundle;

import com.calc.cgpa.cgpacalculator.ui.fragment.SettingsFragment;


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