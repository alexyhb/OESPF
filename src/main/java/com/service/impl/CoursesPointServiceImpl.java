package com.service.impl;

import com.ResponseResult;
import com.alibaba.fastjson.JSONObject;
import com.dao.CoursesPointDao;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.service.CoursesPointService;
import com.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoursesPointServiceImpl implements CoursesPointService {
    @Autowired
    CoursesPointDao coursesPointDao;


    @Override
    public String getPointById(int userId, int coursesId) {
        JSONObject json =new JSONObject();
        ResponseResult responseResult;

        String data =coursesPointDao.findByIds(userId,coursesId);
        System.out.println(data);

        if("".equals(data)){
            responseResult=new ResponseResult("no data");
        }else {
            responseResult =new ResponseResult("200","succuss",data);

        }
        json.put("data",responseResult);

        return json.toJSONString();
    }

    @Override
    public String addPoint(int userId, int coursesId, int CoursesPoint) {
        JSONObject json =new JSONObject();
        ResponseResult responseResult;
        boolean flag =coursesPointDao.addPoint(userId, coursesId, CoursesPoint);
        responseResult=new ResponseResult(flag);
        json.put("data",responseResult);
        return json.toJSONString();
    }

    @Override
    public String losePoint(int userId, int coursesId, int CoursesPoint) {
        JSONObject json =new JSONObject();
        ResponseResult responseResult;
        boolean flag=coursesPointDao.losePoint(userId, coursesId, CoursesPoint);
        responseResult=new ResponseResult(flag);
        json.put("data",responseResult);
        return json.toJSONString();
    }
}
