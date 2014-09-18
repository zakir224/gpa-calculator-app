package com.calc.cgpa.cgpacalculator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;


/**
 * Created by Zakir on 9/18/2014.
 */
public class CreditAdapter extends BaseAdapter {
    private Context mContext;
    private Double[] credits;
    CreditSelectedListener creditSelectedListener;

    public interface CreditSelectedListener{
       public void onCreditSelectedListener(int position);
    }

    public CreditAdapter(Context c,Double[] credits,CreditSelectedListener creditSelectedListener) {
        mContext = c;
        this.credits = credits;
        this.creditSelectedListener = creditSelectedListener;
    }

    public int getCount() {
        return credits.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        Button button;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            button = new Button(mContext);
        } else {
            button = (Button) convertView;
        }

        button.setText(String.valueOf(credits[position]));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creditSelectedListener.onCreditSelectedListener(position);
            }
        });

        return button;
    }


}
