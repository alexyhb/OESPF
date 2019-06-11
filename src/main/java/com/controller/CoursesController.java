package com.controller;

import com.ResponseResult;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pojo.Courses;
import com.service.impl.CoursesServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "Courses")
public class CoursesController {
    @Autowired
    CoursesServiceImpl coursesService;

    @ResponseBody
    @RequestMapping(value="/addCourses" ,method=RequestMethod.POST)
    public String addCourses(@RequestParam("coursesName") String coursesName,@RequestParam("img") String img,@RequestParam("text")String text,@RequestParam("teachBy") String teachBy, @RequestParam("examType") int examType, @RequestParam("coursesNumber") int coursesNumber, @RequestParam("money") BigDecimal money){
        JSONObject json=new JSONObject();
        try {
            ResponseResult st=coursesService.addCourses(coursesName,img,text ,examType, 400, coursesNumber, money,teachBy);
            json.put("data",st);
        }catch (Exception e){
            json.put("data",e);
        }
        return json.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/allCourses",method = RequestMethod.POST)
    public String getAllCourses(){
        JSONObject json=coursesService.getAll();


        return json.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/typelist",method = RequestMethod.POST)
    public String getTypeList(@RequestParam("type") int type){
//        JSONObject json=new JSONObject();
        JSONArray json=coursesService.getCousesList(type,1);

//        json.add(json);

        return json.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value = "/getSpInfo",method = RequestMethod.POST)
    public String getSpInfo(@RequestParam("id") int id ) {
        JSONObject json=coursesService.getCoursesInfoByName(id);


        return json.toJSONString();
    }
    @ResponseBody
    @RequestMapping(value = "/uploadpicture",method = RequestMethod.POST)
    public String upLoad(@RequestParam("file") MultipartFile file ,HttpServletRequest request)throws IOException {

        String path ="E:\\java\\OESPF\\src\\main\\webapp\\statics\\upload";
        // 得到文件的原始名称，如：美女.png
        String fileName = file.getOriginalFilename();
        File dir = new File(path, fileName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        //MultipartFile自带的解析方法
        file.transferTo(dir);
        JSONObject json=new JSONObject();
        json.put("data","../upload/"+fileName);
        return json.toJSONString();
    }

    @ResponseBody
    @RequestMapping(value="/setCourses" ,method=RequestMethod.POST)
    public String setCourses(@RequestParam("id")int id,@RequestParam("coursesName") String coursesName,@RequestParam("img") String img,@RequestParam("text")String text,@RequestParam("teachBy") String teachBy, @RequestParam("examType") int examType, @RequestParam("coursesNumber") int coursesNumber, @RequestParam("money") BigDecimal money){
        JSONObject json=new JSONObject();
        try {
            ResponseResult st=coursesService.setCourses(id,coursesName,img,text ,examType, 400, coursesNumber, money,teachBy);
            json.put("data",st);
        }catch (Exception e){
            json.put("data",e);
        }
        return json.toJSONString();
    }
}