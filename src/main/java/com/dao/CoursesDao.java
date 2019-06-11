package com.dao;
import com.pojo.Courses;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;


public interface CoursesDao {
    boolean addCourses(@Param("coursesName") String coursesName,@Param("img") String img,@Param("text") String text,@Param("examType") int examType,@Param("coursesLength") int coursesLength,@Param("coursesNumber") int coursesNumber,@Param("money") BigDecimal moeny,@Param("teachBy")String teachBy);
    boolean deleteCourses(int id);
    boolean setCourses(@Param("id")int id,@Param("coursesName") String coursesName,@Param("img") String img, @Param("text") String text, @Param("examType") int examType, @Param("coursesLength") int coursesLength, @Param("coursesNumber") int coursesNumber, @Param("money") BigDecimal money, @Param("teachBy") String teachBy);
    Courses getSpInfo(int id);
    List<Courses> getCousesListByType(int examType);
    List<Courses> getCoursesList();


}
