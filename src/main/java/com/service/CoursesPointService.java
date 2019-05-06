package com.service;

public interface CoursesPointService {
    String getPointById(int userId,int coursesId);
    String addPoint(int userId,int coursesId,int coursesPoint);
    String losePoint(int userId,int coursesId,int coursesPoint);
}
