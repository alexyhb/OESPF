package com.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pojo.Courses;
import com.service.impl.CoursesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "Courses")
public class CoursesController {
    @Autowired
    CoursesServiceImpl coursesService;


    @ResponseBody
    @RequestMapping(value = "/all/Courses",method = RequestMethod.GET)
    public String getAllCourses(){
        JSONArray json=new JSONArray();
        List<Courses> courses=coursesService.getCousesList();
        courses.toArray();
        json.addAll(courses);
        return json.toJSONString();
    }

}
