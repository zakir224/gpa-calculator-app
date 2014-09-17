package com.calc.cgpa.cgpacalculator;

import java.util.ArrayList;

/**
 * Created by Zakir on 9/17/2014.
 */
public class GradePoint {
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

    public GradePoint(double credit, double gradePoint){
        setCredit(credit);
        setGradePoint(gradePoint);
    }

    public static double GradePointAverage(ArrayList<GradePoint> gradePoints){
        return (totalGrade(gradePoints)/totalCredit(gradePoints));
    }

    public static double totalCredit(ArrayList<GradePoint> gradePoints){
        double totalCredits = 0.0;
        for(GradePoint gradePoint1 : gradePoints){
            totalCredits+=gradePoint1.getCredit();
        }
        return totalCredits;
    }

    public static double totalGrade(ArrayList<GradePoint> gradePoints){
        double totalGradePoints = 0.0;
        for(GradePoint gradePoint1 : gradePoints){
            totalGradePoints+=(gradePoint1.getGradePoint()*gradePoint1.getCredit());
        }
        return totalGradePoints;
    }
}
