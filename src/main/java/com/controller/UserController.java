package com.controller;

import com.pojo.User;
import com.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.security.pkcs11.Secmod;

import java.lang.reflect.Array;


@Repository
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/Login")
    public String list(Model model) {
        User user = userServiceImpl.Login("username");

                model.addAttribute("user", user);
        return "Login";
    }

}
