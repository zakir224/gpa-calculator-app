package com.calc.cgpa.cgpacalculator;

/**
 * Created by Zakir on 9/18/2014.
 */
public class Credit {

    private int creditId;
    private double creditValue;

    public Credit(Double creditValue) {
        setCreditValue(creditValue);
    }

    public Credit() {

    }

    public int getCreditId() {
        return creditId;
    }

    public void setCreditId(int creditId) {
        this.creditId = creditId;
    }

    public double getCreditValue() {
        return creditValue;
    }

    public void setCreditValue(double creditValue) {
        this.creditValue = creditValue;
    }
}
