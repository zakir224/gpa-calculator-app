package com.calc.cgpa.cgpacalculator.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.calc.cgpa.cgpacalculator.GradePointAverage;
import com.calc.cgpa.cgpacalculator.R;
import com.calc.cgpa.cgpacalculator.adapter.CreditAdapter;
import com.calc.cgpa.cgpacalculator.adapter.GradeAdapter;
import com.calc.cgpa.cgpacalculator.adapter.ResultAdapter;
import com.calc.cgpa.cgpacalculator.db.CreditRepo;
import com.calc.cgpa.cgpacalculator.db.GradeRepo;
import com.calc.cgpa.cgpacalculator.db.ResultRepo;
import com.calc.cgpa.cgpacalculator.model.Credit;
import com.calc.cgpa.cgpacalculator.model.Grade;
import com.calc.cgpa.cgpacalculator.model.SemesterResult;

import java.util.ArrayList;

/**
 * Created by Zakir on 9/17/2014.
 */
public class ResultDetailFragment extends Fragment  {



    String[] results;
    ArrayList<SemesterResult> semesterResults;

    private View rootView;
    private ListView listView;
    private ResultRepo resultRepo;
    private SemesterResult result;


    public ResultDetailFragment() {
        semesterResults = new ArrayList<SemesterResult>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_result_detail, container, false);
        resultRepo = new ResultRepo(getActivity());
        listView = (ListView)rootView.findViewById(R.id.list);
        semesterResults = resultRepo.getAll();
        results = new String[semesterResults.size()];
        int i=0;
        for(SemesterResult result : semesterResults) {
            results[i++] = result.getSemesterName()+"\t\t"+result.getSemesterTotalCredits()+"\t\t"+result.getSemesterGpa();
        }
        listView.setAdapter(new ResultAdapter(getActivity(),android.R.layout.simple_list_item_1,semesterResults));

        return rootView;
    }

}
