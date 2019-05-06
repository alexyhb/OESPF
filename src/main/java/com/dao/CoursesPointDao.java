package com.dao;


import com.pojo.CoursesPoint;
import org.apache.ibatis.annotations.Param;

public interface CoursesPointDao {
    String findByIds(@Param("UserId") int UserId, @Param("coursesId") int coursesId);
    boolean addPoint(@Param("userId") int userId,@Param("coursesId") int coursesId,@Param("coursesPoint") int coursesPoint);
    boolean losePoint(@Param("userId") int userId,@Param("coursesId") int coursesId,@Param("coursesPoint") int coursesPoint);
}
