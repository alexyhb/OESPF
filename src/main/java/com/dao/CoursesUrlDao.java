package com.dao;


import com.pojo.CoursesUrl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CoursesUrlDao {
    CoursesUrl getByid(@Param("coursesId")int coursesId, @Param("currentNumber")int currentNumber);
    boolean addLecture(@Param("coursesId")int coursesId, @Param("totalNumber")int totalNumber,@Param("currentNumber")int currentNumber,@Param("url")String url,@Param("lectureName") String lectureName);
    boolean deleteLecture(@Param("coursesId")int coursesId,@Param("currentNumber")int currentNumber );
    boolean setLecture(@Param("coursesId")int coursesId,@Param("currentNumber")int currentNumber,@Param("url")String url,@Param("lectureName") String lectureName);
    List<CoursesUrl> getListById(int coursesId);
}
