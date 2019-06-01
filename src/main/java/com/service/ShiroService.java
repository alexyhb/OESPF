package com.service;

import com.pojo.User;
import org.apache.shiro.authz.Permission;

import java.util.List;

public interface ShiroService {
    public User getUserByUserName(String username);
    public List<Permission> getPermissionsByUser(User user);
}
