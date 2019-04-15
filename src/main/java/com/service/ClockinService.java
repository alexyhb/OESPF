package com.service;

public interface ClockinService {
    int getTotalById(int id);
    int getCurrentById(int id);
    void clockin(int currentNumber);
}
