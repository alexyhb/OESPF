package com.service;

import com.ResponseResult;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pojo.Courses;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface CoursesService {
    JSONObject getCoursesInfoByName(int id);
    ResponseResult addCourses(@Param("coursesName") String coursesName,@Param("img") String img, @Param("text") String text, @Param("examType") int examType, @Param("coursesLength") int coursesLength, @Param("coursesNumber") int coursesNumber, @Param("money") BigDecimal money, @Param("teachBy") String teachBy);
    ResponseResult setCourses(@Param("id")int id,@Param("coursesName") String coursesName,@Param("img") String img, @Param("text") String text, @Param("examType") int examType, @Param("coursesLength") int coursesLength, @Param("coursesNumber") int coursesNumber, @Param("money") BigDecimal money, @Param("teachBy") String teachBy);
    String deleteCourses(Courses courses);
    JSONArray getCousesList(String name);
    JSONArray getCousesList(int type,int number);
    JSONObject getAll();
}
