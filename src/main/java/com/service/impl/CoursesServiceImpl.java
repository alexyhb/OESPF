package com.service.impl;

import com.dao.CoursesDao;
import com.pojo.Courses;
import com.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoursesServiceImpl implements CoursesService {
    private final CoursesDao coursesDao;

    @Autowired
    public CoursesServiceImpl(CoursesDao coursesDao) {
        this.coursesDao = coursesDao;
    }

    @Override
    public Courses getCousesInfoByname(String name) {
        return null;
    }

    @Override
    public Courses getCoursesInfoById(int id) {
        return null;
    }

    @Override
    public Courses setCourses(Courses courses) {
        return null;
    }

    @Override
    public void deleteCourses(Courses courses) {

    }
}

