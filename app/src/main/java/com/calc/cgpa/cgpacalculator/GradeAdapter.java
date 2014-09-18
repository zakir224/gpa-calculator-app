package com.calc.cgpa.cgpacalculator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

/**
 * Created by Zakir on 9/18/2014.
 */
public class GradeAdapter extends BaseAdapter {
    private Context mContext;
    private String[] grades;
    private GradeSelectedListener gradeSelectedListener;
    public GradeAdapter(Context c,String[] grades,GradeSelectedListener gradeSelectedListener) {
        mContext = c;
        this.grades = grades;
        this.gradeSelectedListener = gradeSelectedListener;
    }

    public interface GradeSelectedListener{
        public void onGradeSelectedListener(int position);
    }

    public int getCount() {
        return grades.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {
        Button button;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            button = new Button(mContext);
        } else {
            button = (Button) convertView;
        }

        button.setText(String.valueOf(grades[position]));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gradeSelectedListener.onGradeSelectedListener(position);
            }
        });
        return button;
    }
}
