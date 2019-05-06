package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.service.CoursesPointService;
import com.service.impl.CoursesPointServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "coursesPoint")
public class CoursesPointController {
    @Autowired
    CoursesPointServiceImpl coursesPointService;

    @ResponseBody
    @RequestMapping(value = "addPoint" ,method = RequestMethod.POST)
    public String addPoint(@RequestParam ("userId")int userId, @RequestParam ("coursesId") int coursesId){
        JSONObject json =new JSONObject();
        String data=coursesPointService.addPoint(userId,coursesId,2);
        json.put("data",data);
        return json.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/getPoint",method=RequestMethod.POST)
    public String getPoint(@RequestParam("userId") int userId , @RequestParam("coursesId") int coursesId){
        JSONObject json=new JSONObject();
        String data=coursesPointService.getPointById(userId,coursesId);
        json.put("data",data);
        return json.toJSONString();
    }

}
