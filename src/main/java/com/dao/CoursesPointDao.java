package com.dao;


import com.pojo.CoursesPoint;

public interface CoursesPointDao {
    CoursesPoint getPointById(int userId,int coursesId);
    void addPoint(int userId,int coursesId,int CoursesPoint);
    void losePoint(int userId,int coursesId,int CoursesPoint);
}
