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
 *
 */
public class GradePointPreference extends DialogPreference {

    private EditText newGrade;
    private EditText newGradePoint;
    private Grade grade;
    private IGradeUpdatePreference callback;

    public GradePointPreference(Context context,AttributeSet attrs,IGradeUpdatePreference callback,Grade grade) {
        // Required empty public constructor
        super(context,attrs);

        this.grade = grade;
        this.callback=callback;
        setDialogLayoutResource(R.layout.fragment_grade_point_preference);
    }

    public interface IGradeUpdatePreference {
        public void GradePreferenceUpdated(Grade grade);
    }


    @Override
    protected void onPrepareDialogBuilder(AlertDialog.Builder builder) {
        builder.setTitle("Grade Details");
        builder.setNegativeButton("Save", null);
        builder.setNegativeButton("Close",this);

        super.onPrepareDialogBuilder(builder);
    }

    @Override
    protected void onBindDialogView(View view) {
        super.onBindDialogView(view);

        try {
            grabViews(view);
            setValues();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void setValues() {
        newGrade.setText(grade.getGradeName());
        newGradePoint.setText(String.valueOf(grade.getGradePoint()));
    }

    private void grabViews(View view) {
        newGrade = (EditText)view.findViewById(R.id.preference_et_grade);
        newGradePoint = (EditText)view.findViewById(R.id.preference_et_grade_point);
    }

    @Override
    protected void showDialog(Bundle state) {
        super.showDialog(state);

        Button saveBtn = ((AlertDialog)getDialog()).getButton(DialogInterface.BUTTON_POSITIVE);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDialogClose();
            }
        });
    }

    private void onDialogClose() {
        grade.setGradeName(newGrade.getText().toString());
        grade.setGradePoint(Double.valueOf(newGradePoint.getText().toString()));
        getDialog().dismiss();
        callback.GradePreferenceUpdated(grade);
    }
}
