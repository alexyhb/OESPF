package com.service.impl;

import com.ResponseResult;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dao.CoursesDao;
import com.pojo.Courses;
import com.service.CoursesService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

@Service
public class CoursesServiceImpl implements CoursesService {
    @Autowired
    private  CoursesDao coursesDao;





    @Override
    public String getCoursesInfoById(int id) {

        JSONObject json=new JSONObject();

        return json.toJSONString();
    }

    @Override
    public String addCourses( String coursesName,int examType, int coursesLength, int coursesNumber, BigDecimal money) {
        JSONObject json=new JSONObject();
        boolean flag=coursesDao.addCourses(coursesName,examType,coursesLength,coursesNumber,money);
        ResponseResult responseResult=new ResponseResult(flag);



        return json.toJSONString();

    }


    @Override
    public String deleteCourses(Courses courses) {
        JSONObject json=new JSONObject();

        return json.toJSONString();
    }

    @Override
    public JSONArray getCousesList(String name) {
        return null;
    }

    @Override
    public JSONArray getCousesList(String type, int number) {
        return null;
    }


}

