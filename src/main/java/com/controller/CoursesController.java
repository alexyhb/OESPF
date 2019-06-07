package com.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pojo.Courses;
import com.service.impl.CoursesServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "Courses")
public class CoursesController {
    @Autowired
    CoursesServiceImpl coursesService;

    @ResponseBody
    @RequestMapping(value="/addCourses" ,method=RequestMethod.POST)
    public String addCourses(@RequestParam("coursesName") String coursesName, @RequestParam("examType") int examType, @RequestParam("coursesLength") int coursesLength, @RequestParam("coursesNumber") int coursesNumber, @RequestParam("money") BigDecimal money){
        JSONObject json=new JSONObject();
        try {
            coursesService.addCourses(coursesName, examType, coursesLength, coursesNumber, money);
        }catch (Exception e){
            json.put("data",e);
        }
        return json.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/all/Courses",method = RequestMethod.GET)
    public String getAllCourses(){
        JSONArray json=new JSONArray();


        return json.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/typelist",method = RequestMethod.POST)
    public String getTypeList(@RequestParam("type") int type){
//        JSONObject json=new JSONObject();
        JSONArray json=coursesService.getCousesList(type,1);

//        json.add(json);

        return json.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/getSpInfo",method = RequestMethod.POST)
    public String getSpInfo(@RequestParam("id") int id ) {
        JSONObject json=coursesService.getCoursesInfoByName(id);


        return json.toJSONString();
    }
}
