package com.service.impl;
import javax.annotation.Resource;

import com.dao.UserDao;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pojo.User;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public User Register(String username, String password) {
        return userDao.Register(username,password);
    }


    @Override
    public User Login(String username) {
        return userDao.Login(username);
    }

    @Override
    public User changePsd(String username, String password) {
        return userDao.changePsd(username,password);
    }

    @Override
    public User getBalance(String username) {
        return userDao.getBalance(username);
    }

    @Override
    public User getPoint(String username) {
        return userDao.getPoint(username);
    }
}
