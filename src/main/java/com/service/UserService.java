package com.service;

import com.alibaba.fastjson.JSONObject;
import  com.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    User findById(int id);
    String Register(String username,String password,int role);
    JSONObject Login(String username, String password);
    String getByUsername(String username) throws Exception;
    User changePsd(String username,String password);
    String getBalance(String username);
    String getPoint(String username);
    List<User> getUserList(String username);
}

