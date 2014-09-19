package com.calc.cgpa.cgpacalculator.preference;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

/**
 * Created by Zakir on 9/20/2014.
 */
public abstract class BasePreference extends DialogPreference {

    protected Button saveBtn;
    protected Button deleteBtn;

    public BasePreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void showDialog(Bundle state) {
        super.showDialog(state);

        saveBtn = ((AlertDialog) getDialog()).getButton(DialogInterface.BUTTON_POSITIVE);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDialogClose(saveBtn);
            }
        });

        deleteBtn = ((AlertDialog) getDialog()).getButton(DialogInterface.BUTTON_NEUTRAL);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDialogClose(deleteBtn);
            }
        });
    }

    public abstract void onDialogClose(View v);

}
