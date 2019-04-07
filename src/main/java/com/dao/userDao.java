package com.dao;
import com.pojo.user;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface userDao {
    public void addUser(user user);

    // 根据用户名查询用户
    // 注解的两个参数会自动封装成map集合，括号内即为键

    public user findByUsername(@Param("name") String name);
    //user Regist(user username,user password);
//    user Login(user username,user password);
//    user changePWD(user username,user password);
//    user getBalance(user username,user balance);
//    user getPoint(user username,user rewordPoint);
}
