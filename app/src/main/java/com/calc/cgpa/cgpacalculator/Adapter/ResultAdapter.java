package com.calc.cgpa.cgpacalculator.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.calc.cgpa.cgpacalculator.R;
import com.calc.cgpa.cgpacalculator.model.SemesterResult;

import java.util.ArrayList;

/**
 * Created by Zakir on 9/28/2014.
 */
public class ResultAdapter extends ArrayAdapter<SemesterResult>{

    private Context context;
    private TextView semesterTv;
    private TextView semesterTotalCredit;
    private TextView semesterGpa;
    private Button button;
    private ArrayList<SemesterResult> semesterResults;

    public ResultAdapter(Context context, int resource, ArrayList<SemesterResult> semesterResults) {
        super(context, resource);
        this.context= context;
        this.semesterResults = semesterResults;
    }

    @Override
    public int getCount() {
        return semesterResults.size();
    }

    @Override
    public SemesterResult getItem(int position) {
        return semesterResults.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null)
            convertView = View.inflate(context,R.layout.result_list_item,null);

        semesterTv = (TextView)convertView.findViewById(R.id.tv_semester_name);
        semesterTotalCredit = (TextView)convertView.findViewById(R.id.tv_semester_total_credit);
        semesterGpa = (TextView)convertView.findViewById(R.id.tv_gpa);
        button = (Button)convertView.findViewById(R.id.result_view_btn);

        semesterGpa.setText("GPA: "+String.valueOf(semesterResults.get(position).getSemesterGpa()));
        semesterTv.setText(semesterResults.get(position).getSemesterName());
        semesterTotalCredit.setText("Total Credit: "+String.valueOf(semesterResults.get(position).getSemesterTotalCredits()));
        button.setText(semesterResults.get(position).getSemesterName().substring(0,1));

        return convertView;
    }


    
}
