package com.calc.cgpa.cgpacalculator;

import android.provider.BaseColumns;


/**
 * Created by Zakir on 9/18/2014.
 */
public class GPAContract {

    public GPAContract(){};

    public static abstract class GradeEntry implements BaseColumns{
        public static final String TABLE_NAME = "grade";
        public static final String COLUMN_NAME_GRADE_ID = "grade_id";
        public static final String COLUMN_NAME_GRADE_NAME = "grade_name";
        public static final String COLUMN_NAME_GRADE_POINT = "grade_point";
    }

    public static abstract class CreditEntry implements BaseColumns{
        public static final String TABLE_NAME = "credit";
        public static final String COLUMN_NAME_CREDIT_ID = "credit_id";
        public static final String COLUMN_NAME_CREDIT_VALUE = "credit_value";
    }

    public static abstract class SemesterResultEntry implements BaseColumns{
        public static final String TABLE_NAME = "semester_result";
        public static final String COLUMN_NAME_SEMESTER_ID = "semester_id";
        public static final String COLUMN_NAME_SEMESTER_NAME = "semester_name";
        public static final String COLUMN_NAME_SEMESTER_GPA = "semester_gpa";
        public static final String COLUMN_NAME_SEMESTER_TOTAL_CREDITS = "semester_total_credits";
    }
}
