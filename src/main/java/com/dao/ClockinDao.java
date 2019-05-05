package com.dao;

public interface ClockinDao {

    int getTotalById(int userId,int coursesId);
    int getCurrentById(int userId,int coursesId);
    int clockin(int userId,int coursesId);
}
