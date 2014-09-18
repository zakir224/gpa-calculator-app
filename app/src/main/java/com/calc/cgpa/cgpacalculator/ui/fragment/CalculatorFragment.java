package com.calc.cgpa.cgpacalculator.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import com.calc.cgpa.cgpacalculator.model.Credit;
import com.calc.cgpa.cgpacalculator.model.Grade;
import com.calc.cgpa.cgpacalculator.GradePointAverage;
import com.calc.cgpa.cgpacalculator.R;
import com.calc.cgpa.cgpacalculator.adapter.CreditAdapter;
import com.calc.cgpa.cgpacalculator.adapter.GradeAdapter;
import com.calc.cgpa.cgpacalculator.db.CreditRepo;
import com.calc.cgpa.cgpacalculator.db.GradeRepo;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by Zakir on 9/17/2014.
 */
public class CalculatorFragment extends Fragment implements CreditAdapter.CreditSelectedListener, GradeAdapter.GradeSelectedListener {

    private LinkedHashMap<Integer, Button> creditButtons;
    private LinkedHashMap<Integer, Button> gradeButtons;
//    private double[] credits = {1.0, 1.5, 2.0, 3.0};
//    private double[] gradePoints = {4.0, 3.67, 3.33, 3.00, 2.67, 2.33, 2.00, 1.67, 1.33, 1.00};
//    private String[] grades = {"A","A-","B+","B","B-","C+","C","C-","D+","D"};
    Double[] gradesPoints;
    Double[] credits;
    String[] grades;
    ArrayList<Grade> gradeArrayList;
    ArrayList<Credit> creditArrayList;
    private Button btnAdd;
    private Button btnReset;
    private TextView warningMsg;
    private EditText creditEt;
    private EditText gradeEt;
    private EditText totalCreditEt;
    private EditText gpaEt;
    private View rootView;
    private ArrayList<GradePointAverage> gradePointAverageArrayList;
    GridView gridViewCredit;
    GridView gridViewGrade;
    private GradeRepo gradeRepo;
    private CreditRepo creditRepo;

    public CalculatorFragment() {
        gradeArrayList = new ArrayList<Grade>();
        creditArrayList = new ArrayList<Credit>();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_calculator, container, false);
        gradeRepo = new GradeRepo(getActivity());
        creditRepo = new CreditRepo(getActivity());
        initValues();
        grabUiReferences();
        setToDefault();
        setListeners();
        return rootView;
    }

    private void initValues() {
        int i=0;
        creditArrayList = creditRepo.getAll();
        gradeArrayList = gradeRepo.getAll();
        grades = new String[gradeArrayList.size()];
        credits = new Double[creditArrayList.size()];
        gradesPoints = new Double[gradeArrayList.size()];

        for (Grade grade : gradeArrayList){
            grades[i] = grade.getGradeName();
            gradesPoints[i] = grade.getGradePoint();
            i++;
        }

        i=0;
        for(Credit credit : creditArrayList){
            credits[i] = credit.getCreditValue();
            i++;
        }
    }

    private void setListeners() {

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setToDefault();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isAddValid()){
                    warningMsg.setVisibility(View.GONE);
                    gradePointAverageArrayList.add(new GradePointAverage(Double.valueOf(creditEt.getText().toString()),
                            Double.valueOf(gradeEt.getText().toString())));
                    totalCreditEt.setText(GradePointAverage.totalCredit(gradePointAverageArrayList)+"");
                    gpaEt.setText(GradePointAverage.GradePointAverage(gradePointAverageArrayList)+"");
                    creditEt.setText("0.00");
                    gradeEt.setText("0.00");
                } else {
                    warningMsg.setText("Enter Grade Point and Credit");
                    warningMsg.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private boolean isAddValid() {
        if(Double.valueOf(creditEt.getText().toString())==0.0 || Double.valueOf(gradeEt.getText().toString())==0.0 )
                return false;
        return true;
    }

    private void setToDefault() {
        warningMsg.setVisibility(View.GONE);
        creditEt.setText("0.00");
        gradeEt.setText("0.00");
        totalCreditEt.setText("0.00");
        gpaEt.setText("0.00");
        gradePointAverageArrayList = new ArrayList<GradePointAverage>();
    }

    private void grabUiReferences() {

        gridViewCredit = (GridView)rootView.findViewById(R.id.grid_view_credit);
        gridViewCredit.setAdapter(new CreditAdapter(getActivity(),credits,CalculatorFragment.this));

        gridViewGrade = (GridView)rootView.findViewById(R.id.grid_view_grade);
        gridViewGrade.setAdapter(new GradeAdapter(getActivity(),grades,CalculatorFragment.this));

        btnAdd = (Button) rootView.findViewById(R.id.btn_add);
        btnReset = (Button) rootView.findViewById(R.id.btn_reset);

        warningMsg = (TextView)rootView.findViewById(R.id.tv_msg);
        creditEt = (EditText) rootView.findViewById(R.id.et_credit);
        gradeEt = (EditText) rootView.findViewById(R.id.et_grade);
        totalCreditEt = (EditText) rootView.findViewById(R.id.et_total_cr);
        gpaEt = (EditText) rootView.findViewById(R.id.et_gpa);
    }

    @Override
    public void onCreditSelectedListener(int position) {
        creditEt.setText(String.valueOf(credits[position]));
    }

    @Override
    public void onGradeSelectedListener(int position) {
        gradeEt.setText(String.valueOf(gradesPoints[position]));
    }
}
