package com.pojo;

import java.sql.Time;

public class Courses {
    private String coursesName;
    private int examType;
    private Time coursesLength;
    private int coursesNumber;
    private float money;

    public String getCoursesName() {
        return coursesName;
    }

    public void setCoursesName(String coursesName) {
        this.coursesName = coursesName;
    }

    public int getExamType() {
        return examType;
    }

    public void setExamType(int examType) {
        this.examType = examType;
    }

    public Time getCoursesLength() {
        return coursesLength;
    }

    public void setCoursesLength(Time coursesLength) {
        this.coursesLength = coursesLength;
    }

    public int getCoursesNumber() {
        return coursesNumber;
    }

    public void setCoursesNumber(int coursesNumber) {
        this.coursesNumber = coursesNumber;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }
}
