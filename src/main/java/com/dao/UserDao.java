package com.dao;
import com.pojo.User;


import java.util.List;

public interface UserDao {

    User findById(int id);
    User Register(String username,String password);
    User Login(String username);
    User changePsd(String username,String password);
    User getBalance(String username);
    User getPoint(String username);

}
