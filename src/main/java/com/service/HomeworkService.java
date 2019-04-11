package com.service;

import com.pojo.Homework;

import java.util.Calendar;

public interface HomeworkService {
    Homework getInfoById(int id);
    Homework getInfoByname(String name);
    void setHomework(Homework homework);
    void deleteHomework(Homework homework);
    Homework changeTime(Calendar startTime, Calendar endTime);
    void setScore(float score);
}
