package com.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.dao.CoursesDao;
import com.pojo.Courses;
import com.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesServiceImpl implements CoursesService {
    @Autowired
    private  CoursesDao coursesDao;




    @Override
    public Courses getCousesInfoByname(String name) {
        return null;
    }

    @Override
    public Courses getCoursesInfoById(int id) {
        return null;
    }

    @Override
    public void addCourses(Courses courses) {


    }


    @Override
    public void deleteCourses(Courses courses) {

    }

    @Override
    public List<Courses> getCousesList() {

        return null;
    }
}

