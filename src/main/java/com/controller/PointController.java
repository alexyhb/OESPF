package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.service.impl.PointServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/point")
public class PointController {
    @Autowired
    PointServiceImpl pointService;
    @ResponseBody
    @RequestMapping(value = "/addPoint" ,method= RequestMethod.POST)
    public String addPoint(@RequestParam("userId") int userId){
        JSONObject json=new JSONObject();
        String data=pointService.addPoint(userId,2);
        json.put("data",data);
        return json.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/losePoint",method=RequestMethod.POST)
    public String losePoint(@RequestParam("userId") int userId){
        JSONObject json=new JSONObject();
        String data=pointService.losePoint(userId,2);
        json.put("data",data);
        return json.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/getPoint",method=RequestMethod.POST)
    public String getPoint(@RequestParam("userId") int userId){
        JSONObject json=new JSONObject();
        String data=pointService.findPoint(userId);
        json.put("data",data);
        return json.toJSONString();
    }
}
