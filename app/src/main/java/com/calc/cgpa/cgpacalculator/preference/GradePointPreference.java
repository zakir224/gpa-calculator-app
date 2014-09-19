package com.calc.cgpa.cgpacalculator.preference;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.calc.cgpa.cgpacalculator.model.Grade;
import com.calc.cgpa.cgpacalculator.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class GradePointPreference extends BasePreference {

    private EditText newGrade;
    private EditText newGradePoint;
    private Grade grade;
    private IGradeUpdatePreference callback;


    public GradePointPreference(Context context, AttributeSet attrs, IGradeUpdatePreference callback, Grade grade) {
        super(context, attrs);

        this.grade = grade;
        this.callback = callback;
        setDialogLayoutResource(R.layout.fragment_grade_point_preference);
    }

    public interface IGradeUpdatePreference {
        public void GradePreferenceUpdated(Grade grade);

        public void GradePreferenceDeleted(Grade grade);
    }


    @Override
    protected void onPrepareDialogBuilder(AlertDialog.Builder builder) {
        builder.setTitle("Grade Details");
        builder.setPositiveButton("Save", null);
        if (grade.getGradeName() != "") {
            builder.setNeutralButton("Delete", null);
        }
        builder.setNegativeButton("Close", this);

        super.onPrepareDialogBuilder(builder);
    }

    @Override
    protected void onBindDialogView(View view) {
        super.onBindDialogView(view);

        try {
            grabViews(view);
            setValues();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setValues() {
        newGrade.setText(grade.getGradeName());
        newGradePoint.setText(String.valueOf(grade.getGradePoint()));
    }

    private void grabViews(View view) {
        newGrade = (EditText) view.findViewById(R.id.preference_et_grade);
        newGradePoint = (EditText) view.findViewById(R.id.preference_et_grade_point);
    }

    @Override
    public void onDialogClose(View v) {
        grade.setGradeName(newGrade.getText().toString());
        grade.setGradePoint(Double.valueOf(newGradePoint.getText().toString()));
        getDialog().dismiss();
        if (v == saveBtn)
            callback.GradePreferenceUpdated(grade);
        else if (v == deleteBtn)
            callback.GradePreferenceDeleted(grade);
    }
}
