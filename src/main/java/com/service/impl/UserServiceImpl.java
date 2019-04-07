package com.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.pojo.UserReSult;
import com.pojo.user;
import com.pojo.userMapper;
@Service
public class UserServiceImpl {
@Resource
    private userMapper userMapper;
        public UserReSult login(String name){
                UserReSult result=new UserReSult();
                user user=userMapper.login(name);
                if (user==null) {
                    result.setStatus(1);
                    result.setMsg("用户名不存在");
                    return result;
                }
                //登录成功之后
                result.setStatus(0);
                result.setMsg("成功登录");
                result.setData(user);
                return result;

        }
}
