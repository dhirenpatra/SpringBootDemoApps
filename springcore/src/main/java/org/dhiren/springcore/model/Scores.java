package org.dhiren.springcore.model;

public class Scores {
    private double math;
    private double science;
    private double english;

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getScience() {
        return science;
    }

    public void setScience(double science) {
        this.science = science;
    }

    public double getEnglish() {
        return english;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    @Override
    public String toString() {
        return "Scores{" +
                "math=" + math +
                ", science=" + science +
                ", english=" + english +
                '}';
    }
}
