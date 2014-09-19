package com.calc.cgpa.cgpacalculator.preference;



import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.calc.cgpa.cgpacalculator.model.Credit;
import com.calc.cgpa.cgpacalculator.R;


/**
 * A simple {@link android.app.Fragment} subclass.
 *
 */
public class CreditPreference extends DialogPreference {

    private EditText newCredit;
    private EditText newGradePoint;
    private Credit credit;
    private ICreditUpdatePreference callback;
    private Button deleteBtn;
    private Button saveBtn;

    public CreditPreference(Context context, AttributeSet attrs, ICreditUpdatePreference callback, Credit credit) {
        // Required empty public constructor
        super(context,attrs);
        this.credit = credit;
        this.callback=callback;
        setDialogLayoutResource(R.layout.fragment_credit_point_preference);
    }

    public interface ICreditUpdatePreference {
        public void CreditPreferenceUpdated(Credit credit);
        public void CreditPreferenceDeleted(Credit credit);
    }


    @Override
    protected void onPrepareDialogBuilder(AlertDialog.Builder builder) {
        builder.setTitle("Credit hrs.");
        builder.setPositiveButton("Save", null);
        if(credit.getCreditValue()!=0.0){
            builder.setNeutralButton("Delete",null);
        }
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
        newCredit.setText(String.valueOf(credit.getCreditValue()));
    }

    private void grabViews(View view) {
        newCredit = (EditText)view.findViewById(R.id.preference_et_credit);
    }

    @Override
    protected void showDialog(Bundle state) {
        super.showDialog(state);

        saveBtn = ((AlertDialog)getDialog()).getButton(DialogInterface.BUTTON_POSITIVE);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDialogClose(saveBtn);
            }
        });

        deleteBtn = ((AlertDialog)getDialog()).getButton(DialogInterface.BUTTON_NEUTRAL);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDialogClose(deleteBtn);
            }
        });
    }

    private void onDialogClose(View v) {
        getDialog().dismiss();
        if(v==saveBtn){
            credit.setCreditValue(Double.valueOf(newCredit.getText().toString()));
            callback.CreditPreferenceUpdated(credit);
        } else if(v==deleteBtn){
            callback.CreditPreferenceDeleted(credit);
        }
    }
}