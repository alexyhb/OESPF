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
import java.sql.Array;
import java.sql.SQLException;
import java.util.List;

@Service
public class CoursesServiceImpl implements CoursesService {
    @Autowired
    private  CoursesDao coursesDao;





    @Override
    public JSONObject getCoursesInfoByName(int id) {

        JSONObject json=new JSONObject();
        Courses courses=coursesDao.getSpInfo(id);
        System.out.println(courses);
        json.put("data",courses);
        return json;
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
    public JSONArray getCousesList(int type, int number) {
        JSONArray json=new JSONArray();
        List list=coursesDao.getCousesListByType(type);
        int j=list.size();
        for(int i=0;i<j;i++){
            json.add(list.toArray()[i]);
        }

        return json;
    }


}

