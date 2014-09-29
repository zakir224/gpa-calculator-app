package com.calc.cgpa.cgpacalculator.ui.fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.calc.cgpa.cgpacalculator.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link com.calc.cgpa.cgpacalculator.ui.fragment.SaveGpaDialog.OnSaveDialogFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SaveGpaDialog#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class SaveGpaDialog extends DialogFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView gpaEt;
    private TextView totalCreditEt;
    private EditText semesterName;
    Button saveBtn;
    Button cancelBtn;
    // TODO: Rename and change types of parameters
    private String gpa;
    private String totalCredit;

    private OnSaveDialogFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SaveGpaDialog.
     */
    // TODO: Rename and change types and number of parameters
    public static SaveGpaDialog newInstance(String param1, String param2,OnSaveDialogFragmentInteractionListener mListener) {

        SaveGpaDialog fragment = new SaveGpaDialog();
        fragment.mListener = mListener;
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public SaveGpaDialog() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            gpa = getArguments().getString(ARG_PARAM2);
            totalCredit = getArguments().getString(ARG_PARAM1);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_save_gpa_dialog, container, false);
        gpaEt = (TextView)view.findViewById(R.id.dlg_gpa);
        getDialog().setTitle("Save as semester Result");
        totalCreditEt = (TextView)view.findViewById(R.id.dlg_total_credit);
        semesterName = (EditText)view.findViewById(R.id.semester_name);
        gpaEt.setText("GPA: "+gpa);
        totalCreditEt.setText("Total credit: "+totalCredit);
        saveBtn =(Button)view.findViewById(R.id.save_button);
        cancelBtn =(Button)view.findViewById(R.id.cancel_button);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!semesterName.getText().toString().equals("")){
                    dismiss();
                    onButtonPressed(semesterName.getText().toString());
                } else
                    Toast.makeText(getActivity(),"Enter a semester name",Toast.LENGTH_SHORT).show();

            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String uri) {
        if (mListener != null) {
            mListener.onSaveGpaClicked(uri);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnSaveDialogFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onSaveGpaClicked(String s);
    }

}
