package com.dao;
import com.pojo.Courses;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;


public interface CoursesDao {
    boolean addCourses(@Param("coursesName") String coursesName,@Param("examType") int examType,@Param("coursesLength") int coursesLength,@Param("coursesNumber") int coursesNumber,@Param("money") BigDecimal money);
    boolean deleteCourses(int id);
    Courses getSpInfo(int id);
    List<Courses> getCousesListByType(int examType);


}
