package org.dhiren.spring.annotation.models;

import org.springframework.beans.factory.annotation.Autowired;


public class Student {
    private Institute institute;

    @Autowired
    private PayRoll payRoll;

    private Subject subject;

    @Autowired
    public Student(Subject subject) {
        this.subject = subject;
    }

    public Institute getInstitute() {
        return institute;
    }

    @Autowired
    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    @Override
    public String toString() {
        return "Student{" +
                "institute=" + institute + " , " +
                "payroll=" + payRoll + " , " +
                "subject=" +subject +
                '}';
    }
}
