package com.service;

import com.pojo.Courses;

import java.util.List;

public interface CoursesService {
    Courses getCousesInfoByname(String name);
    Courses getCoursesInfoById(int id);
    void addCourses(Courses courses);
    void deleteCourses(Courses courses);
    List<Courses> getCousesList();
}
