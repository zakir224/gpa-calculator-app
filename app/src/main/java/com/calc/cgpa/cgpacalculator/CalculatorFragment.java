package com.calc.cgpa.cgpacalculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Zakir on 9/17/2014.
 */
public class CalculatorFragment extends Fragment {

    private LinkedHashMap<Integer, Button> creditButtons;
    private LinkedHashMap<Integer, Button> gradeButtons;
    private Double[] credits = {1.0, 1.5, 2.0, 3.0};
    private Double[] gradePoints = {4.0, 3.67, 3.33, 3.00, 2.67, 2.33, 2.00, 1.67, 1.33, 1.00};
    private Button btnAdd;
    private Button btnReset;
    private TextView warningMsg;
    private EditText creditEt;
    private EditText gradeEt;
    private EditText totalCreditEt;
    private EditText gpaEt;
    private View rootView;
    private ArrayList<GradePoint> gradePointArrayList;

    public CalculatorFragment() {
        creditButtons = new LinkedHashMap<Integer, Button>();
        gradeButtons = new LinkedHashMap<Integer, Button>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        grabUiReferences();
        setToDefault();
        setListeners();
        return rootView;
    }

    private void setListeners() {

        for (final Map.Entry<Integer, Button> btn : creditButtons.entrySet()) {
            btn.getValue().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    creditEt.setText(String.valueOf(credits[btn.getKey()]));
                }
            });
        }

        for (final Map.Entry<Integer, Button> btn : gradeButtons.entrySet()) {
            btn.getValue().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gradeEt.setText(String.valueOf(gradePoints[btn.getKey()]));
                }
            });
        }

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
                    gradePointArrayList.add(new GradePoint(Double.valueOf(creditEt.getText().toString()),
                            Double.valueOf(gradeEt.getText().toString())));
                    totalCreditEt.setText(GradePoint.totalCredit(gradePointArrayList)+"");
                    gpaEt.setText(GradePoint.GradePointAverage(gradePointArrayList)+"");
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
        gradePointArrayList = new ArrayList<GradePoint>();
    }

    private void grabUiReferences() {
        
        creditButtons.put(0, (Button) rootView.findViewById(R.id.btn_cr_1));
        creditButtons.put(1, (Button) rootView.findViewById(R.id.btn_cr_2));
        creditButtons.put(2, (Button) rootView.findViewById(R.id.btn_cr_3));
        creditButtons.put(3, (Button) rootView.findViewById(R.id.btn_cr_4));

        gradeButtons.put(0, (Button) rootView.findViewById(R.id.btn_gr_1));
        gradeButtons.put(1, (Button) rootView.findViewById(R.id.btn_gr_2));
        gradeButtons.put(2, (Button) rootView.findViewById(R.id.btn_gr_3));
        gradeButtons.put(3, (Button) rootView.findViewById(R.id.btn_gr_4));
        gradeButtons.put(4, (Button) rootView.findViewById(R.id.btn_gr_5));
        gradeButtons.put(5, (Button) rootView.findViewById(R.id.btn_gr_6));
        gradeButtons.put(6, (Button) rootView.findViewById(R.id.btn_gr_7));
        gradeButtons.put(7, (Button) rootView.findViewById(R.id.btn_gr_8));
        gradeButtons.put(8, (Button) rootView.findViewById(R.id.btn_gr_9));
        gradeButtons.put(9, (Button) rootView.findViewById(R.id.btn_gr_10));

        btnAdd = (Button) rootView.findViewById(R.id.btn_add);
        btnReset = (Button) rootView.findViewById(R.id.btn_reset);

        warningMsg = (TextView)rootView.findViewById(R.id.tv_msg);
        creditEt = (EditText) rootView.findViewById(R.id.et_credit);
        gradeEt = (EditText) rootView.findViewById(R.id.et_grade);
        totalCreditEt = (EditText) rootView.findViewById(R.id.et_total_cr);
        gpaEt = (EditText) rootView.findViewById(R.id.et_gpa);
    }
}
