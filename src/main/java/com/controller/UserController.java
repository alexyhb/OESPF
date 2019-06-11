package com.controller;

import com.ResponseResult;
import com.alibaba.fastjson.JSONObject;
import com.pojo.User;
import com.service.impl.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserServiceImpl userServiceImpl;

    /**
     *
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/Login",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public String login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) throws Exception{
        JSONObject json =new JSONObject();
        try{
            JSONObject loginInfo= userServiceImpl.Login(username,password);
            json.put("info",loginInfo);
            return json.toJSONString();
        }catch (Exception e){
            throw new IOException(e);
        }
    }

    /**
     *TEST FUNCTION
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/print",method = RequestMethod.POST)
    public String print(@RequestParam(value = "result") String result){

        JSONObject json=new JSONObject();
        json.put("result",result);
        return json.toJSONString();
    }



    /**
     *
     * @param userName
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getUserInfo" ,method = RequestMethod.POST)
    public String getUserInfo(@RequestParam("username") String userName ) {
        List<User> list= userServiceImpl.getUserList(userName);
        JSONObject json= new JSONObject();
        json.put("user", JSONObject.toJSON(list));
        return json.toJSONString();
    }

    /**
     *
     * @param userName
     * @param password
     * @param userRole
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/regist",method =RequestMethod.POST)
    public String regist(@RequestParam("username")String userName,@RequestParam("password") String password,@RequestParam("role")int userRole){
        JSONObject json=new JSONObject();
        json=userServiceImpl.Register(userName,password,userRole);

        return json.toJSONString();
    }

    /**
     *
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/getBalance",method =RequestMethod.POST)
    public String getBalance(@RequestParam("username")String username){
        JSONObject json=new JSONObject();
        String user=userServiceImpl.getBalance(username);
        json.put("user",JSONObject.toJSON(user));
        return json.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/addBalance",method=RequestMethod.POST)
    public String addBalance(@RequestParam("username")String username, @RequestParam("balance")BigDecimal balance){
        JSONObject json=new JSONObject();
        ResponseResult re =userServiceImpl.inBalance(username,balance);
        json.put("data",re);
        return json.toJSONString();
    }

}
