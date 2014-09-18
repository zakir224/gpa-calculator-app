package com.calc.cgpa.cgpacalculator.model;

/**
 * Created by Zakir on 9/18/2014.
 */
public class SemesterResult {

    private int semesterId;
    private String semesterName;
    private double semesterGpa;
    private double semesterTotalCredits;

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public double getSemesterGpa() {
        return semesterGpa;
    }

    public void setSemesterGpa(double semesterGpa) {
        this.semesterGpa = semesterGpa;
    }

    public double getSemesterTotalCredits() {
        return semesterTotalCredits;
    }

    public void setSemesterTotalCredits(double semesterTotalCredits) {
        this.semesterTotalCredits = semesterTotalCredits;
    }
}
