package com.service;

public interface ClockinService {
    String getTotalById(int userId,int coursesId);
    String getCurrentById(int userId,int coursesId);
    String clockin(int userId,int coursesId);
}
