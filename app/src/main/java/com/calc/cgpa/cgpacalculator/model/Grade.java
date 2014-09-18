package com.calc.cgpa.cgpacalculator.model;

/**
 * Created by Zakir on 9/18/2014.
 */
public class Grade{

    private int gradeId;
    private String gradeName;
    private Double gradePoint;

    public Grade(){

    }

    public Grade(String gradeName,double gradePoint){

        this.gradeName = gradeName;
        this.gradePoint = gradePoint;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public Double getGradePoint() {
        return gradePoint;
    }

    public void setGradePoint(Double gradePoint) {
        this.gradePoint = gradePoint;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }
}
