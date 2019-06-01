package com.service.impl;



import com.alibaba.fastjson.JSONObject;
import com.dao.UserDao;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pojo.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private  UserDao userDao;




    @Override
    public String Login(String username, String password) {
        JSONObject result = new JSONObject();

        if ("".equals(username) || "".equals(password)) {
            result.put("code","400");
            result.put("msg","用户名或密码不能为空");
            return result.toJSONString();
        }
        List<User> list = userDao.getUserList(username);
        if (list.size() == 0) {
            result.put("code","400");
            result.put("msg","密码或用户名错误");

        } else {
            if (!password.equals(list.get(0).getPassword())) {
                result.put("code","400");
                result.put("msg","密码或用户名错误");

            }else {
                result.put("code","200");
                result.put("msg","登录成功");

            }
        }
        return result.toJSONString();

    }


    @Override

    public User findById(int id) {
        return userDao.findById(id);
    }
    @Override
    public String Register(String userName,String password,int role) {
        JSONObject json = new JSONObject();
        User user =new User();
        if ("".equals(userName) || "".equals(password)||"".equals(role)) {
            json.put("code","400");
            json.put("msg","用户名或密码不能为空");
            return json.toJSONString();
            }
        List<User> list = userDao.getUserList(userName);
        if (list.size() != 0) {
            json.put("code","400");
            json.put("msg","该用户名已存在");

        } else {
            user.setUsername(userName);
            user.setPassword(password);
            user.setRole(role);
            user.setRewardPoint(0);
            user.setBalance(0);
            userDao.addUser(user);
            List<User> list2=userDao.getUserList(userName);
            if(list2.size()==0){
                json.put("code","400");
                json.put("msg","未知错误发生");
            }else{
                json.put("code","200");
                json.put("msg","注册成功");
            }


        }
        return json.toJSONString();
    }


    @Override
    public String getByUsername(String username) throws Exception {



        return "1";
    }



    @Override
    public User changePsd(String username, String password) {
        return userDao.changePsd(username,password);
    }

    @Override
    public String getBalance(String username) {
        JSONObject json=new JSONObject();
        json.put("msg","");
        json.put("code","");
        if("".equals(username)){
            json.put("msg","fail");
            json.put("code","400");
        }else{
            List<User> list = userDao.getUserList(username);
            if(list.size()==0){
                json.put("msg","user didn't exist");
                json.put("code","400");
            }else{
                String user=userDao.getBalance(username);
                json.put("msg","sucess");
                json.put("code","400");
                json.put("data",user);
            }
        }

        return json.toJSONString();
    }

    @Override
    public String getPoint(String username) {
        JSONObject json=new JSONObject();
        userDao.getPoint(username);
        return json.toJSONString();

    }

    @Override
    public List<User> getUserList(String userName) {
        return userDao.getUserList(userName);
    }
}
