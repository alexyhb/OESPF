package com.dao;

public interface RunningCoursesDao {
    /**
     *  private int id;
     *     private int userId;
     *     private int coursesId;
     *     private int totalNumber;
     *     private int currentNumber;
     */
    boolean addStudent(int userId,int coursesId);
    boolean updateCnumber(int userId,int coursesId);
    String findInfo(int userId,int coursesId);
}
