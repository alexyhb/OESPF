package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.service.impl.ClockinServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/clockin")
public class ClockinController {
    ClockinServiceImpl clockinService=new ClockinServiceImpl();


    @ResponseBody
    @RequestMapping(value = "/addOne" ,method = RequestMethod.POST)
    public String clockin(@RequestParam("userId") int userId , @RequestParam("coursesId") int coursesId ){
        JSONObject json=new JSONObject();


        return json.toJSONString();
    }



}
