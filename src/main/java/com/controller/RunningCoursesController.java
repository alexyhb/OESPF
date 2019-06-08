package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.service.impl.RunningCoursesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/RNcourses")
public class RunningCoursesController {
    @Autowired
    RunningCoursesServiceImpl runningCoursesService;

    @ResponseBody
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public String queryInfo(@RequestParam("coursesId") int coursesId,@RequestParam("username") String username){
        JSONObject json=runningCoursesService.queryInfo(username,coursesId);



        return json.toJSONString();

    }
}
