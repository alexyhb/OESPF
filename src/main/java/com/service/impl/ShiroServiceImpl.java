package com.service.impl;

import com.dao.ShiroDao;
import com.pojo.User;
import com.service.ShiroService;
import org.apache.shiro.authz.Permission;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ShiroServiceImpl implements ShiroService {

    @Autowired
    private ShiroDao shiroDao;

    public User getUserByUserName(String username) {
        //根据账号获取账号密码
        User user=new User();
//        User userByUserName = shiroDao.getUserByUserName(username);
        return user;
    }

    public List<Permission> getPermissionsByUser(User user) {
        //获取到用户角色userRole
//        List<Integer> roleId = shiroDao.getUserRoleByUserId(user.getId());
        List<Permission> perArrary = new ArrayList<>();

//        if (roleId!=null&&roleId.size()!=0) {
//            //根据roleid获取peimission
//            for (Integer i : roleId) {
////                perArrary.addAll(shiroDao.getPermissionsByRoleId(i));
//            }
//        }

        System.out.println(perArrary);
        return perArrary;
    }


}

