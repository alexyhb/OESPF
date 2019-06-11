package com.service.impl;

import com.ResponseResult;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dao.CoursesUrlDao;
import com.pojo.Courses;
import com.pojo.CoursesUrl;
import com.service.CoursesService;
import com.service.CoursesUrlService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CoursesUrlServiceImpl implements CoursesUrlService {
    @Autowired
    CoursesUrlDao coursesUrlDao;


    @Override
    public JSONArray getUrlList(int coursesId) {
        JSONArray json=new JSONArray();
        List list=coursesUrlDao.getListById(coursesId);
        int k=list.size();
        if(k>=0) {

            for (int i = 0; i < k; i++) {
                json.add(list.toArray()[i]);
            }
        }else{
            json.add("404");
        }
        return json;

    }

    @Override
    public JSONObject getUrlbyId(int coursesId,int currentNumber) {
        JSONObject json=new JSONObject();
        CoursesUrl coursesUrl= coursesUrlDao.getByid(coursesId,currentNumber);
        List list=coursesUrlDao.getListById(coursesId);
        int k=list.size();
        if(k==0){
            json.put("code",400);
            json.put("data","no data");
        }else{
            json.put("code",200);
            json.put("data",coursesUrl);
        }
        return json;
    }

    @Override
    public ResponseResult addLecture(int coursesId, int totalNumber, int currentNumber, String url, String lectureName) {

        Boolean flag=coursesUrlDao.addLecture(coursesId,totalNumber,currentNumber,url,lectureName);
        ResponseResult responseResult=new ResponseResult(flag);
        return responseResult;
    }


    @Override
    public ResponseResult deleletLecture(int coursesId,int currentNumber) {
        Boolean flag=coursesUrlDao.deleteLecture(coursesId,currentNumber);
        ResponseResult responseResult=new ResponseResult(flag);
        return responseResult;
    }

    @Override
    public ResponseResult setLecture(int coursesId,int currentNumber,String url,String lectureName) {
        Boolean flag=coursesUrlDao.setLecture(coursesId,currentNumber,url,lectureName);
        ResponseResult responseResult=new ResponseResult(flag);
        return responseResult;
    }
}
