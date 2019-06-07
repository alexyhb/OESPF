package com.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pojo.Courses;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface CoursesService {
    JSONObject getCoursesInfoByName(int id);
    String addCourses(@Param("coursesName") String coursesName, @Param("examType") int examType, @Param("coursesLength") int coursesLength, @Param("coursesNumber") int coursesNumber, @Param("money") BigDecimal money);
    String deleteCourses(Courses courses);
    JSONArray getCousesList(String name);
    JSONArray getCousesList(int type,int number);
}
