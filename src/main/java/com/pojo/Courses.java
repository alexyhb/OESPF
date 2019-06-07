package com.pojo;

import java.sql.Time;

public class Courses {
    private int id;
    private String coursesName;
    private int examType;
    private String img;
    private String text;
    private Time coursesLength;
    private int coursesNumber;
    private float money;
    private String teachBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeachBy() {
        return teachBy;
    }

    public void setTeachBy(String teachBy) {
        this.teachBy = teachBy;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

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
