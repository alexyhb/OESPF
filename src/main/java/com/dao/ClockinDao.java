package com.dao;

public interface ClockinDao {

    int getTotalById(int id);
    int getCurrentById(int id);
    int clockin(int currentNumber);
}
