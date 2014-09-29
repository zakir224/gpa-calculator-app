package com.calc.cgpa.cgpacalculator.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.calc.cgpa.cgpacalculator.R;
import com.calc.cgpa.cgpacalculator.adapter.ResultAdapter;
import com.calc.cgpa.cgpacalculator.db.ResultRepo;
import com.calc.cgpa.cgpacalculator.model.SemesterResult;

import java.util.ArrayList;

/**
 * Created by Zakir on 9/17/2014.
 */
public class AboutFragment extends Fragment  {


    private View rootView;

    public AboutFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.about_fragment, container, false);

        return rootView;
    }

}
