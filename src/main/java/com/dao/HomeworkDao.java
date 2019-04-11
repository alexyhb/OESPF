package com.dao;

import com.pojo.Homework;

import java.util.Calendar;

public interface HomeworkDao {
    Homework getInfoById(int id);
    Homework getInfoByname(String name);
    void setHomework(Homework homework);
    void deleteHomework(Homework homework);
    Homework changeTime(Calendar startTime,Calendar endTime);
    void setScore(float score);
//    private int id;
//    private int coursesId;
//    private int currentNumber;
//    private int homeworkId;
//    private Calendar startTime;
//    private Calendar endTime;
//    private float Score;
}
