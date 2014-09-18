package com.calc.cgpa.cgpacalculator;

import java.util.ArrayList;

/**
 * Created by Zakir on 9/17/2014.
 */
public class GradePointAverage {
    public GradePointAverage() {

    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getGradePoint() {
        return gradePoint;
    }

    public void setGradePoint(double gradePoint) {
        this.gradePoint = gradePoint;
    }

    private double credit;
    private double gradePoint;

    public GradePointAverage(double credit, double gradePoint){
        setCredit(credit);
        setGradePoint(gradePoint);
    }

    public static double GradePointAverage(ArrayList<GradePointAverage> gradePointAverages){
        return (totalGrade(gradePointAverages)/totalCredit(gradePointAverages));
    }

    public static double totalCredit(ArrayList<GradePointAverage> gradePointAverages){
        double totalCredits = 0.0;
        for(GradePointAverage gradePointAverage1 : gradePointAverages){
            totalCredits+= gradePointAverage1.getCredit();
        }
        return totalCredits;
    }

    public static double totalGrade(ArrayList<GradePointAverage> gradePointAverages){
        double totalGradePoints = 0.0;
        for(GradePointAverage gradePointAverage1 : gradePointAverages){
            totalGradePoints+=(gradePointAverage1.getGradePoint()* gradePointAverage1.getCredit());
        }
        return totalGradePoints;
    }
}
