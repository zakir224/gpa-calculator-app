package com.calc.cgpa.cgpacalculator;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.preference.DialogPreference;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;


/**
 * User Add / edit Dialog
 *
 * Created by Shahab on 11/22/13.
 */
public class UserPreference /*extends DialogPreference implements
        CompoundButton.OnCheckedChangeListener,
        IValidateForm,
        DialogInterface.OnClickListener,
        AdapterView.OnItemSelectedListener*/ {

//    private BraveEditText mUserNameText;
//    private BraveEditText mUserIdText;
//    private BraveEditText mPasswordText;
//    private BraveEditText mRetypePasswordText;
//    private CheckBox mShowPassword;
//    private BraveEditText mInterviewerCodeText;
//    private TextView mInterviewerName;
//
//    private Spinner spinnerRole;
//    private Spinner spinnerStatus;
//
//    private LinearLayout layoutUserCode;
//
//    ValidationManager mValidationManager;
//
//    private boolean isValidationInProgress;
//
//    private Handler handler;
//
//    private Runnable runnable;
//
//    private User mUser;
//
//    private IUpdateUserPreference callback;
//
//    public UserPreference(Context context, AttributeSet attrs, IUpdateUserPreference callback, User user) {
//        super(context, attrs);
//
//        this.mUser = user;
//        this.callback = callback;
//
//        setDialogLayoutResource(R.layout.dialog_user_preference);
//    }
//
//    @Override
//    protected void onPrepareDialogBuilder(AlertDialog.Builder builder) {
//
//        builder.setTitle("User Details");
//        builder.setPositiveButton("Save", null);
//        builder.setNegativeButton("Close", this);
//
//        super.onPrepareDialogBuilder(builder);
//    }
//
//    @Override
//    protected void onBindDialogView(View view) {
//        super.onBindDialogView(view);
//
//        try {
//            grabViews(view);
//            preparePreListeners();
//            setValues();
//            prepareListeners();
//            prepareValidationLogic();
//        } catch (Exception e) {
//            ExceptionHandler.handleException(getContext(), e);
//        }
//    }
//
//    private void prepareValidationLogic() {
//
//        mValidationManager = new ValidationManager(getContext());
//
//        handler = new Handler();
//
//        runnable = initiateRunnable();
//
//        mValidationManager.add("mUserNameText", new RegExpressionValueValidator(mUserNameText, "[a-zA-Z ]{3,30}",
//                getContext().getString(R.string.invalid_user_name)));
//        mValidationManager.add("mUserIdText", new RegExpressionValueValidator(mUserIdText, "^[a-zA-Z0-9:]+$",
//                getContext().getString(R.string.invalid_user_id)));
//        mValidationManager.add("mPasswordText", new RegExpressionValueValidator(mPasswordText, "^[0-9a-zA-Z]{8,}$",
//                getContext().getString(R.string.invalid_msg_password)));
//        mValidationManager.add("mInterviewerCodeText", new RegExpressionValueValidator(mInterviewerCodeText, "^(?!\\s*$).+",
//                getContext().getString(R.string.required_msg)));
//    }
//
//    /**
//     * These listeners should be set after setting values to the views, otherwise it will create StackOverflow
//     */
//    private void prepareListeners() {
//        mUserNameText.addTextChangedListener(new FormTextWatcher(this, mUserNameText));
//        mUserIdText.addTextChangedListener(new FormTextWatcher(this, mUserIdText));
//        mPasswordText.addTextChangedListener(new FormTextWatcher(this, mPasswordText));
//        mRetypePasswordText.addTextChangedListener(new PasswordTextWatcher(getContext(), mPasswordText, mRetypePasswordText));
//        mInterviewerCodeText.addTextChangedListener(new InterviewerCodeTextWatcher(getContext(), this, mInterviewerCodeText, mInterviewerName));
//    }
//
//    private void preparePreListeners() {
//        mShowPassword.setOnCheckedChangeListener(this);
//        spinnerRole.setOnItemSelectedListener(this);
//    }
//
//    @Override
//    protected void showDialog(Bundle state) {
//        super.showDialog(state);
//
//        Button button = ((AlertDialog) getDialog()).getButton(DialogInterface.BUTTON_POSITIVE);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onDialogClose();
//            }
//        });
//    }
//
//
//    /**
//     * Grab the values from the View
//     * and set the values to the model
//     */
//    private void onDialogClose() {
//        try {
//            if (checkValidation(true)) {
//                mUser.setUserName(mUserNameText.getText().toString());
//                mUser.setUserId(mUserIdText.getText().toString());
//                mUser.setPassword(mPasswordText.getText().toString());
//                mUser.setRole(User.Role.values() [spinnerRole.getSelectedItemPosition() - 1]);          // first option is Tap to enter...
//                mUser.setStatus(User.Status.values() [spinnerStatus.getSelectedItemPosition() - 1]);    // first option is Tap to enter...
//
//                if (spinnerRole.getSelectedItemPosition() == 1 || spinnerRole.getSelectedItemPosition() == 3) {   // Interviewer, first option is Tap to enter...
//                    if (mUser.getInterviewer() == null) {
//                        mUser.setInterviewer(new Interviewer(Integer.parseInt(mInterviewerCodeText.getText().toString()), mUserNameText.getText().toString()));
//                    } else {
//                        Interviewer interviewer = mUser.getInterviewer();
//                        interviewer.setInterviewerCode(Integer.parseInt(mInterviewerCodeText.getText().toString()));
//                        interviewer.setUserName(mUserNameText.getText().toString());
//                    }
//                } else {
//                    mUser.setInterviewer(null);
//                }
//
//                callback.userPreferenceUpdated(mUser);
//                getDialog().dismiss();
//            }
//        } catch (Exception e) {
//            ExceptionHandler.handleException(getContext(), e);
//        }
//    }
//
//    @Override
//    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//        if (buttonView.getId() == R.id.show_password) {
//            if (isChecked) {
//                mPasswordText.setTransformationMethod(null);
//                mRetypePasswordText.setTransformationMethod(null);
//            } else {
//                PasswordTransformationMethod passMethod = new PasswordTransformationMethod();
//                mPasswordText.setTransformationMethod(passMethod);
//                mRetypePasswordText.setTransformationMethod(passMethod);
//            }
//        }
//    }
//
//    @Override
//    public void triggerValidation(View triggerView) {
//        if (!isValidationInProgress) {
//            // the task is not in progressive mode, so we simply initiate the trigger task
//            handler.postDelayed(runnable, Constants.TIMER_INTERVAL);
//            isValidationInProgress = true;
//        }
//    }
//
//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        if (parent.getId() == R.id.user_role) {
//            if (position == 1) {    // Interviewer has code, other user doesn't have any code
//                layoutUserCode.setVisibility(View.VISIBLE);
//                mInterviewerCodeText.setVisibility(View.VISIBLE);
//                mInterviewerName.setVisibility(View.VISIBLE);
//            } else {
//                layoutUserCode.setVisibility(View.GONE);
//                mInterviewerCodeText.setVisibility(View.GONE);
//                mInterviewerName.setVisibility(View.GONE);
//            }
//        }
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {}
//
//    public interface IUpdateUserPreference {
//        public void userPreferenceUpdated(User user);
//    }
//
//    private Runnable initiateRunnable() {
//        return new Runnable() {
//            @Override
//            public void run() {
//                Tracer.d("handler fired on UserPreference");
//
//                checkValidation(false);
//
//            }
//        };
//    }
//
//    /**
//     *
//     * @param isCountBlank if true, it will count the blank space, that means, blank is not allowed
//     *                     otherwise, blank field will be allowed
//     *                     on periodical validation we won't like to show error on blank fields
//     * @return
//     */
//    private boolean checkValidation(boolean isCountBlank) {
//
//        boolean ret = true;
//
//        try {
//            HashMap<String, FinalValidationResult> validationResult = mValidationManager.validateAll(true);
//
//            for (Map.Entry<String, FinalValidationResult> entry : validationResult.entrySet()) {
//                FinalValidationResult value = entry.getValue();
//
//                Object source = value.getSource();
//
//                if (source instanceof BraveEditText) {
//                    BraveEditText editText = (BraveEditText) source;
//
//                    if (editText.getVisibility() == View.VISIBLE && !value.isValueValid() && (editText.getText().length() != 0 || isCountBlank)) {
//                        editText.setError(value.getValueInvalidMessage());
//                        ret = false;
//                    }
//                }
//            }
//
//            // mRetypePasswordText field is a special field .. it can show error by periodical validation
//            // but at final save we need to show the error message by ourselves, cause user may never tap on this field and thus
//            // the periodical validation won't get triggered
//            if (ret && isCountBlank) {
//                if (!TextUtils.equals(mRetypePasswordText.getText(), mPasswordText.getText())) {
//                    mRetypePasswordText.setError(getContext().getString(R.string.invalid_msg_password_mismatch));
//                    ret = false;
//                }
//            }
//        } catch (Exception e) {
//            ExceptionHandler.handleException(getContext(), e);
//        }
//
//        isValidationInProgress = false;
//
//        return ret;
//    }
//
//    private void grabViews(View rootView) {
//
//        mUserNameText = (BraveEditText) rootView.findViewById(R.id.text_user_name);
//        mUserIdText = (BraveEditText) rootView.findViewById(R.id.text_user_id);
//        mPasswordText = (BraveEditText) rootView.findViewById(R.id.text_user_password);
//        mRetypePasswordText = (BraveEditText) rootView.findViewById(R.id.text_user_retype_password);
//        mInterviewerCodeText = (BraveEditText) rootView.findViewById(R.id.text_user_code);
//        mInterviewerName = (TextView) rootView.findViewById(R.id.interviewer_name);
//        layoutUserCode = (LinearLayout) rootView.findViewById(R.id.row_user_code);
//        mShowPassword = (CheckBox) rootView.findViewById(R.id.show_password);
//        spinnerRole = (Spinner) rootView.findViewById(R.id.user_role);
//        spinnerStatus = (Spinner) rootView.findViewById(R.id.user_status);
//    }
//
//    private void setValues() {
//
//        mUserNameText.setText(mUser.getUserName());
//        mUserIdText.setText(mUser.getUserId());
//        mPasswordText.setText(mUser.getPassword());
//        mRetypePasswordText.setText(mUser.getPassword());
//
//        if (mUser.getInterviewer() != null)
//            mInterviewerCodeText.setText(String.format("%02d", mUser.getInterviewer().getInterviewerCode()));
//
//        String[] userRoleArray = getContext().getResources().getStringArray(R.array.user_roles);
//
//        FormSpinnerAdapter adapter = new FormSpinnerAdapter(getContext(), userRoleArray);
//        spinnerRole.setAdapter(adapter);
//        spinnerRole.setSelection(mUser.getRole().ordinal() + 1, true);  // first option is Tap to enter...
//
//        String[] userStatusArray = getContext().getResources().getStringArray(R.array.user_status);
//
//        FormSpinnerAdapter adapter2 = new FormSpinnerAdapter(getContext(), userStatusArray);
//        spinnerStatus.setAdapter(adapter2);
//        spinnerStatus.setSelection(mUser.getStatus().ordinal() + 1, true);  // first option is Tap to enter...
//    }
}
