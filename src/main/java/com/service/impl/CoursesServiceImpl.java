package com.service.impl;

import com.ResponseResult;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dao.CoursesDao;
import com.dao.CoursesUrlDao;
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
    public ResponseResult addCourses( String coursesName,String img,String text,int examType, int coursesLength, int coursesNumber, BigDecimal money,String teachBy) {
        JSONObject json=new JSONObject();
        boolean flag=coursesDao.addCourses(coursesName,img,text,examType,coursesLength,coursesNumber,money,teachBy);

        ResponseResult responseResult=new ResponseResult(flag);



        return responseResult;

    }

    @Override
    public ResponseResult setCourses(int id,String coursesName, String img, String text, int examType, int coursesLength, int coursesNumber, BigDecimal money, String teachBy) {

        boolean flag=coursesDao.setCourses(id,coursesName,img,text,examType,coursesLength,coursesNumber,money,teachBy);
        ResponseResult responseResult=new ResponseResult(flag);



        return responseResult;
    }


    @Override
    public String deleteCourses(Courses courses) {
        JSONObject json=new JSONObject();

        return json.toJSONString();
    }

    @Override
    public JSONArray getCousesList(String name) {
        JSONArray json=new JSONArray();
        List<Courses> list =coursesDao.getCoursesList();
        json.add(list);
        return json;
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

    @Override
    public JSONObject getAll() {
        JSONObject json=new JSONObject();
        List<Courses> list=coursesDao.getCoursesList();
        json.put("data",list);
        return json;
    }


}

