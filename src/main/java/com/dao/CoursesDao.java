package com.dao;
import com.pojo.Courses;

import java.math.BigDecimal;
import java.util.List;


public interface CoursesDao {
    Courses getCousesInfoByname(String coursesName);
    Courses setCourses(Courses courses);
    void addCourses(String coursesName, int examType, int coursesLength, int coursesNumber, BigDecimal money);
    void deleteCourses(int id);
    List<Courses> getCousesListByType(String examType);
    List<Courses> getCousesListByName(String name);
}
