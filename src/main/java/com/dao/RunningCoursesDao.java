package com.dao;

import com.pojo.RunningCourses;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RunningCoursesDao {
    /**
     *  private int id;
     *     private int userId;
     *     private int coursesId;
     *     private int totalNumber;
     *     private int currentNumber;
     */
    boolean joinIn(@Param("username") String username,@Param("coursesId") int coursesId);
    RunningCourses queryInfo(@Param("username") String username,@Param("coursesId") int coursesId);
    boolean updateCnumber(@Param("username") String username,@Param("coursesId") int coursesId);
}
