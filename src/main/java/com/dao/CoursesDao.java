package com.dao;
import com.pojo.Courses;


public interface CoursesDao {
    Courses getCousesInfoByname(String name);
    Courses getCoursesInfoById(int id);
    Courses setCourses(Courses courses);
    void deleteCourses(Courses courses);
}
