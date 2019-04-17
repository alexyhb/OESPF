package com.service.impl;
import javax.annotation.Resource;

import com.dao.UserDao;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pojo.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserDao userDao;
    private JSONPObject json;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
        json = new JSONPObject();
    }

    @Transactional
    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public User Register(String username, String password) {

        return userDao.Register(username,password);
    }
    @Override
    public String getByUsername(String username) throws Exception {



        return "1";
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
