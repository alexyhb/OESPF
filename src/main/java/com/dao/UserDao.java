package com.dao;
import com.pojo.User;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface UserDao {

    User findById(int id);
    String getByUsername(String username);
    void addUser(User user);
    User Login(String username,String password);
    User changePsd(String username,String password);
    String getBalance(String username);
    User getPoint(String username);
    List<User> getUserList(String username);
}
