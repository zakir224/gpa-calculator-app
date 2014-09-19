package com.calc.cgpa.cgpacalculator.ui.fragment;

import android.os.Bundle;
import android.preference.PreferenceCategory;
import android.preference.PreferenceFragment;
import android.widget.Toast;

import com.calc.cgpa.cgpacalculator.model.Credit;
import com.calc.cgpa.cgpacalculator.preference.CreditPreference;
import com.calc.cgpa.cgpacalculator.model.Grade;
import com.calc.cgpa.cgpacalculator.preference.GradePointPreference;
import com.calc.cgpa.cgpacalculator.R;
import com.calc.cgpa.cgpacalculator.db.CreditRepo;
import com.calc.cgpa.cgpacalculator.db.GradeRepo;

import java.util.ArrayList;

/**
 * Settings Fragment generate the screen based on xml preference
 *
 * Created by Shahab on 11/1/13.
 */
public class SettingsFragment extends PreferenceFragment implements
        GradePointPreference.IGradeUpdatePreference, CreditPreference.ICreditUpdatePreference {

    private ArrayList<Grade> gradeList;
    private ArrayList<Credit> creditArrayList;
    private GradeRepo gradeRepo;
    private CreditRepo creditRepo;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preferences);
        gradeList = new ArrayList<Grade>();
        gradeRepo = new GradeRepo(getActivity());
        creditRepo = new CreditRepo(getActivity());

        buildUserList();

    }



    private void buildUserList() {

        try {
            gradeList = gradeRepo.getAll();
            creditArrayList = creditRepo.getAll();
            populateView();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void populateView() {

        PreferenceCategory targetCategory = (PreferenceCategory)findPreference("pref_grades");
        targetCategory.removeAll();


        for (Grade grade : gradeList) {
            GradePointPreference preference = new GradePointPreference(getActivity(), null, this, grade);
            preference.setKey(grade.getGradeName().toLowerCase());
            preference.setTitle(grade.getGradeName());
            preference.setSummary(getString(R.string.pref_grade_summary));
            targetCategory.addPreference(preference);
        }

        GradePointPreference preference = new GradePointPreference(getActivity(), null, this, new Grade("",0.0));
        preference.setTitle(R.string.pref_add);
        preference.setSummary(R.string.pref_grade_summary);
        targetCategory.addPreference(preference);

        PreferenceCategory targetCategoryCredits = (PreferenceCategory)findPreference("pref_credits");
        targetCategoryCredits.removeAll();


        for (Credit credit : creditArrayList) {
            CreditPreference creditPreference = new CreditPreference(getActivity(), null, this, credit);
            creditPreference.setKey(credit.getCreditId()+"");
            creditPreference.setTitle(credit.getCreditValue()+"");
            creditPreference.setSummary(getString(R.string.pref_grade_summary));
            targetCategoryCredits.addPreference(creditPreference);
        }

        CreditPreference creditPreference = new CreditPreference(getActivity(), null, this, new Credit(0.0));
        creditPreference.setTitle(R.string.pref_add);
        creditPreference.setSummary(R.string.pref_add_credits);
        targetCategoryCredits.addPreference(creditPreference);
    }


    @Override
    public void GradePreferenceUpdated(Grade grade) {
        Toast.makeText(getActivity(),"Grade will be updated",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void CreditPreferenceUpdated(Credit credit) {
        creditRepo.createOrUpdateCreditPreference(credit);
        Toast.makeText(getActivity(),"Credits Updated",Toast.LENGTH_SHORT).show();
        buildUserList();
    }

    @Override
    public void CreditPreferenceDeleted(Credit credit) {
        creditRepo.deleteCreditPreference(credit);
        Toast.makeText(getActivity(),"Credit Deleted",Toast.LENGTH_SHORT).show();
        buildUserList();
    }
}