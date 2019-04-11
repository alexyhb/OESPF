package com.service;

import com.pojo.Courses;

public interface CoursesService {
    Courses getCousesInfoByname(String name);
    Courses getCoursesInfoById(int id);
    Courses setCourses(Courses courses);
    void deleteCourses(Courses courses);
}
