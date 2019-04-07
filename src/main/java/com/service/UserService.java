package com.service;
import com.pojo.UserReSult;
import  com.pojo.user;
public interface UserService {
    void Regist(String userName,String password);
    user login(String userName,String password);
}

