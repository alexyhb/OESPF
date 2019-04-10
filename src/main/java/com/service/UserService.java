package com.service;

import  com.pojo.User;
public interface UserService {
    User findById(int id);
    User Register(String username,String password);
    User Login(String username,String password);
    User changePsd(String username,String password);
    User getBalance(String username);
    User getPoint(String username);
}

